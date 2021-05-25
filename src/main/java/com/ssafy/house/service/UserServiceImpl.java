package com.ssafy.house.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.house.dao.UserDao;
import com.ssafy.house.dto.ProfileFileDto;
import com.ssafy.house.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	String uploadFolder = "upload";
	/* for eclipse development code */
	String uploadPath = "C:" + File.separator + "Users" + File.separator + "gv" 
			+ File.separator + "Desktop" 
			+ File.separator + "SSAFY_SPRINGBOOT" 
			+ File.separator + "HappyHouseFinal" 
			+ File.separator + "src"
			+ File.separator + "main"
			+ File.separator + "resources"
			+ File.separator + "static";

	// 회원 가입
	@Override
	public int userInsert(UserDto dto, MultipartHttpServletRequest request) {
		int res = -1;
		try {
			
			List<MultipartFile> fileList = request.getFiles("file");
			
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if (!uploadDir.exists()) uploadDir.mkdir();

			for (MultipartFile part : fileList) {
				// userId 얻어오기
				String userId = dto.getUserId();
				
				String fileName = part.getOriginalFilename();
				
				//Random File Id
				UUID uuid = UUID.randomUUID();
				
				//file extension
				String extension = FilenameUtils.getExtension(fileName);
			
				String savingFileName = uuid + "." + extension;
			
				File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				
				System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				
				part.transferTo(destFile);

				String profileImageUrl = uploadFolder + "/" + savingFileName;

				dto.setProfileImageUrl(profileImageUrl);
			}
			res = userDao.userInsert(dto);
			
			
		}catch(IOException e) {
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
	
	// 회원 정보 조회
	@Override
	public UserDto userDetail(String userId) {
		return userDao.userDetail(userId);
	}

	// 회원 정보 수정
	@Override
	public UserDto userUpdate(UserDto dto, MultipartHttpServletRequest request) {
		UserDto userDto = null;
		try {

			List<MultipartFile> fileList = request.getFiles("file");
			System.out.println(fileList.size());
			if(fileList.size() != 0) {			
		    	String fileUrl = userDao.profileFileUrlDelete(dto.getUserId());
		    	if(fileUrl != null) {
		    		File file = new File(uploadPath + File.separator, fileUrl);
					if(file.exists()) {
						file.delete();
					}
		    	}
		    	
		    	File uploadDir = new File(uploadPath + File.separator + uploadFolder);
				if (!uploadDir.exists()) uploadDir.mkdir();

				for (MultipartFile part : fileList) {
					// userId 얻어오기
					String userId = dto.getUserId();
					
					String fileName = part.getOriginalFilename();
					
					//Random File Id
					UUID uuid = UUID.randomUUID();
					
					//file extension
					String extension = FilenameUtils.getExtension(fileName);
				
					String savingFileName = uuid + "." + extension;
				
					File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
					
					System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
					
					part.transferTo(destFile);

					String profileImageUrl = uploadFolder + "/" + savingFileName;

					dto.setProfileImageUrl(profileImageUrl);
				}
				
			}
			
			userDao.userUpdate(dto);
			userDto = dto;

		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return userDto;
	}

	// 회원 정보 삭제
	@Override
	public int userDelete(String userId) {
		int res = -1;
		try {
			String fileUrl = userDao.profileFileUrlDelete(userId);
			if(fileUrl != null) {
				File file = new File(uploadPath + File.separator, fileUrl);				
				if(file.exists()) {
					file.delete();
				}
			}
			userDao.noticeUserReadDelete(userId);
			res = userDao.userDelete(userId);		
			
		}catch(Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}
	


}
