package com.devdojo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojo.domain.Anime;
import com.devdojo.service.AnimeService;
import com.devdojo.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {
	
	private final DateUtil dateUtil;
	private final AnimeService animeService;
	
	@GetMapping
	public ResponseEntity<List<Anime>> list(){
		log.info(dateUtil.formatLocalDAteTimeToDatabaseStyle(LocalDateTime.now()));	
		return ResponseEntity.ok(animeService.listAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable long id){
		return ResponseEntity.ok(animeService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime){
		return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping()
	public ResponseEntity<Void> replace(@RequestBody Anime anime){
		animeService.replace(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
