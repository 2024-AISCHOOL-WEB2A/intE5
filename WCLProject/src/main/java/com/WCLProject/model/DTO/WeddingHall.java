package com.WCLProject.model.DTO;

import java.sql.Timestamp;

public class WeddingHall {
    private String weddingHallId;
    private String weddingHallBrand;
    private int weddingHallMealCost;
    private String weddingHallAssurance;
    private String weddingHallType;
    private int weddingHallPrice;
    private String weddingHallContent;
    private Timestamp weddingHallDate;
    private String vendorId;
    private String photoPath;
    private String weddingHallTitle;
    
    public WeddingHall() {}
    
	public WeddingHall(String id, String assurance, String type, int price, String content, String vendorId,
			String photoPath, String brand, String title, int mealCost) {
		this.weddingHallId = id;
		this.weddingHallAssurance = assurance;
		this.weddingHallType = type;
		this.weddingHallPrice = price;
		this.weddingHallContent = content;
		this.vendorId = vendorId;
		this.photoPath = photoPath;
		this.weddingHallBrand = brand;
		this.weddingHallTitle = title;
		this.weddingHallMealCost = mealCost;
	}

	public WeddingHall(String weddingHallId, String type, int price, int mealCost, String assurance, String title,
			String content, String photoPath) {
		this.weddingHallId = weddingHallId;
		this.weddingHallType = type;
		this.weddingHallPrice = price;
		this.weddingHallMealCost = mealCost;
		this.weddingHallAssurance = assurance;
		this.weddingHallTitle = title;
		this.weddingHallContent = content;
		this.photoPath = photoPath;
	}

	public String getWeddingHallId() {
		return weddingHallId;
	}
	public void setWeddingHallId(String weddingHallId) {
		this.weddingHallId = weddingHallId;
	}
	public String getWeddingHallBrand() {
		return weddingHallBrand;
	}
	public void setWeddingHallBrand(String weddingHallBrand) {
		this.weddingHallBrand = weddingHallBrand;
	}
	public int getWeddingHallMealCost() {
		return weddingHallMealCost;
	}
	public void setWeddingHallMealCost(int weddingHallMealCost) {
		this.weddingHallMealCost = weddingHallMealCost;
	}
	public String getWeddingHallAssurance() {
		return weddingHallAssurance;
	}
	public void setWeddingHallAssurance(String weddingHallAssurance) {
		this.weddingHallAssurance = weddingHallAssurance;
	}
	public String getWeddingHallType() {
		return weddingHallType;
	}
	public void setWeddingHallType(String weddingHallType) {
		this.weddingHallType = weddingHallType;
	}
	public int getWeddingHallPrice() {
		return weddingHallPrice;
	}
	public void setWeddingHallPrice(int weddingHallPrice) {
		this.weddingHallPrice = weddingHallPrice;
	}
	public String getWeddingHallContent() {
		return weddingHallContent;
	}
	public void setWeddingHallContent(String weddingHallContent) {
		this.weddingHallContent = weddingHallContent;
	}
	public Timestamp getWeddingHallDate() {
		return weddingHallDate;
	}
	public void setWeddingHallDate(Timestamp weddingHallDate) {
		this.weddingHallDate = weddingHallDate;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getWeddingHallTitle() {
		return weddingHallTitle;
	}
	public void setWeddingHallTitle(String weddingHallTitle) {
		this.weddingHallTitle = weddingHallTitle;
	}

    
}
