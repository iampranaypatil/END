package com.app.dto;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class AuthRequestDto {
	@NotBlank(message = "Name can not be blanck")
	private String name;
	//@NotBlank(message = "Category must be selected")
	private Category category;
	@PastOrPresent(message = "starttime must be before end time")
	private LocalDateTime startTime;
	@Future(message = "endtime must be after start time")
	private LocalDateTime endTime;
	@NotBlank(message = "source can not be blanck")

	private String source;
	@NotBlank(message = "destination can not be blanck")

	private String Destination;
	//@NotNull(message = "distance can not be blanck")
	@Positive(message = "distance must be greater than zero")
	private int distance;
	//@NotNull(message = "frequency can not be blanck")
	@Positive(message = "frequency must be greater than zero")
	private int frequency;

}
