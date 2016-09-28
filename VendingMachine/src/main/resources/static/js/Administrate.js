/**
 * Created by walter on 9/14/16.
 */
$(document).ready(function(){

    loadList();

    $('#editModal').on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var itemId = element.data('item-id');
        var modal = $(this);
        $.ajax({
            type: 'GET',
            url: itemId
        }).success(function (item) {
            modal.find('#item-id').text(item.name);
            modal.find('#edit-itemname').val(item.name);
            modal.find('#edit-price').val(item.cost);
            modal.find('#edit-stock').val(item.stock);
            modal.find('#edit-id').val(item.id);
        });
    });
    $('#edit-button').click(function(event){
        event.preventDefault();
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
        $.ajax({
            type: 'PUT',
            url: 'edit',
            data: JSON.stringify({
                id: $('#edit-id').val(),
                name: $('#edit-itemname').val(),
                cost: $('#edit-price').val(),
                stock: $('#edit-stock').val()
            }),
            dataType: 'json',
            contentType: "application/json; charset=utf-8"
        }).success(function(){
            location.href="administrate"
        });
    });
});

function loadList() {
    clearTable();
    $.getJSON("items", function (data){
        $.each(data._embedded.items, function (index, Item){
            $("#putHere").append($('<tr>')
                .append($('<td>')
                .text(Item.name))
                .append($('<td>').text(Item.cost))
                .append($('<td>').text(Item.stock))
                .append ($('<td>')
                    .append ($('<a>')
                        .attr({
                            'data-item-id':Item._links.item.href,
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')
                    ) //<a> tag
                )//<td> tag
            )
        });

    });
}
function clearTable() {
    $("#putHere").empty();
}

