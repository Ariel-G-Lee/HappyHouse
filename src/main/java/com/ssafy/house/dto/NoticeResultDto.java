package com.ssafy.house.dto;

import java.util.List;


public class NoticeResultDto {
	private int result;
	private NoticeDto dto;
	private List<NoticeDto> list;
	private int count;
	// board-vue 새로 추가
	// 관리자 -> 작성자만 수정할 수 있게...
	private boolean isOwner;
	
	public NoticeResultDto() {}

	public NoticeResultDto(int result, NoticeDto dto, List<NoticeDto> list, int count, boolean isOwner) {
		super();
		this.result = result;
		this.dto = dto;
		this.list = list;
		this.count = count;
		this.isOwner = isOwner;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public NoticeDto getDto() {
		return dto;
	}

	public void setDto(NoticeDto dto) {
		this.dto = dto;
	}

	public List<NoticeDto> getList() {
		return list;
	}

	public void setList(List<NoticeDto> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	@Override
	public String toString() {
		return "NoticeResultDto [result=" + result + ", dto=" + dto + ", list=" + list + ", count=" + count
				+ ", isOwner=" + isOwner + "]";
	}

}
