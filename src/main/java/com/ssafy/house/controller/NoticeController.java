package com.ssafy.house.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.NoticeParamDto;
import com.ssafy.house.dto.NoticeResultDto;
import com.ssafy.house.dto.UserDto;
import com.ssafy.house.service.NoticeService;

@CrossOrigin(origins = "http://localhost:5500",
allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;

	private static final int SUCCESS = 1;
	
	// 공지 글 등록
	@PostMapping(value="/notices")
	public ResponseEntity<NoticeResultDto> boardInsert(@RequestBody NoticeDto noticeDto, HttpSession session) {
		
		noticeDto.setUserId( ((UserDto) session.getAttribute("userDto")).getUserId());
		NoticeResultDto noticeResultDto = noticeService.noticeInsert(noticeDto);
		
		if( noticeResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}		 
	}
	
	// 공지 글 상세 조회
	@GetMapping(value="/notices/{noticeId}")
	public ResponseEntity<NoticeResultDto> noticeDetail(@PathVariable int noticeId, HttpSession session){

		System.out.println(noticeId);
		NoticeParamDto noticeParamDto = new NoticeParamDto();
		noticeParamDto.setNoticeId(noticeId);
		if(((UserDto) session.getAttribute("userDto") != null)) {			
			noticeParamDto.setUserId(((UserDto) session.getAttribute("userDto")).getUserId());
		}
		
		NoticeResultDto noticeResultDto = noticeService.noticeDetail(noticeParamDto);
		// 게시글 작성자와 현 사용자가 동일
		if( noticeParamDto != null && noticeParamDto.getUserId() == noticeResultDto.getDto().getUserId() ) {
			noticeResultDto.setOwner(true);
		}
		
		if( noticeResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}		 
	}
	
	
	// 공지 글 리스트 조회
	@GetMapping(value="/notices")
	public ResponseEntity<NoticeResultDto> noticeList(NoticeParamDto noticeParamDto){
		
		NoticeResultDto noticeResultDto;
		System.out.println(noticeParamDto.getSearchWord());
		if( noticeParamDto.getSearchWord().isEmpty() ) {
			noticeResultDto = noticeService.noticeList(noticeParamDto);
		}else {
			noticeResultDto = noticeService.noticeListSearchWord(noticeParamDto);
		}
		
		if( noticeResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 공지 글 수정
	@PutMapping(value="/notices/{noticeId}") 
	public ResponseEntity<NoticeResultDto> noticeUpdate(NoticeDto noticeDto, HttpSession session){

		NoticeResultDto noticeResultDto = noticeService.noticeUpdate(noticeDto);
		noticeDto.setUserId( ((UserDto) session.getAttribute("userDto")).getUserId());
		
		if( noticeResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	// 공지 글 삭제
	@DeleteMapping(value="/notices/{noticeId}") 
	public ResponseEntity<NoticeResultDto> noticeDelete(@PathVariable int noticeId){
		NoticeResultDto noticeResultDto = noticeService.noticeDelete(noticeId);
		
		if( noticeResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}		 
	}
	
}
