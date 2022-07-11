package com.example.ecommerce_a.domain;

public class BeverageTopping {
	private Integer id;
	private String name;
	private Integer price;
	private boolean deletedFlg;
	
	public BeverageTopping(Integer id, String name, Integer price, boolean deletedFlg) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.deletedFlg = deletedFlg;
	}
	
	public BeverageTopping() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean isDeletedFlg() {
		return deletedFlg;
	}

	public void setDeletedFlg(boolean deletedFlg) {
		this.deletedFlg = deletedFlg;
	}

	@Override
	public String toString() {
		return "BeverageTopping [id=" + id + ", name=" + name + ", price=" + price + ", deletedFlg=" + deletedFlg + "]";
	}
	
	
	
}
