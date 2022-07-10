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
	  
	  private String imageStr;
	  
	  private boolean deletedFlg;
	  
	  private boolean recommendFlg;
	  
	  private boolean seasonFlg;
	  
	  private Integer beverrageItemsCategoryId; 

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



		public String getImageStr() {
			return imageStr;
		}



		public void setImageStr(String imageStr) {
			this.imageStr = imageStr;
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
