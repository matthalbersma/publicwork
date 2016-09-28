$(document).ready(function () {
    loadStatic();


    $('.dropdown-toggle').dropdown()

    $('#goLive').datetimepicker().css;
    $('#expire').datetimepicker().css;

    loadPending();
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
        }).modal({backdrop: 'static', keyboard: true});
    });
    $('#saveEdit').click(function (event) {
        event.preventDefault();
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
        var postnum = post.postId;
        var tagSplit = post.allTags.split(",");
        for (var i = 0; i < tagSplit.length - 1; i++) {
            hTags.push(tagSplit[i]);
        }
        blogPost
                .append($('<div class="row">')
                        .append($(' <div class="col-xs-12 contentHolder" id="contentHolder">')
                                .append($('<h4 id="title">')
                                        .text(post.title))
                                .append($('<div id="content"><span> ' + body + '</span><br><br><hr>')
                                        )
                                .append($('<span class="input-group-btn postBtns">')
                                        .append($('<button class="btn btn-default" type="button" id="editBtn">edit</button>')
                                                .attr({
                                                    'onClick': 'editPost(' + postnum + ')'
                                                }))
                                        .append($('<button class="btn btn-default" type="button" id="deleteBtn">delete</button>')
                                                .attr({
                                                    'onClick': 'deletePost(' + postnum + ')'
                                                })))
                                ));
    });
    objectify(hTags);

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

function editPost(id) {

    $('#editSummerNote').summernote({
        height: 315,
        focus: true
    });

    $.getJSON('post/' + id, function (data) {
        var postNum = data.postId;
        var goLiveEdit;
        var expireEdit;
        if (data.goLive !== null) {
            goLiveEdit = data.goLive.replace(/-/g, "/");
        }
        if (data.expire !== null) {
            var expireEdit = data.expire.replace(/-/g, "/");
        }
        var status = data.status;
        $('#editSummerNote').summernote('code', data.content);
        $('#goLive').val(goLiveEdit);
        $('#expire').val(expireEdit);
        $('#teamTitle').val(data.title);
        var selectMe = $('#statusMenu option');
        for (var i = 0; i < selectMe.length; i++) {
            if (selectMe[i].value === status) {
                selectMe[i].selected = true;
                break;
            }

        }
        $('#saveEdit').attr({
            'onClick': 'saveEditPost(' + postNum + ')'
        });


    });
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

function saveEditPost(id) {
    var markup = $('#editSummerNote').summernote('code');
    var status = $('#statusMenu').val();
    var goLivepre = $('#goLive').val();
    var title = $('#teamTitle').val();
    //var title = $('#teamTitle').val();
    var goLive;
    var expire;
    if (goLivepre.length !== 0) {

        goLive = goLivepre.replace(/\//g, '-');
    }
    ;
    var expirepre = $('#expire').val();
    if (expirepre.length !== 0) {
        expire = expirepre.replace(/\//g, '-');
    }
    if (title === null || title === "" && status === ("Static")) {
        $('#teamTitle').tooltip('show');

        return;
    }
    $.ajax({
        type: 'POST',
        url: 'post/' + id,
        data: JSON.stringify({
            content: markup,
            goLive: goLive,
            expire: expire,
            status: status,
            title: title

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


function loadPending() {
    $.getJSON('pendNum', function (data) {
        var numPending = data;
        $('#pendingNum').append('<a onClick="pendingPost()"><h2>You have ' + numPending + ' post(s) to approve.</h2></a>');
        loadExpired();
        

    });





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
    function loadExpired() {
        $.getJSON('expiredNum', function(data) {
            var expired=data;
         $('#pendingNum').append('<a onClick="expiredPosts()"><h2>You have ' + expired + ' expired post(s) to review.</h2></a><a onClick="staticPosts()"><h2>Click to manage static pages.</h2></a>');
        });
    }
    function pendingPost() {
                $.getJSON("pendingPosts", function (data) {
        clearPosts();           
        getPosts(data);
    });
}
function expiredPosts() {
    $.getJSON("expiredPosts", function (data){
        clearPosts();
        getPosts(data);
    });
}
function staticPosts() {
    $.getJSON("staticPost", function (data) {
                clearPosts();
        getPosts(data);
    });
}


