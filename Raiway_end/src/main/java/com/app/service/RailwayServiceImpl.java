package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.repository.RailwaysRepo;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	@Autowired
	private RailwaysRepo railRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<AuthResponseDto> getAllRail() {
		List<Railway> raillist=railRepo.findAll();
		List<AuthResponseDto> rail=new ArrayList<AuthResponseDto>();
		
		raillist.forEach((v)->{
			rail.add(mapper.map(v, AuthResponseDto.class));
		});
		
		return rail;
	}

	@Override
	public ApiResponse addNewRail( AuthRequestDto rail) {
		Railway rail1=new Railway(rail.getName(), rail.getCategory(), 
				rail.getStartTime(), rail.getEndTime(), rail.getSource(), 
				rail.getDestination(), rail.getDistance(), rail.getFrequency());
		railRepo.save(rail1);
		return new ApiResponse("new rail added");
	}

	@Override
	public ApiResponse delById(Long id) {
		if(!railRepo.existsById(id))
			return new ApiResponse("Invalid id");
		
		railRepo.deleteById(id);
		return new ApiResponse("raailway delete by id no. "+id+" successfully..");
	}

	@Override
	public ApiResponse updateRail(@Valid AuthRequestDto rail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponseDto gettById(Long id) {
			Railway rail = railRepo.getById(id);
			
			AuthResponseDto railD=mapper.map(rail, AuthResponseDto.class);
			
			return railD;
		
	}

	@Override
	public List<AuthResponseDto> gettByCat(Category cat) {
		List<Railway> raillist=railRepo.findByCategory(cat);
		List<AuthResponseDto> rail=new ArrayList<AuthResponseDto>();
		
		raillist.forEach((v)->{
			rail.add(mapper.map(v, AuthResponseDto.class));
		});
		
		return rail;
	}
	
	
	
}
