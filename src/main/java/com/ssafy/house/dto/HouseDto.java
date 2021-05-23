package com.ssafy.house.dto;

public class HouseDto {
	private int no;
	private String dong;
	private String AptName;
	private String buildYear;
	private String area;
	private String dealAmount;
	private String dealMonth;
	private String dealDay;
	private String lat;
	private String lng;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		AptName = aptName;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}

	public String getDealDay() {
		return dealDay;
	}

	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "HouseDto [no=" + no + ", dong=" + dong + ", AptName=" + AptName + ", buildYear=" + buildYear + ", area="
				+ area + ", dealAmount=" + dealAmount + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", lat="
				+ lat + ", lng=" + lng + "]";
	}

}
