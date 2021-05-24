package com.ssafy.house.dto;

import java.util.List;

public class AnimalResultDto {
	private int count;
	private List<AnimalStatsDto> stsList;
	private List<AnimalPmcDto> pmcList;
	private List<AnimalHptDto> hptList;
	
	public AnimalResultDto() {}

	public AnimalResultDto(int count, List<AnimalStatsDto> stsList, List<AnimalPmcDto> pmcList,
			List<AnimalHptDto> hptList) {
		super();
		this.count = count;
		this.stsList = stsList;
		this.pmcList = pmcList;
		this.hptList = hptList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<AnimalStatsDto> getStsList() {
		return stsList;
	}

	public void setStsList(List<AnimalStatsDto> stsList) {
		this.stsList = stsList;
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
		return "AnimalResultDto [count=" + count + ", stsList=" + stsList + ", pmcList=" + pmcList + ", hptList="
				+ hptList + "]";
	}
}
