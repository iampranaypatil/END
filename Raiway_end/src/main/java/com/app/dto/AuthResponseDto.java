package com.app.dto;

import java.time.LocalDateTime;

import com.app.entities.Category;

import lombok.Getter;
import lombok.Setter;


 
@Getter
@Setter
public class AuthResponseDto {
	
	
	private String name;
	private Category category;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String source;
	private String Destination;
	private int distance;
	private int frequency;

}
