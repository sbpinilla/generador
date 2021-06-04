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
import com.asesoftware.semilla.generador.entity.UsuarioEntity;
import com.asesoftware.semilla.generador.service.IUsuarioService;


@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	// listar todos
	
	@GetMapping(path = "/all")
	public List<UsuarioEntity> getAll() {
		
		return usuarioService.getAll();
	}
	
	// listar uno
	
	@GetMapping(path = "/usuario/{id}")
	public UsuarioEntity getUsuarioById(@PathVariable Integer id) {
		
		return usuarioService.getUsuarioById(id);
	}
	
	@GetMapping(path = "/parametro")
	public UsuarioEntity getUsuarioParametroById(@RequestParam Integer id) {
		
		return usuarioService.getUsuarioById(id);
	}
	
	
	// crear 
	
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public UsuarioEntity createUser(@RequestBody UsuarioEntity entity) {
		
		return usuarioService.createUser(entity); 
	}
	
	
	// editar
	
	@PostMapping(path = "/editar", consumes = "application/json",produces = "application/json")
	public UsuarioEntity editarUser(@RequestBody UsuarioEntity entity) {
		
		return usuarioService.updateUser(entity); 
	}
	
	
	// eliminar 
	@GetMapping(path = "/delete/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		
		
		usuarioService.deleteUser(id);
	}
	
	
}
