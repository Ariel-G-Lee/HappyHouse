package com.ssafy.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.HouseParamDto;
import com.ssafy.house.dto.HouseResultDto;
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
	
	private static final int SUCCESS = 1;
	
	// 매물 리스트
	@GetMapping(value = "/houses")
	public ResponseEntity<HouseResultDto> searchByDong(HouseParamDto houseParamDto) {
		System.out.println("houses dongCode mapping OK : " + houseParamDto.getSearchKeyword() + "검색 - " + houseParamDto.getSearchOption());
		
		HouseResultDto houseResultDto = null;
		
		// 검색 옵션 (select box에서)
		if(houseParamDto.getSearchKeyword().equals("")) { // 키워드가 비었을 경우에는 전체 검색
			
			houseResultDto = houseService.searchAll(houseParamDto);
			
		} else if (houseParamDto.getSearchOption().equals("dongName")) {
			// 동 이름으로 검색
			houseResultDto = houseService.searchByDongName(houseParamDto);
			
		} else if (houseParamDto.getSearchOption().equals("aptName")) {
			// 아파트 이름으로 검색
			houseResultDto = houseService.searchByAptName(houseParamDto);
			
		} 
		
		//for (HouseDto houseDto : list)
		//	System.out.println(houseDto);
		
		if( houseResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// 매물 상세
	@GetMapping(value = "/houses/{no}")
	public ResponseEntity<HouseResultDto> houseDetail(@PathVariable int no) {
		
		HouseResultDto houseResultDto = houseService.houseDetail(no);
		
		if( houseResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
