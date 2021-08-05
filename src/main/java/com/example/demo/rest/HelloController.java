package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModelProperty;


@RestController
public class HelloController {

	
	@GetMapping("/")
	@ApiModelProperty("Página inicial de prueba")
	public String index() {
		
		
		return """
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="ISO-8859-1">
				<title>Awesome API REST</title>
				</head>
				<body>
				<h1 style="color:red;">Bienvenido al proyecto 5 - Spring Boot</h1>
				<a href="/api/empresas">Empresas Database</a> <br>
				<a href="/api/usuarios">Usuarios Database</a>
				</body>
				</html>
				""";
	}
	
//	/**
//	 * http://localhost:8080/api/welcome
//	 * @return
//	 */
//	@GetMapping("/api/welcome")
//	public String hello() {
//		log.info("Executing welcome method from logger");
//		return "Bienvenido";
//	}
//	
//	/**
//	 * http://localhost:8080/api/bye
//	 * @return
//	 */
//	@GetMapping("/api/bye")
//	public String bye() {
//		log.info("Executing bye world method from logger");
//		return "Vuelva pronto!";
//	}
	
}
