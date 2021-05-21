package com.ssafy.house.dto;

import java.util.Date;

public class UserDto {
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String address;
	private String profileImageUrl;
	private Date joindate;
	
	public UserDto() {}

	public UserDto(String userId, String userName, String userPwd, String email, String address, String profileImageUrl,
			Date joindate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.address = address;
		this.profileImageUrl = profileImageUrl;
		this.joindate = joindate;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		if( profileImageUrl == null || "null".equals(profileImageUrl) || "".equals(profileImageUrl)) {
			this.profileImageUrl = "/img/noProfile.png";
		}else {
			this.profileImageUrl = profileImageUrl;
		}
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", email=" + email
				+ ", address=" + address + ", profileImageUrl=" + profileImageUrl + ", joindate=" + joindate + "]";
	}
}
