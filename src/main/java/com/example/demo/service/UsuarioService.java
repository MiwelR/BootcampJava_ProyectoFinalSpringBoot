package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Usuario;


public interface UsuarioService {

	// spring repository methods
	
	List<Usuario> findAll();

	Optional<Usuario> findById(Long id);
	
	Long count();
	
	Usuario save(Usuario usuario);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	// custom methods
	
	List<Usuario> findByUsername(String userName);
}
