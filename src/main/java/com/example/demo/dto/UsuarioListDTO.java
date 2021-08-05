package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Usuario;

public class UsuarioListDTO {

	private List<Usuario> usuarios;
	
	public UsuarioListDTO() {}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
