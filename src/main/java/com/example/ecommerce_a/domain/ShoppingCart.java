package com.example.ecommerce_a.domain;

import java.util.List;

public class ShoppingCart {
	private int itemId;

	private int price;

	private int quantity;

	private byte[] image;

	private String imageStr;

	private String beverrageSize;

	private List<BeverageTopping> beverageToppingList;

	public ShoppingCart(int itemId, int price, int quantity, byte[] image, String imageStr, String beverrageSize,
			List<BeverageTopping> beverageToppingList) {
		super();
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.imageStr = imageStr;
		this.beverrageSize = beverrageSize;
		this.beverageToppingList = beverageToppingList;
	}

	public ShoppingCart() {
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageStr() {
		return imageStr;
	}

	public void setImageStr(String imageStr) {
		this.imageStr = imageStr;
	}

	public String getBeverrageSize() {
		return beverrageSize;
	}

	public void setBeverrageSize(String beverrageSize) {
		this.beverrageSize = beverrageSize;
	}

	public List<BeverageTopping> getBeverageToppingList() {
		return beverageToppingList;
	}

	public void setBeverageToppingList(List<BeverageTopping> beverageToppingList) {
		this.beverageToppingList = beverageToppingList;
	}

	@Override
	public String toString() {
		return "ShoppingCart [itemId=" + itemId + ", price=" + price + ", quantity=" + quantity + ", beverrageSize="
				+ beverrageSize + ", beverageToppingList=" + beverageToppingList + "]";
	}

}
