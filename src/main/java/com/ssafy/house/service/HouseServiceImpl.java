package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.HouseDao;
import com.ssafy.house.dto.HouseDto;

@Service
public class HouseServiceImpl implements HouseService {


	@Autowired
	HouseDao houseDao;
	
	@Override
	public List<HouseDto> searchByDong(String dongCode) {
		return houseDao.searchByDong(dongCode);
	}

	@Override
	public List<HouseDto> searchByName(String aptName) {
		return houseDao.searchByName(aptName);
	}

}
