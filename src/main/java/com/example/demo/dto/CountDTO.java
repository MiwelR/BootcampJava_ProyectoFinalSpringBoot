package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Data transfer Object
 */
public class CountDTO {

	@ApiModelProperty("Cantidad de datos (Empresas o Usuarios)")
	private Long count;
	
	@ApiModelProperty("Mensaje devuelto")
	private String message;
	
	public CountDTO() {
	}
	
	public CountDTO(Long count) {
		this.count = count;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
