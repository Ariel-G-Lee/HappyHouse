package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.HouseDao;
import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.HouseParamDto;
import com.ssafy.house.dto.HouseResultDto;

@Service
public class HouseServiceImpl implements HouseService {


	@Autowired
	HouseDao houseDao;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@Override
	public HouseResultDto searchByDongName(HouseParamDto houseParamDto) {
		HouseResultDto houseResultDto = new HouseResultDto();
		
		try {
			houseResultDto.setList(houseDao.searchByDongName(houseParamDto));
			int count = houseDao.searchByDongNameTotalCount(houseParamDto);
			houseResultDto.setCount(count);
			houseResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
		
	}

	@Override
	public HouseResultDto searchByAptName(HouseParamDto houseParamDto) {
		HouseResultDto houseResultDto = new HouseResultDto();
		try {
			houseResultDto.setList(houseDao.searchByAptName(houseParamDto));
			int count = houseDao.searchByAptNameTotalCount(houseParamDto);
			houseResultDto.setCount(count);
			houseResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
	}

	@Override
	public HouseResultDto searchAll(HouseParamDto houseParamDto) {
		HouseResultDto houseResultDto = new HouseResultDto();
		try {
			List<HouseDto> list = houseDao.searchAll(houseParamDto);
			int count = houseDao.searchAllTotalCount();
			houseResultDto.setList(list);
			houseResultDto.setCount(count);
			houseResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
	}

	@Override
	public HouseResultDto houseDetail(int no) {
		HouseResultDto houseResultDto = new HouseResultDto();
		
		try {
			HouseDto dto = houseDao.houseDetail(no);
			
			houseResultDto.setDto(dto);
			
			houseResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			houseResultDto.setResult(FAIL);
		}
		
		return houseResultDto;
	}

}
