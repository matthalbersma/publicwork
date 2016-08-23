$(document).ready(function () {
    $('#summernote').summernote({
        height: 300,
        focus: true
    });
});
$('#postit').click(function () {
    var markup = $('#summernote').summernote('code');
    var status = $('#statusMenu').val();
    var goLivepre = $('#goLive').val();
    var title = $('#teamTitle').val();
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
    if (title===""&&status===("Static")){
        $('#teamTitle').tooltip('show');
        return;
    }
    console.log(markup);
    $.ajax({
        type: 'POST',
        url: 'addcontent',
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
});