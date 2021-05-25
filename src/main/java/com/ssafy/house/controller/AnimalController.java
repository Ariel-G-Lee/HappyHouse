package com.ssafy.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.service.AnimalService;

@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
@RestController
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@GetMapping(value = "/animalstats")
	public ResponseEntity<AnimalResultDto> searchByGroupGuGun() {
		
		AnimalResultDto animalResultDto = animalService.selectStats();
		
		if( animalResultDto.getStsPmcList() != null && animalResultDto.getStsHptList() != null) {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/animalhpt/{dongCode}")
	public ResponseEntity<AnimalResultDto> searchByDongNameHpt(@PathVariable String dongCode){
		
		System.out.println("여기");
		System.out.println(dongCode);
		AnimalResultDto animalResultDto = animalService.searchByDongNameHpt(dongCode);
		
		if( animalResultDto.getHptList() != null ) {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/animalpmc/{dongCode}")
	public ResponseEntity<AnimalResultDto> searchByDongNamePmc(@PathVariable String dongCode){
		
		AnimalResultDto animalResultDto = animalService.searchByDongNamePmc(dongCode);
		System.out.println(animalResultDto.getPmcList());
		if( animalResultDto.getPmcList() != null ) {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<AnimalResultDto>(animalResultDto, HttpStatus.NOT_FOUND);
		}
	}

}
