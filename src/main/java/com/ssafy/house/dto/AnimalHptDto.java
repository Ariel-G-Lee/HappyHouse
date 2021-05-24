package com.ssafy.house.dto;

public class AnimalHptDto {

	private int hptId;
	private String hptName;
	private String hptGugun;
	private String hptDong;
	private String hptCall;
	private String hptAddress;
	private String hptZipcode;
	private String hptX;
	private String hptY;
	private String hptJibun;
	
	public AnimalHptDto() {}

	public AnimalHptDto(int hptId, String hptName, String hptGugun, String hptDong, String hptCall, String hptAddress,
			String hptZipcode, String hptX, String hptY, String hptJibun) {
		super();
		this.hptId = hptId;
		this.hptName = hptName;
		this.hptGugun = hptGugun;
		this.hptDong = hptDong;
		this.hptCall = hptCall;
		this.hptAddress = hptAddress;
		this.hptZipcode = hptZipcode;
		this.hptX = hptX;
		this.hptY = hptY;
		this.hptJibun = hptJibun;
	}

	public int getHptId() {
		return hptId;
	}

	public void setHptId(int hptId) {
		this.hptId = hptId;
	}

	public String getHptName() {
		return hptName;
	}

	public void setHptName(String hptName) {
		this.hptName = hptName;
	}

	public String getHptGugun() {
		return hptGugun;
	}

	public void setHptGugun(String hptGugun) {
		this.hptGugun = hptGugun;
	}

	public String getHptDong() {
		return hptDong;
	}

	public void setHptDong(String hptDong) {
		this.hptDong = hptDong;
	}

	public String getHptCall() {
		return hptCall;
	}

	public void setHptCall(String hptCall) {
		this.hptCall = hptCall;
	}

	public String getHptAddress() {
		return hptAddress;
	}

	public void setHptAddress(String hptAddress) {
		this.hptAddress = hptAddress;
	}

	public String getHptZipcode() {
		return hptZipcode;
	}

	public void setHptZipcode(String hptZipcode) {
		this.hptZipcode = hptZipcode;
	}

	public String getHptX() {
		return hptX;
	}

	public void setHptX(String hptX) {
		this.hptX = hptX;
	}

	public String getHptY() {
		return hptY;
	}

	public void setHptY(String hptY) {
		this.hptY = hptY;
	}

	public String getHptJibun() {
		return hptJibun;
	}

	public void setHptJibun(String hptJibun) {
		this.hptJibun = hptJibun;
	}

	@Override
	public String toString() {
		return "AnimalHptDto [hptId=" + hptId + ", hptName=" + hptName + ", hptGugun=" + hptGugun + ", hptDong="
				+ hptDong + ", hptCall=" + hptCall + ", hptAddress=" + hptAddress + ", hptZipcode=" + hptZipcode
				+ ", hptX=" + hptX + ", hptY=" + hptY + ", hptJibun=" + hptJibun + "]";
	}
	
	
}
