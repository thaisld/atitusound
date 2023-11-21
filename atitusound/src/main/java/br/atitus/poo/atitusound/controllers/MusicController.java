package br.atitus.poo.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atitus.poo.atitusound.dtos.MusicDTO;
import br.atitus.poo.atitusound.entities.ArtistEntity;
import br.atitus.poo.atitusound.entities.MusicEntity;
import br.atitus.poo.atitusound.services.GenericService;
import br.atitus.poo.atitusound.services.MusicService;

@RestController
@RequestMapping("/musics")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{
	
	private final MusicService service;
	
	public MusicController(MusicService service) {
		super();
		this.service = service;
	}

	@Override
	protected GenericService<MusicEntity> getService() {
		return service;
	}

	@Override
	protected MusicEntity convertDTO2Entity(MusicDTO dto) {
		MusicEntity music = new MusicEntity();
		music.setName(dto.getName());
		music.setDuration(dto.getDuration());
		music.setUrl(dto.getUrl());
		
		ArtistEntity artist = new ArtistEntity();
		artist.setUuid(dto.getArtist().getUuid());
		
		music.setArtist(artist);
		return music;
	}

}