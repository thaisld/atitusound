package br.atitus.poo.atitusound.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.atitus.poo.atitusound.entities.PlaylistEntity;
import br.atitus.poo.atitusound.entities.UserEntity;

@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity>{
	
	Page<List<PlaylistEntity>> findByNameContainingIgnoreCaseAndUserOrPublicshare(String name, UserEntity user, boolean publicshare, Pageable pageable);
	
}
