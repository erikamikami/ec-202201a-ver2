package com.example.ecommerce_a.domain;

/**
 * 飲み物アイテム
 * @author mikami
 *
 */
public class BeverrageItem {
	  private Integer id;
	  
	  private String name;
	  
	  private String description;
	  
	  private Integer priceS;
	  
	  private Integer priceM;
	  
	  private Integer priceL;
	  
	  private byte[] image;
	  
	  private boolean deletedFlg;
	  
	  private boolean recommendFlg;
	  
	  private boolean seasonFlg;
	  
	  private Integer beverrageItemsCategoryId; 

		public BeverrageItem(Integer id, String name, String description, Integer priceS, Integer priceM,
				Integer priceL, byte[] image, boolean deletedFlg, boolean recommendFlg, boolean seasonFlg,
				Integer beverrageItemsCategoryId) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.priceS = priceS;
			this.priceM = priceM;
			this.priceL = priceL;
			this.image = image;
			this.deletedFlg = deletedFlg;
			this.recommendFlg = recommendFlg;
			this.seasonFlg = seasonFlg;
			this.beverrageItemsCategoryId = beverrageItemsCategoryId;
		}

		public BeverrageItem() {
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getPriceS() {
			return priceS;
		}

		public void setPriceS(Integer priceS) {
			this.priceS = priceS;
		}

		public Integer getPriceM() {
			return priceM;
		}

		public void setPriceM(Integer priceM) {
			this.priceM = priceM;
		}

		public Integer getPriceL() {
			return priceL;
		}

		public void setPriceL(Integer priceL) {
			this.priceL = priceL;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public boolean isDeletedFlg() {
			return deletedFlg;
		}

		public void setDeletedFlg(boolean deletedFlg) {
			this.deletedFlg = deletedFlg;
		}

		public boolean isRecommendFlg() {
			return recommendFlg;
		}

		public void setRecommendFlg(boolean recommendFlg) {
			this.recommendFlg = recommendFlg;
		}

		public boolean isSeasonFlg() {
			return seasonFlg;
		}

		public void setSeasonFlg(boolean seasonFlg) {
			this.seasonFlg = seasonFlg;
		}

		public Integer getBeverrageItemsCategoryId() {
			return beverrageItemsCategoryId;
		}

		public void setBeverrageItemsCategoryId(Integer beverrageItemsCategoryId) {
			this.beverrageItemsCategoryId = beverrageItemsCategoryId;
		}

		@Override
		public String toString() {
			return "BeverrageItem [id=" + id + ", name=" + name + ", description=" + description + ", priceS=" + priceS
					+ ", priceM=" + priceM + ", priceL=" + priceL + ", image=" + image + ", deletedFlg=" + deletedFlg
					+ ", recommendFlg=" + recommendFlg + ", seasonFlg=" + seasonFlg + ", beverrageItemsCategoryId="
					+ beverrageItemsCategoryId + "]";
		}

}
