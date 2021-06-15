package com.ssafy.house.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ProfileFileDto {
	private int fileId;
	private String userId;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private String fileUrl;
	private LocalDateTime regDt;
	
	public ProfileFileDto() {}

	public ProfileFileDto(int fileId, String userId, String fileName, long fileSize, String fileContentType,
			String fileUrl, LocalDateTime regDt) {
		super();
		this.fileId = fileId;
		this.userId = userId;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileContentType = fileContentType;
		this.fileUrl = fileUrl;
		this.regDt = regDt;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public void setRegDt(Date regDt) {
		this.regDt = LocalDateTime.ofInstant(
				regDt.toInstant(), ZoneId.systemDefault()
		);	// for Mybatis Date Mapping
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	
	
}
