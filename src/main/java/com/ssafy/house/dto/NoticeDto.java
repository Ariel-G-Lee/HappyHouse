package com.ssafy.house.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class NoticeDto {

	private int noticeId;
	private String userId;
	private String userName;
	private String title;
	private String content;
	private LocalDateTime regDt;
	private int readCount;
	
	public NoticeDto() {}

	public NoticeDto(int noticeId, String userId, String userName, String title, String content, LocalDateTime regDt,
			int readCount) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.regDt = regDt;
		this.readCount = readCount;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = LocalDateTime.ofInstant(
				regDt.toInstant(), ZoneId.systemDefault()
		);
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "NoticeDto [noticeId=" + noticeId + ", userId=" + userId + ", userName=" + userName + ", title=" + title
				+ ", content=" + content + ", regDt=" + regDt + ", readCount=" + readCount + "]";
	}
	
}
