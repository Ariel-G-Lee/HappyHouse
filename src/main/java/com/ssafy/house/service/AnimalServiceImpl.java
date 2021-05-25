package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.AnimalDao;
import com.ssafy.house.dto.AnimalHptDto;
import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalDao animalDao;
	
	@Override
	public AnimalResultDto selectStats() {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalStatsDto> stsHptList = animalDao.selectHptStats();
		List<AnimalStatsDto> stsPmcList = animalDao.selectPmcStats();
		
		animalResultDto.setStsHptList(stsHptList);
		animalResultDto.setStsPmcList(stsPmcList);
		return animalResultDto;
	}
	
	@Override
	public AnimalResultDto searchByDongNameHpt(String dongCode) {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalHptDto> hptList = animalDao.searchByDongNameHpt(dongCode);
		int count = animalDao.searchByDongNameHptCount(dongCode);
		
		animalResultDto.setHptList(hptList);
		animalResultDto.setCount(count);
		return animalResultDto;
	}

	@Override
	public AnimalResultDto searchByDongNamePmc(String dongCode) {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalPmcDto> pmcList = animalDao.searchByDongNamePmc(dongCode);
		int count = animalDao.searchByDongNamePmcCount(dongCode);
		
		animalResultDto.setPmcList(pmcList);
		animalResultDto.setCount(count);
		return animalResultDto;
	}

}
