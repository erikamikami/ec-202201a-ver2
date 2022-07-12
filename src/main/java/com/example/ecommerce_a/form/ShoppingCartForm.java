package com.example.ecommerce_a.form;

import java.util.List;

import com.example.ecommerce_a.domain.BeverageTopping;

public class ShoppingCartForm {
	private Integer itemId;

	private Integer quantity;

	private String imageStr;

	private String beverrageSize;

	private List<Integer> beverageToppingIdList;

	public ShoppingCartForm(Integer itemId, Integer quantity, String imageStr, String beverrageSize,
			List<Integer> beverageToppingIdList) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.imageStr = imageStr;
		this.beverrageSize = beverrageSize;
		this.beverageToppingIdList = beverageToppingIdList;
	}
	
	public ShoppingCartForm() {
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public List<Integer> getBeverageToppingIdList() {
		return beverageToppingIdList;
	}

	public void setBeverageToppingIdList(List<Integer> beverageToppingIdList) {
		this.beverageToppingIdList = beverageToppingIdList;
	}

	@Override
	public String toString() {
		return "ShoppingCartForm [itemId=" + itemId + ", quantity=" + quantity 
				+ ", beverrageSize=" + beverrageSize + ", beverageToppingIdList=" + beverageToppingIdList + "]";
	}
	
	
}
