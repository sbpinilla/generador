package com.asesoftware.semilla.generador.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;
import com.asesoftware.semilla.generador.service.IArchivoService;

@RestController
@RequestMapping(path = "/api/v1/archivo")
public class ArchivoController {
	
	@Autowired
	private IArchivoService archivoService;
	
	@GetMapping(path = "/todos")
	public List<ArchivoEntity> consultarTodos(){
		return archivoService.getAll() ;
	}
	
	@PostMapping(path = "/crear",consumes = "application/json",produces = "application/json")
	public ResponseDTO createArchivo(@RequestBody ArchivoDTO dto) {
		
		return archivoService.createArchivo(dto);
	}
	
	@GetMapping(path = "/{id}")
	public ArchivoDTO buscarPorId(@PathVariable Integer id){
		
		return archivoService.buscarPorId(id) ;
	}
	
	
	// consultar nuestros archivos por usuario creador
	@GetMapping(path = "/todos/{usuarioCreador}")
	public ResponseDTO consultarTodosCreador(@PathVariable Integer usuarioCreador){
		return archivoService.consultarTodosCreador(usuarioCreador) ;
	}
	
	
	// consultar nuestros archivos por nombre del usuario 
	@GetMapping(path = "/usuario")
	public ResponseDTO consultarTodosNombres(@RequestParam String nombreUsuario){
		return archivoService.consultarTodosNombres(nombreUsuario) ;
	}
	
	
}
