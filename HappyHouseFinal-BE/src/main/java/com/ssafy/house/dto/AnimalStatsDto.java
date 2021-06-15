package com.ssafy.house.dto;

public class AnimalStatsDto {
	private String name;
	private int count;
	
	public AnimalStatsDto() {}
	
	public AnimalStatsDto(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AnimalStatsDto [name=" + name + ", count=" + count + "]";
	}
	
}
