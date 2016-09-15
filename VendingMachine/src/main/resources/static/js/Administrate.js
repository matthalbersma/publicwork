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
