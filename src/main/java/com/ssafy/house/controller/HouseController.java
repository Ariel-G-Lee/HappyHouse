package com.ssafy.house.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.service.HouseService;

@CrossOrigin(
		origins = "http://localhost:5500",
		allowCredentials = "true",
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
@RestController
public class HouseController {

	@Autowired
	HouseService houseService;

	@GetMapping(value = "/houses")
	public ResponseEntity<List<HouseDto>> searchByDong(@RequestParam Map<String, String> params) {
		System.out.println("houses dongCode mapping OK : " + params.get("key") + "검색 - " + params.get("word"));
		List<HouseDto> list = null;

		//select box에서 dong인지 aptName인지 
		if (params.get("key").equals("dong")) {
			list = houseService.searchByDong(params.get("word"));
		} else if (params.get("key").equals("AptName")) {
			list = houseService.searchByName(params.get("word"));
		}
		
		//for (HouseDto houseDto : list)
		//	System.out.println(houseDto);
		
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}

}
