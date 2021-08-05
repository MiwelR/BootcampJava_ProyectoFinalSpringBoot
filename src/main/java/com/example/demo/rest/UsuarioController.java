package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.CountDTO;
import com.example.demo.service.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class UsuarioController {

	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	// dependencia
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	

	/* ============= SPRING CRUD METHODS ================ */
	
	/**
	 * http://localhost:8080/api/usuarios/1
	 */
	@GetMapping("/usuarios/{id}")
	@ApiOperation("Buscar usuario por id")
	public ResponseEntity<Usuario> findById(@ApiParam("Clave primaria usuario") @PathVariable Long id) {
		log.info("REST request to find one usuario");

		Optional<Usuario> usuarioOpt = this.usuarioService.findById(id);
		
		if (usuarioOpt.isPresent()) 
			return ResponseEntity.ok(usuarioOpt.get());
		
		return ResponseEntity.notFound().build();	
	}
	
	/**
	 * http://localhost:8080/api/empresas
	 */
	@GetMapping("/usuarios")
	@ApiOperation("Mostrar listado de todos los usuarios")
	public List<Usuario> findAll(){
		log.info("REST request to find all usuarios");
		return this.usuarioService.findAll();
	}
	
	// create one
	@PostMapping("/usuarios")
	@ApiOperation("Crear nuevo usuario")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		log.info("REST request to create a new user");
		
		if (usuario.getId() != null) { 
			log.warn("Trying to create a new user with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.usuarioService.save(usuario));
		
	}
	
	// update 
	@PutMapping("/usuarios")
	@ApiOperation("Actualizar usuario")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		log.info("REST request to update an existing empresa");
		if (usuario.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE LA EMPRESA A ACTUALIZAR
			log.warn("Trying to update an existing empresa without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.usuarioService.save(usuario));
		
	}
	
	// delete one
	@DeleteMapping("/usuarios/{id}")
	@ApiOperation("Eliminar usuario por id")
	public ResponseEntity<Usuario> delete(@PathVariable Long id){
		log.info("REST request to delete an existing usuario");
		
		this.usuarioService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	@DeleteMapping("/usuarios")
	@ApiOperation("Eliminar todos los usuarios")
	public ResponseEntity<Usuario> deleteAll(){
		log.info("REST request to delete all usuarios");
		
		this.usuarioService.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/usuarios/count")
	@ApiOperation("Devolver el número total de usuarios")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all usuarios");
		Long count = this.usuarioService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Que tenga usted un feliz dia :)");
		return ResponseEntity.ok(dto);
	}
	
	
	/* ============= CUSTOM CRUD METHODS ================ */

	@GetMapping("/usuarios/nombre/{userName}")
	@ApiOperation("Buscar usuario por nombre")
	public List<Usuario> findByUsername(@PathVariable String userName){
		return this.usuarioService.findByUsername(userName);
	}
	
}
