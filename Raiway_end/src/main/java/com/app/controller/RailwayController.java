package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Category;
import com.app.service.RailwayService;



@RestController
@RequestMapping("/railways")
@Validated
public class RailwayController {

	@Autowired
	private RailwayService railSev;
	
	
	@GetMapping
	public ResponseEntity<?>getAll()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(railSev.getAllRail());
	}	
	
	@PostMapping("/add")
	public ResponseEntity<?>addRailway(@RequestBody @Valid AuthRequestDto rail){
		return ResponseEntity.status(HttpStatus.OK).body(railSev.addNewRail(rail));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteById(@RequestParam Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(railSev.delById(id));

	}
	
	@PutMapping
	public ResponseEntity<?>updateRailway(@RequestBody @Valid AuthRequestDto rail){
		return ResponseEntity.status(HttpStatus.OK).body(railSev.updateRail(rail));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getById(@RequestParam Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(railSev.gettById(id));
	}
	
	@GetMapping("/bycatgory")
	public ResponseEntity<?>getByCategory(@RequestParam Category cat){
		return ResponseEntity.status(HttpStatus.FOUND).body(railSev.gettByCat(cat));
	}
} 
