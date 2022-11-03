package com.devdojo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devdojo.domain.Anime;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AnimeService  {
	
	private static List<Anime> animes; 
		
	static {	
		animes = new ArrayList<>(List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk")));	
	}

	
	public List<Anime> listAll(){
		return animes;
	}
	
	public Anime findById(long id) {
		return animes.stream().filter(anime -> anime.getId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime Not Found"));
	}
	
	public Anime save(Anime anime) {
		anime.setId(ThreadLocalRandom.current().nextLong(3,1000));
		animes.add(anime);
		return anime;
	}

	public void delete(long id) {
		log.info("Delete: Objeto com ID: {} Deletado do banco de dados", id);
		animes.remove(findById(id));
		
	}
	
	public void replace(Anime anime) {
		delete(anime.getId());
		animes.add(anime);
	}
}