package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwayService {

	List<AuthResponseDto> getAllRail();

	ApiResponse addNewRail(@Valid AuthRequestDto rail);

	ApiResponse delById(Long id);

	ApiResponse updateRail(@Valid AuthRequestDto rail);

	AuthResponseDto gettById(Long id);

	List<AuthResponseDto> gettByCat(Category cat);

}
