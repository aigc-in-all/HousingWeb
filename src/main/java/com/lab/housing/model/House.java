package com.lab.housing.model;

public class House {

    private String buildName;
    private String buildRegion;
    private String houseType;
    private String houseArea;
    private String houseFloor;
    private String rentTyep;
    private String rentRoom;
    private float rentPrice;
    private String img;
    private String url;
    private String abbr;

    public House() {
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

    public String getRentTyep() {
        return rentTyep;
    }

    public void setRentTyep(String rentTyep) {
        this.rentTyep = rentTyep;
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

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public String toString() {
        return "House [buildName=" + buildName + ", buildRegion=" + buildRegion + ", houseType=" + houseType
                + ", houseArea=" + houseArea + ", houseFloor=" + houseFloor + ", rentTyep=" + rentTyep + ", rentRoom="
                + rentRoom + ", rentPrice=" + rentPrice + ", img=" + img + ", url=" + url + ", abbr=" + abbr + "]";
    }

}
