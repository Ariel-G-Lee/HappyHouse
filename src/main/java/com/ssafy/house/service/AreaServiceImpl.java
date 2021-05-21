package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.AreaDao;
import com.ssafy.house.dto.AreaDto;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areaDao;
	
	@Override
	public List<AreaDto> sido() {
		return areaDao.sido();
	}

	@Override
	public List<AreaDto> gugun(String sidoCode) {
		return areaDao.gugun(sidoCode);
	}

	@Override
	public List<AreaDto> dong(String gugunCode) {
		return areaDao.dong(gugunCode);
	}

}
