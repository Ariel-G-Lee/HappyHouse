package com.ssafy.house.dto;

public class HouseParamDto {

	private int limit;
	private int offset;
	private String searchOption;
	private String searchKeyword;
	
	private int no;
	
	public HouseParamDto() {}

	public HouseParamDto(int limit, int offset, String searchOption, String searchKeyword, int no) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.searchOption = searchOption;
		this.searchKeyword = searchKeyword;
		this.no = no;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "HouseParamDto [limit=" + limit + ", offset=" + offset + ", searchOption=" + searchOption
				+ ", searchKeyword=" + searchKeyword + ", no=" + no + "]";
	}

	
}
