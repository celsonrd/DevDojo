package com.devdojo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojo.domain.Anime;
import com.devdojo.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/anime")
@Log4j2
@AllArgsConstructor
public class AnimeController {
	
	@Autowired
	private DateUtil dateUtil;
	
	@GetMapping(path = "list")
	public List<Anime> list(){
		log.info(dateUtil.formatLocalDAteTimeToDatabaseStyle(LocalDateTime.now()));
		
		return List.of(new Anime("DBZ"), new Anime("Bersek"));
	}

}
