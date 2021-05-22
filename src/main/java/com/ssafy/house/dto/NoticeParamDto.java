package com.ssafy.house.dto;

public class NoticeParamDto {
	
	private int limit;
	private int offset;
	private String searchWord;
	
	private int noticeId;
	private String userId;
	
	public NoticeParamDto() {}

	public NoticeParamDto(int limit, int offset, String searchWord, int noticeId, String userId) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.searchWord = searchWord;
		this.noticeId = noticeId;
		this.userId = userId;
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

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "NoticeParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", noticeId="
				+ noticeId + ", userId=" + userId + "]";
	}

}
