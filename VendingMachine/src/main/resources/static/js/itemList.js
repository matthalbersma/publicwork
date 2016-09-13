/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadItems();
});












function loadItems() {
    $.getJSON("items", function (data) {
        console.log(data);
        $.each(data._embedded.items, function (index, Item) {
            switch (Item.name) {
                case "Pepsi":
                    var n = Item.cost;
                    n = n.toFixed(2);
                    $("#text").append('' + Item.name + ' is $' + n + '');
                    break;
                case "Coke":
                    var n = Item.cost;
                    n = n.toFixed(2);
                    $("#text1").append('' + Item.name + ' is $' + n + '');
                    break;
                case "Dr. Pepper":
                    var n = Item.cost;
                    n = n.toFixed(2);
                    $("#text2").append('' + Item.name + ' is $' + n + '');
                    break;
                case "RC":
                    var n = Item.cost;
                    n = n.toFixed(2);
                    $("#text3").append('' + Item.name + ' is $' + n + '');
                    break;

            }


        });


    });

}

function clearItems() {
    $("displaybody").empty();
}