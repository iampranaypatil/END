package com.app.dto;

import java.time.LocalDate;

import com.app.entities.MovieCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {

	private String movieName;
	private MovieCategory category;
	private LocalDate releaseDate;
	private double budget;
	private String director;
}
