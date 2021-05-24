package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.AnimalHptDao;
import com.ssafy.house.dto.AnimalHptDto;
import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Service
public class AnimalHptServiceImpl implements AnimalHptService {
	
	@Autowired
	AnimalHptDao animalHptDao;

	@Override
	public AnimalResultDto selectStats() {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalStatsDto> stsList = animalHptDao.selectStats();
		
		animalResultDto.setStsList(stsList);
		return animalResultDto;
	}

	@Override
	public AnimalResultDto searchByDongName(String dongCode) {
		AnimalResultDto animalResultDto = new AnimalResultDto();
		List<AnimalHptDto> hptList = animalHptDao.searchByDongName(dongCode);
		int count = animalHptDao.searchByDongNameCount(dongCode);
		
		animalResultDto.setHptList(hptList);
		animalResultDto.setCount(count);
		return animalResultDto;
	}

}
