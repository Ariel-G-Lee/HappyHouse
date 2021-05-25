package com.ssafy.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.dto.AnimalStatsDto;
import com.ssafy.house.service.AnimalPmcService;

@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
@RestController
public class AnimalPmcController {

	@Autowired
	AnimalPmcService animalPmcService;
	
	private static final int SUCCESS = 1;
	
	// 그룹으로 묶은 리스트
	@GetMapping(value = "/animalpmc")
	public ResponseEntity<AnimalResultDto> searchByGroupGuGun() {
		
		AnimalResultDto animalResultDto = animalPmcService.selectStats();
		
		if( animalResultDto.getStsList() != null ) {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/animalpmc/{dongCode}")
	public ResponseEntity<AnimalResultDto> searchByDongName(@PathVariable String dongCode){
		
		AnimalResultDto animalResultDto = animalPmcService.searchByDongName(dongCode);
		System.out.println(animalResultDto.getPmcList());
		if( animalResultDto.getPmcList() != null ) {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.NOT_FOUND);
		}
	}
	
}
