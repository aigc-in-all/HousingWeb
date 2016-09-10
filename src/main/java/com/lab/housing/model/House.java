package com.lab.housing.model;

public class House {

	private int id;
	private String buildName;
	private String buildRegion;
	private String houseType;
	private String houseArea;
	private String houseFloor;
	private String rentType;
	private String rentRoom;
	private float rentPrice;
	private String img;
	private String url;
	private int cityId;

	public House() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getBuildRegion() {
		return buildRegion;
	}

	public void setBuildRegion(String buildRegion) {
		this.buildRegion = buildRegion;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseFloor() {
		return houseFloor;
	}

	public void setHouseFloor(String houseFloor) {
		this.houseFloor = houseFloor;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getRentRoom() {
		return rentRoom;
	}

	public void setRentRoom(String rentRoom) {
		this.rentRoom = rentRoom;
	}

	public float getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", buildName=" + buildName + ", buildRegion=" + buildRegion + ", houseType=" + houseType + ", houseArea=" + houseArea + ", houseFloor=" + houseFloor + ", rentType="
				+ rentType + ", rentRoom=" + rentRoom + ", rentPrice=" + rentPrice + ", img=" + img + ", url=" + url + ", cityId=" + cityId + "]";
	}

}
