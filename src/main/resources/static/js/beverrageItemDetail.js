"use strict"

$(function() {
	let totalAll = 0;


	/* 初期表示 */
	window.onload = function() {
		let sizePrice = $('input:radio[name="size"]:checked').val();
		sizePrice = parseInt(sizePrice);
		totalAll = sizePrice;
		$("#total-price").text(totalAll + "円");
	}

	$(".size, #suryo, .topping").change(function() {
		let sizePrice = $('input:radio[name="size"]:checked').val();
		let quantity = $('option:selected').val();
		sizePrice = parseInt(sizePrice);
		quantity = parseInt(quantity);


		let toppingPrice=0;
		$('input[name="orderToppings"]:checked').each(function(){
			toppingPrice += parseInt($(this).val());
		});

		totalAll = (sizePrice + toppingPrice) * quantity;
		$("#total-price").text(totalAll + "円");
	});

});

