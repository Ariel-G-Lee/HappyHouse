package com.ssafy.house.service;

import java.util.List;
import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalResultDto;

public interface AnimalPmcService {

	AnimalResultDto selectStats();

	AnimalResultDto searchByDongName(String dongCode);

}
