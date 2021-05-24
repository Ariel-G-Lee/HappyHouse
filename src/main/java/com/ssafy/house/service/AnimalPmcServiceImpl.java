package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.AnimalPmcDao;
import com.ssafy.house.dto.AnimalHptDto;
import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Service
public class AnimalPmcServiceImpl implements AnimalPmcService {

	@Autowired
	AnimalPmcDao animalPmcDao;
	
	@Override
	public AnimalResultDto selectStats() {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalStatsDto> stsList = animalPmcDao.selectStats();
		
		animalResultDto.setStsList(stsList);
		return animalResultDto;
	}

	@Override
	public AnimalResultDto searchByDongName(String dongCode) {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalPmcDto> pmcList = animalPmcDao.searchByDongName(dongCode);
		int count = animalPmcDao.searchByDongNameCount(dongCode);
		
		animalResultDto.setPmcList(pmcList);
		animalResultDto.setCount(count);
		return animalResultDto;
	}
}
