package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	private UsuarioRepository usuarioRepository;


	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> findAll() {
		log.info("Executing findAll Users");
		return this.usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		log.info("Executing findById");
		return this.usuarioRepository.findById(id);
	}

	@Override
	public Long count() {
		log.info("Get total number of users");
		return this.usuarioRepository.count();
	}

	@Override
	public Usuario save(Usuario usuario) {
		log.info("Creating / Updating user");

		if(!this.validateUsuario(usuario)) 
			return null;
		
		Usuario usuarioDB = this.usuarioRepository.save(usuario);
		
		return usuarioDB;
	}

	private boolean validateUsuario(Usuario usuario) {
		// null validation
		if (usuario == null) {
			log.warn("Trying to create null user");
			return false;
		}
		return true;
	}
	
	@Override
	public void deleteById(Long id) {
		log.info("Deleting user by id");
		if (id == null || id < 0 || id == 0) {
			log.warn("Trying to delete user with wrong id");
			return;
		}

		try {
			this.usuarioRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete user by id {}", id, e);
		}

	}

	@Override
	public void deleteAll() {
		log.info("Deleting users");
		this.usuarioRepository.deleteAll();
	}

	@Override
	public List<Usuario> findByUsername(String userName) {
		log.info("Executing findByUserName");
		if(!StringUtils.hasLength(userName))
			return new ArrayList<>();
		return this.usuarioRepository.findByUsername(userName);
	}
	
}
