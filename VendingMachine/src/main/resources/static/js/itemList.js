/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadItems();

    $("#purchase-button").click(function (){

        var id=$("#purchase-id").val();
        var purchase=$("#inputCash").val();
        purchase=parseFloat(purchase);
        $.ajax({
            type: 'POST',
            url: 'vend/'+id,
            data: JSON.stringify({
                dollars : purchase
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'text',
            success: (function (data){
            $("#addChange").text('Your change is '+data+'.');

        }),

        })


    });



});












function loadItems() {
    $.getJSON("items", function (data) {
        console.log(data);
        $.each(data._embedded.items, function (index, Item) {
            var n = Item.cost;
            var stock =Item.stock;
            n = n.toFixed(2);
            switch (Item.name) {
                case "Pepsi":


                    if (stock<=0){
                        $("#text").append('Were out of ' +Item.name);
                    }
                    else {
                        $("#text").append('' + Item.name + ' is $' + n + '')
                            .append('<br>')
                            .append($('<button>')
                                .attr({
                                    'class': 'btn btn-primary'
                                })
                                .attr('onclick', 'vend("'+Item.id+'")')
                                .text('Buy me!')
                            )

                    }
                    break;
                case "Coke":
                    if (stock<=0){
                        $("#text1").append('Were out of ' +Item.name);
                    }
                    else {
                        $("#text1").append('' + Item.name + ' is $' + n + '')
                            .append('<br>')
                            .append($('<button>')
                                .attr({
                                    'class': 'btn btn-primary'
                                })
                                .attr('onclick', 'vend("'+Item.id+'")')
                                .text('Buy me!')
                            )
                    }
                    break;
                case "Dr. Pepper":
                    if (stock<=0){
                        $("#text2").append('Were out of ' +Item.name);
                    }
                    else {
                        $("#text2").append('' + Item.name + ' is $' + n + '')
                            .append('<br>')
                                .append($('<button>')
                                    .attr({
                                        'class': 'btn btn-primary'
                                    })
                                    .attr('onclick', 'vend("'+Item.id+'")')
                                    .text('Buy me!')
                            )
                    }
                    break;
                case "RC":
                    if (stock<=0){
                        $("#text3").append('Were out of ' +Item.name);
                    }
                    else {
                        $("#text3").append('' + Item.name + ' is $' + n + '')
                            .append('<br>')
                            .append($('<button>')
                                .attr({
                                    'class': 'btn btn-primary'
                                })
                                .attr('onclick', 'vend("'+Item.id+'")')
                                .text('Buy me!')

                            )
                    }
                    break;
            }
        });
    });
}

function clearItems() {
    $("displaybody").empty();
}
function vend(id){

    $.getJSON('items/'+id, function (item) {
        $('#purchaseModalLabel').text("Purchase a cold "+item.name+" for $"+item.cost.toFixed(2)+".");
        $("#purchase-id").val(item.id);
        $("#purchaseModal").modal();
    });
}