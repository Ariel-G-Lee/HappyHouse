package com.ssafy.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.AreaDto;
import com.ssafy.house.dto.UserDto;
import com.ssafy.house.service.AreaService;

@CrossOrigin(
		origins = "http://localhost:5500",
		allowCredentials = "true",
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
@RestController
public class AreaController {

	@Autowired
	AreaService areaService;
	
	@GetMapping(value="/area/sido")
	public ResponseEntity<List<AreaDto>> sido(){
		
		List<AreaDto> list = areaService.sido();
		System.out.println(list.size());
		if( list != null ) {
			return new ResponseEntity<List<AreaDto>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<AreaDto>>(list, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/area/gugun")
	public ResponseEntity<List<AreaDto>> gugun(@RequestParam String sidoCode){
		System.out.println(sidoCode);
		List<AreaDto> list = areaService.gugun(sidoCode);
		if( list != null ) {
			return new ResponseEntity<List<AreaDto>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<AreaDto>>(list, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/area/dong")
	public ResponseEntity<List<AreaDto>> dong(@RequestParam String gugunCode){
		
		List<AreaDto> list = areaService.dong(gugunCode);
		if( list != null ) {
			return new ResponseEntity<List<AreaDto>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<AreaDto>>(list, HttpStatus.NOT_FOUND);
	}
}
