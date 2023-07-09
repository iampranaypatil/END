package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Railway")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Railway extends BaseEntity  {
	@Column(length = 30)
	private String name;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name="start_time")
	private LocalDateTime startTime;
	@Column(name="end_time")
	private LocalDateTime endTime;
	@Column(name="source", length=30)
	private String source;
	@Column(name="destination", length=30)
	private String Destination;
	@Column(name="distance")
	private int distance;
	@Column(name="frequency")
	private int frequency;
	
	
 
}
