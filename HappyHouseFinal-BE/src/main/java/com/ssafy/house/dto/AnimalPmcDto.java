package com.ssafy.house.dto;

public class AnimalPmcDto {
	private int pmcId;
	private String pmcName;
	private String pmcGugun;
	private String pmcDong;
	private String pmcCall;
	private String pmcAddress;
	private String pmcZipcode;
	private String pmcX;
	private String pmcY;
	private String pmcJibun;
	
	public AnimalPmcDto() {}

	public AnimalPmcDto(int pmcId, String pmcName, String pmcGugun, String pmcDong, String pmcCall, String pmcAddress,
			String pmcZipcode, String pmcX, String pmcY, String pmcJibun) {
		super();
		this.pmcId = pmcId;
		this.pmcName = pmcName;
		this.pmcGugun = pmcGugun;
		this.pmcDong = pmcDong;
		this.pmcCall = pmcCall;
		this.pmcAddress = pmcAddress;
		this.pmcZipcode = pmcZipcode;
		this.pmcX = pmcX;
		this.pmcY = pmcY;
		this.pmcJibun = pmcJibun;
	}

	public int getPmcId() {
		return pmcId;
	}

	public void setPmcId(int pmcId) {
		this.pmcId = pmcId;
	}

	public String getPmcName() {
		return pmcName;
	}

	public void setPmcName(String pmcName) {
		this.pmcName = pmcName;
	}

	public String getPmcGugun() {
		return pmcGugun;
	}

	public void setPmcGugun(String pmcGugun) {
		this.pmcGugun = pmcGugun;
	}

	public String getPmcDong() {
		return pmcDong;
	}

	public void setPmcDong(String pmcDong) {
		this.pmcDong = pmcDong;
	}

	public String getPmcCall() {
		return pmcCall;
	}

	public void setPmcCall(String pmcCall) {
		this.pmcCall = pmcCall;
	}

	public String getPmcAddress() {
		return pmcAddress;
	}

	public void setPmcAddress(String pmcAddress) {
		this.pmcAddress = pmcAddress;
	}

	public String getPmcZipcode() {
		return pmcZipcode;
	}

	public void setPmcZipcode(String pmcZipcode) {
		this.pmcZipcode = pmcZipcode;
	}

	public String getPmcX() {
		return pmcX;
	}

	public void setPmcX(String pmcX) {
		this.pmcX = pmcX;
	}

	public String getPmcY() {
		return pmcY;
	}

	public void setPmcY(String pmcY) {
		this.pmcY = pmcY;
	}

	public String getPmcJibun() {
		return pmcJibun;
	}

	public void setPmcJibun(String pmcJibun) {
		this.pmcJibun = pmcJibun;
	}

	@Override
	public String toString() {
		return "AnimalPmcDto [pmcId=" + pmcId + ", pmcName=" + pmcName + ", pmcGugun=" + pmcGugun + ", pmcDong="
				+ pmcDong + ", pmcCall=" + pmcCall + ", pmcAddress=" + pmcAddress + ", pmcZipcode=" + pmcZipcode
				+ ", pmcX=" + pmcX + ", pmcY=" + pmcY + ", pmcJibun=" + pmcJibun + "]";
	}
	
}
