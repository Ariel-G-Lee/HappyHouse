package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.NoticeParamDto;

@Mapper
public interface NoticeDao {


	void noticeInsert(NoticeDto dto);

	int noticeUserReadCount(NoticeParamDto noticeParamDto);

	void noticeUserReadInsert(@Param("noticeId") int noticeId, @Param("userId") String userId);

	void noticeReadCountUpdate(int noticeId);

	NoticeDto noticeDetail(NoticeParamDto noticeParamDto);

	List<NoticeDto> noticeList(NoticeParamDto noticeParamDto);

	int noticeListTotalCount();

	List<NoticeDto> noticeListSearchWord(NoticeParamDto noticeParamDto);

	int noticeListSearchWordTotalCount(NoticeParamDto noticeParamDto);

	void noticeUpdate(NoticeDto noticeDto);

	// 아래  구현 해야함
	void noticeReadCountDelete(int noticeId);

	void noticeDelete(int noticeId);



}
