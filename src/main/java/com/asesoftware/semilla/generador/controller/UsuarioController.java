package com.asesoftware.semilla.generador.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;
import com.asesoftware.semilla.generador.service.IUsuarioService;


@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	// listar todos
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll() {
		
		return usuarioService.getAll();
	}
	
	// listar uno
	
	@GetMapping(path = "/usuario/{id}")
	public ResponseDTO getUsuarioById(@PathVariable Integer id) {
		
		return usuarioService.getUsuarioById(id);
	}
	
	@GetMapping(path = "/parametro")
	public ResponseDTO getUsuarioParametroById(@RequestParam Integer id) {
		
		return usuarioService.getUsuarioById(id);
	}
	
	
	// crear 
	
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public ResponseDTO createUser(@RequestBody UsuarioDTO entity) {
		
		return usuarioService.createUser(entity); 
	}
	
	
	// editar
	
	@PostMapping(path = "/editar", consumes = "application/json",produces = "application/json")
	public ResponseDTO editarUser(@RequestBody UsuarioDTO entity) {
		
		return usuarioService.updateUser(entity); 
	}
	
	
	// eliminar 
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO eliminarUsuario(@PathVariable Integer id) {
		
		return usuarioService.deleteUser(id);
	}
	
	
}
