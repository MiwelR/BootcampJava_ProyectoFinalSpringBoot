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

import com.example.demo.domain.Empresa;
import com.example.demo.dto.CountDTO;
import com.example.demo.service.EmpresaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class EmpresaController {
	
	private final Logger log = LoggerFactory.getLogger(EmpresaController.class);

	// dependencia
	private EmpresaService empresaService; 
	
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	

	/* ============= SPRING CRUD METHODS ================ */
	
	/**
	 * http://localhost:8080/api/empresas/1
	 */
	@GetMapping("/empresas/{id}")
	@ApiOperation("Buscar empresa por id")
	public ResponseEntity<Empresa> findById(@ApiParam("Clave primaria empresa") @PathVariable Long id) {
		log.info("REST request to find one empresa");

		Optional<Empresa> empresaOpt = this.empresaService.findById(id);
		
		if (empresaOpt.isPresent()) 
			return ResponseEntity.ok(empresaOpt.get());
		
		return ResponseEntity.notFound().build();	
	}
	
	/**
	 * http://localhost:8080/api/empresas
	 */
	@GetMapping("/empresas")
	@ApiOperation("Mostrar listado de todas las empresas")
	public List<Empresa> findAll(){
		log.info("REST request to find all empresas");
		return this.empresaService.findAll();
	}
	
	// create one
	@PostMapping("/empresas")
	@ApiOperation("Crear nueva empresa")
	public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
		log.info("REST request to create a new empresa");
		
		if (empresa.getId() != null) { // HAY ID - LA EMPRESA YA EXISTE NO PUEDO CREARLA DE NUEVO
			log.warn("Trying to create a new empresa with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.empresaService.save(empresa));
		
	}
	
	// update 
	@PutMapping("/empresas")
	@ApiOperation("Actualizar empresa")
	public ResponseEntity<Empresa> update(@RequestBody Empresa empresa) {
		log.info("REST request to update an existing empresa");
		if (empresa.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE LA EMPRESA A ACTUALIZAR
			log.warn("Trying to update an existing empresa without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.empresaService.save(empresa));
		
	}
	
	// delete one
	@DeleteMapping("/empresas/{id}")
	@ApiOperation("Eliminar empresa por id")
	public ResponseEntity<Empresa> delete(@PathVariable Long id){
		log.info("REST request to delete an existing empresa");
		
		this.empresaService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	@DeleteMapping("/empresas")
	@ApiOperation("Eliminar todas las empresas")
	public ResponseEntity<Empresa> deleteAll(){
		log.info("REST request to delete all empresas");
		
		this.empresaService.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/empresas/count")
	@ApiOperation("Devolver el número total de empresas")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all empresas");
		Long count = this.empresaService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Que tenga usted un feliz dia :)");
		return ResponseEntity.ok(dto);
	}
	
	
	/* ============= CUSTOM CRUD METHODS ================ */

	
	@GetMapping("/empresas/nombre/{nameEmpresa}")
	@ApiOperation("Buscar empresa por nombre")
	public List<Empresa> findByNameEmpresa(@PathVariable String nameEmpresa){
		return this.empresaService.findByNameEmpresa(nameEmpresa);
	}
	
	@GetMapping("/empresas/facturacion")
	@ApiOperation("Generar la facturación de todas las empresas")
	public List<Empresa> createBilling() {
		log.info("REST request to billing all empresas");
		List<Empresa> empresas = this.empresaService.findAll();
		for (Empresa empresa : empresas) {
			Integer calculoEmpresa = (empresa.getNumEmpleados() * empresa.getNumProductos()) / empresa.getYears();
			empresa.setBilling(calculoEmpresa);
		}
		return empresas;
	}
	
}
