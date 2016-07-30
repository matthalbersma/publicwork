

function render() {
    clearContents();
    var search = $("#search").val();
    $.getJSON("http://omdbapi.com/?s=" + search, function (data) {
        $.each(data, function (i, field) {
            if (i === "Search") {
                var title;
                var imdb;
                var year;
                for (var b = 0; b < data.Search.length; b++) {
                    title = data.Search[b].Title;
                    imdb = data.Search[b].imdbID;
                    year = data.Search[b].Year;
                    $("#searchResults").append($("<span>").css({'font-weight': 'bold'})
                                       .append("<br>"+title))
                                       .append("<br>" + year + "<br> <button class='btn btn-default' onclick=again('" + imdb + "')>Add to Form</button>");
                }
            }
        });
    });
}
function again(imdb) {
    $.getJSON("http://omdbapi.com/?i=" + imdb, function (result) {
        $("#title").val(result.Title);
        $("#year").val(result.Year);
        $("#Rating").val(result.Rated);
        $("#addDirector").val(result.Director);
        $("#addIMDB").val(result.imdbID);
        $("#addURL").val(result.Poster);
        $("#addNotes").val(result.Plot);
    });

}
function clearContents(){
    $('#searchResults').empty();
}