package com.ssafy.house.dto;

public class HouseDto {
	private int no;
	private String dongName;
	private String aptName;
	private String dealAmount;
	private String area;
	private String buildYear;
	private String dealMonth;
	private String dealDay;
	private String lat;
	private String lng;
	
	public HouseDto() {
		super();
	}
	
	public HouseDto(int no, String dongName, String aptName, String dealAmount, String area, String buildYear,
			String dealMonth, String dealDay, String lat, String lng) {
		super();
		this.no = no;
		this.dongName = dongName;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.buildYear = buildYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
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
		return "HouseDto [no=" + no + ", dongName=" + dongName + ", aptName=" + aptName + ", dealAmount=" + dealAmount
				+ ", area=" + area + ", buildYear=" + buildYear + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}

}
