package com.ssafy.house.dto;

import java.util.List;

public class AnimalResultDto {
	private int count;
	private List<AnimalStatsDto> stsHptList;
	private List<AnimalStatsDto> stsPmcList;
	private List<AnimalPmcDto> pmcList;
	private List<AnimalHptDto> hptList;
	
	public AnimalResultDto() {}

	public AnimalResultDto(int count, List<AnimalStatsDto> stsHptList, List<AnimalStatsDto> stsPmcList,
			List<AnimalPmcDto> pmcList, List<AnimalHptDto> hptList) {
		super();
		this.count = count;
		this.stsHptList = stsHptList;
		this.stsPmcList = stsPmcList;
		this.pmcList = pmcList;
		this.hptList = hptList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<AnimalStatsDto> getStsHptList() {
		return stsHptList;
	}

	public void setStsHptList(List<AnimalStatsDto> stsHptList) {
		this.stsHptList = stsHptList;
	}

	public List<AnimalStatsDto> getStsPmcList() {
		return stsPmcList;
	}

	public void setStsPmcList(List<AnimalStatsDto> stsPmcList) {
		this.stsPmcList = stsPmcList;
	}

	public List<AnimalPmcDto> getPmcList() {
		return pmcList;
	}

	public void setPmcList(List<AnimalPmcDto> pmcList) {
		this.pmcList = pmcList;
	}

	public List<AnimalHptDto> getHptList() {
		return hptList;
	}

	public void setHptList(List<AnimalHptDto> hptList) {
		this.hptList = hptList;
	}

	@Override
	public String toString() {
		return "AnimalResultDto [count=" + count + ", stsHptList=" + stsHptList + ", stsPmcList=" + stsPmcList
				+ ", pmcList=" + pmcList + ", hptList=" + hptList + "]";
	}

	
}
