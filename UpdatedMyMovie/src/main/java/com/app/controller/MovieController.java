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
import com.app.entities.Movie;
import com.app.service.MovieService;



@RestController
@RequestMapping("/movies")
@Validated
public class MovieController {

	@Autowired
	private MovieService movieServ;
	
	@GetMapping
		public ResponseEntity<?> allAllMovies() {
		return ResponseEntity.status(HttpStatus.OK).body(movieServ.getAllMovies());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>addNewMovie(@RequestBody @Valid Movie movie){
		return ResponseEntity.status(HttpStatus.CREATED).body(movieServ.addMovie(movie));
	}
	
	@DeleteMapping("/{movieNo}")
	public ResponseEntity<?> deleteMovie(@RequestParam Long movieNo) {
		return ResponseEntity.status(HttpStatus.OK).body(movieServ.deleteMovieByNo(movieNo));
	}
	
	@PutMapping("/movieNo")
    public ResponseEntity<?> updateMovie(@RequestBody Movie detachedMovie){
//         return ResponseEntity.ok(movieServ.updateMovie(detachedMovie));
		return ResponseEntity.status(HttpStatus.OK).body(movieServ.updateMovie(detachedMovie));
    }
	
//	 @GetMapping("/byname")
//   public ResponseEntity<?> getMoviesByName(@RequestParam String name) {
//		 	return ResponseEntity.status(HttpStatus.FOUND).body(movieServ.getByName(name));
//		 
//   }
	
}
