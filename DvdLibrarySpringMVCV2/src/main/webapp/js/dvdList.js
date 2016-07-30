/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    loadDVD();

    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'adddvd',
            data: JSON.stringify({
                title: $('#title').val(),
                releaseDate: $('#year').val(),
                mpaaRating: $('#Rating').val(),
                director: $('#addDirector').val(),
                userRating: $('#addNotes').val(),
                coverURL: $('#addURL').val(),
                imdbID: $('#addIMDB').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {

            loadDVD();
            $('#title').val("");
            $('#year').val("");
            $('#Rating').val("");
            $('#addDirector').val("");
            $('#addNotes').val("");
            $('#addURL').val("");
            $('#addIMDB').val("");
            $('#search').val("");
            $('#searchResults').empty();
        });
    });
    $('#edit-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-id').val(),
            data: JSON.stringify({
                title: $('#edit-title').val(),
                releaseDate: $('#edit-year').val(),
                mpaaRating: $('#edit-rating').val(),
                director: $('#edit-director').val(),
                userRating: $('#edit-notes').val(),
                coverURL: $('#edit-url').val(),
                imdbID: $('#edit-imdb').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadDVD();
        });

    });
    $('#search-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'searchresults',
            data: JSON.stringify({
                title: $('#search-title').val(),
                releaseDate: $('#search-year').val(),
                mpaaRating: $('#search-rating').val(),
                director: $('#search-director').val(),
                imdbID: $('#search-imdb').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function(data, status){
            $('#search-title').val("");
            $('#search-year').val("");
            $('#search-rating').val("");
            $('#search-director').val("");
            $('#search-imdb').val("");
            fillList(data);
        });
    });


});


function loadDVD() {
    //clear out the results div
    clearDvds();

    $.getJSON("dvds", function (data) {
        fillList(data);
    });
}
function fillList(data){
    clearDvds();
    var myDiv = $("#displaybody");
            $.each(data, function (index, DVD) {
            myDiv.append($('<div>').attr({'class': 'col-lg-2 col-md-3 col-sm-6 col-xs-12', 'id': 'imageHold'})
                    .append($('<div>').attr({'class': 'hovereffect'})
                            .append($('<img src=' + DVD.coverURL + '>').attr({'class': 'img-responsive'}))
                            .append($('<div>').attr({'class': 'overlay'})
                                    .append($('<h2>Options</h2>'))
                                    .append($('<a>').attr({
                                        'class': 'info',
                                        'onclick': 'deleteDVD(' + DVD.id + ')'}).text('Delete'))
                                    .append($('<br>'))
                                    .append($('<a>').attr({
                                        'class': 'info',
                                        'data-dvd-id': DVD.id,
                                        'data-toggle': 'modal',
                                        'href': '#editModal'}).text('Edit'))
                                    .append($('<br>'))
                                    .append($('<a>').attr({
                                        'class': 'info',
                                        'data-dvd-id': DVD.id,
                                        'data-toggle': 'modal',
                                        'href': '#infoModal'}).text('Info')))));
        });
}

function clearDvds() {
    $("#displaybody").empty();
}

function deleteDVD(id) {
    var answer = confirm("Are you sure you want to delete this movie?");
    if (answer == true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id

        }).success(function () {
            loadDVD();
        });
    }
}


$('#infoModal').on('shown.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdID = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdID
    }).success(function (DVD) {
        modal.find('#dvd-title').text(DVD.title),
                modal.find('#release-year').text(DVD.releaseDate),
                modal.find('#mpaa-rating').text(DVD.mpaaRating),
                modal.find('#info-director').text(DVD.director),
                modal.find('#user-notes').text(DVD.userRating);
    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdID = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdID
    }).success(function (DVD) {
        modal.find('#edit-title').val(DVD.title);
        modal.find('#edit-year').val(DVD.releaseDate),
                modal.find('#edit-rating').val(DVD.mpaaRating);
        modal.find('#edit-director').val(DVD.director);
        modal.find('#edit-imdb').val(DVD.imdbID);
        modal.find('#edit-url').val(DVD.coverURL);
        modal.find('#edit-notes').val(DVD.userRating);
        modal.find('#edit-id').val(DVD.id);
    });
});