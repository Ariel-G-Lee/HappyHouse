package com.ssafy.house.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.NoticeDao;
import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.NoticeParamDto;
import com.ssafy.house.dto.NoticeResultDto;
import com.ssafy.house.dto.UserDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	// 공지 글 등록
	@Override
	public NoticeResultDto noticeInsert(NoticeDto dto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		try {
			dao.noticeInsert(dto);

			noticeResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		return noticeResultDto;
	}

	// 공지 글 상세 조회
	@Override
	public NoticeResultDto noticeDetail(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			// 현재 user가 해당 공지글을 읽었는지 값을 받아온다.
			if((noticeParamDto.getUserId()) != null ) {
				int userReadCnt = dao.noticeUserReadCount(noticeParamDto);
				// 읽은 적이 없다면
				if( userReadCnt == 0 ) {
					// 읽은 흔적을 넘겨주고
					dao.noticeUserReadInsert(noticeParamDto.getNoticeId(), noticeParamDto.getUserId());
					// 해당 공지글의 readCount를 올려준다.
					dao.noticeReadCountUpdate(noticeParamDto.getNoticeId());
				}
			}
			
			// 해당 공지글 상세를 업어온다.
			NoticeDto dto = dao.noticeDetail(noticeParamDto);

			noticeResultDto.setDto(dto);
			
			noticeResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		
		return noticeResultDto;
	}

	// 공지 글 전체 리스트
	@Override
	public NoticeResultDto noticeList(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			List<NoticeDto> list = dao.noticeList(noticeParamDto);
			int count = dao.noticeListTotalCount();			
			noticeResultDto.setList(list);
			noticeResultDto.setCount(count);
			noticeResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		
		return noticeResultDto;
	}

	// 공지글 검색 리스트
	@Override
	public NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			List<NoticeDto> list = dao.noticeListSearchWord(noticeParamDto);
			int count = dao.noticeListSearchWordTotalCount(noticeParamDto);
			
			noticeResultDto.setList(list);
			noticeResultDto.setCount(count);
			
			noticeResultDto.setResult(SUCCESS);
		
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		
		return noticeResultDto;
	}

	// 공지 글 수정
	@Override
	public NoticeResultDto noticeUpdate(NoticeDto noticeDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();

		
		try {
			dao.noticeUpdate(noticeDto);
			
			noticeResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		
		return noticeResultDto;
	}

	// 공지 글 삭제
	@Override
	public NoticeResultDto noticeDelete(int noticeId) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			
			dao.noticeReadCountDelete(noticeId);
			dao.noticeDelete(noticeId);		
			noticeResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setResult(FAIL);
		}
		
		return noticeResultDto;
	}

}
