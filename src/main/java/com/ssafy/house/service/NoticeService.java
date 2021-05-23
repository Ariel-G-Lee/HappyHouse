package com.ssafy.house.service;

import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.NoticeParamDto;
import com.ssafy.house.dto.NoticeResultDto;

public interface NoticeService {

	NoticeResultDto noticeInsert(NoticeDto noticeDto);

	NoticeResultDto noticeDetail(NoticeParamDto noticeParamDto);

	NoticeResultDto noticeList(NoticeParamDto noticeParamDto);

	NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto);

	NoticeResultDto noticeUpdate(NoticeDto noticeDto);

	NoticeResultDto noticeDelete(int noticeId);

}
