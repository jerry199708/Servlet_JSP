package com.store.product.Model;

import java.io.Serializable;

public class ProductVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String proPic;
	private String proName;
	private String proDescript;
	private String proPrice;
	private Integer proQuantity;

	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDescript() {
		return proDescript;
	}

	public void setProDescript(String proDescript) {
		this.proDescript = proDescript;
	}

	public String getProPrice() {
		return proPrice;
	}

	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}

	public Integer getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(Integer proQuantity) {
		this.proQuantity = proQuantity;
	}
	
}
