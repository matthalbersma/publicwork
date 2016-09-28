$(document).ready(function () {
    loadStatic();
    loadPosts();

    $('#searchBtn').click(function () {
        mySearch($('#searchField').val());
    });

    $('.dropdown-toggle').dropdown();
});


function loadPosts() {
    clearPosts();
    var blogPost = $('#contentDiv');
    $.getJSON("posts", function (data) {

        getPosts(data);
    });
}

function getPosts(data) {
    var blogPost = $('#contentDiv');
    var hTags = [];
    $.each(data, function (index, post) {
        var body = post.content;
        var tagSplit = post.allTags.split(",");
        for (var i = 0; i < tagSplit.length - 1; i++) {
            hTags.push(tagSplit[i]);
        }


        blogPost
                .append($('<div class="row">')
                        .append($(' <div class="col-xs-12 contentHolder" id="contentHolder">')
                                .append($('<h4 id="title">')
                                        .text(post.title)

                                        )
                                .append($('<div id="content"><span> ' + body + '</span><br><br><hr>')
                                        )));

    });
    objectify(hTags);

}

function loadStatic() {
    $.getJSON('staticPost', function (data) {
        $.each(data, function (index, post) {
            var titles = post.title;
            var postId = post.postId;
            $('#dropMen')
                    .append($('<li id="' + postId + '">')
                            .append('<a onClick="displayStatic(' + postId + ')">' + titles + '</a>'));
        });
    });
}

function deletePost(id) {
    var answer = confirm("Are you sure you want to delete this post?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'post/' + id
        }).success(function () {
            loadPosts();
        });
    }
}

function clearPosts() {
    $('#contentDiv').empty();
    $('.tagsDiv').empty();
}
function mySearch(searchTerm) {
    $.ajax({
        type: 'POST',
        url: 'search',
        data: JSON.stringify({
            term: searchTerm
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'


    })
            .success(function (data) {
                clearPosts();
                getPosts(data);
            });

}
function displayStatic(id) {
    clearPosts();

    $.getJSON('post/' + id, function (data) {
        $('#contentDiv').append('<span>' + data.content + '</span>');
        var id = "#" + data.postId;
        $(id).attr({
            'class': "active"});
    });
}
function objectify(hTags) {
    var hashlist = {};
    for (var i = 0; i < hTags.length; i++) {
        hashlist[hTags[i]] = (hashlist[hTags[i]] || 0) + 1;
    }
    ;
    var hashList = [];
    for (var key in hashlist)
        hashList.push([key, hashlist[key]]);
    hashList.sort(function (a, b) {
        a = a[1];
        b = b[1];
        if (a < b) {
            return 1;
        }
        if (a > b) {
            return -1;
        }
        return 0;
    });
    for (var j = 0; j < hashList.length; j++) {
        $('.tagsDiv').append(hashList[j][0])
                .append('(' + hashList[j][1] + ')<br>');

    }
}