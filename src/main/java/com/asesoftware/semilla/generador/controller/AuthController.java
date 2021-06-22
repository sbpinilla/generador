package com.asesoftware.semilla.generador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.service.IUsuarioService;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

	
	@Autowired
	private IUsuarioService usuarioService ;
	
	@GetMapping(path = "/login")
	public ResponseDTO login(@RequestParam String username) {
	
		return usuarioService.login(username);
	}
	
}
