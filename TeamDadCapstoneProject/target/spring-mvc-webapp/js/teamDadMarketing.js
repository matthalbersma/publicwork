$(document).ready(function () {
    loadStatic();

    $('.dropdown-toggle').dropdown()

    $('#goLive').datetimepicker().css;
    $('#expire').datetimepicker().css;

    $('#summernote').summernote({
        height: 300,
        focus: true
    });


    loadPosts();
    $('#searchBtn').click(function () {
        mySearch($('#searchField').val());
    });
    $("#contentDiv").on("click", "#editBtn", function () {



        $('#summernote').summernote({
            height: 300,
            focus: true
        });

        $("#editModal").fadeIn(280, function () {
        }).modal({backdrop: 'false', keyboard: true});
    });


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

function editPost(id) {

    $('#editSummerNote').summernote({
        height: 315,
        focus: true
    });

    $.getJSON('post/' + id, function (data) {

        var postNum = data.postId;
        var goLiveEdit = data.goLive.replace(/-/g, "/");
        var expireEdit = data.expire.replace(/-/g, "/");
        $('#editSummerNote').summernote('code', data.content);
        $('#goLive').val(goLiveEdit);
        $('#expire').val(expireEdit);
        $('#saveEdit').attr({
            'onClick': 'saveEditPost(' + postNum + ')'
        });


    });
}


function clearPosts() {
    $('#contentDiv').empty();
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

function saveEditPost(id) {
    var markup = $('#editSummerNote').summernote('code');
    var goLivepre = $('#goLive').val();
    var goLive = goLivepre.replace(/\//g, '-');
    var expirepre = $('#expire').val();
    var expire = expirepre.replace(/\//g, '-');
    console.log(markup);
    $.ajax({
        type: 'POST',
        url: 'post/' + id,
        data: JSON.stringify({
            content: markup,
            goLive: goLive,
            expire: expire
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        location.href = "home";
    }
    );
}


$('#postit').click(function () {
    var markup = $('#summernote').summernote('code');
    var status = "Pending";
    var goLivepre = $('#goLive').val();
    var goLive;
    var expire;
    if (goLivepre.length === 0) {
        goLive = "1950-01-01 12:00:00";
    } else {
        goLive = goLivepre.replace(/\//g, '-');
    }
    var expirepre = $('#expire').val();
    if (expirepre.length === 0) {
        expire = "3000-01-01 12:00:00";
    } else {

        expire = expirepre.replace(/\//g, '-');
    }
    console.log(markup);
    $.ajax({
        type: 'POST',
        url: 'addcontent',
        data: JSON.stringify({
            content: markup,
            goLive: goLive,
            expire: expire,
            status: status
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'

    }).success(function () {
        location.href = "home";
    }
    );
});

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