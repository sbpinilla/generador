package com.asesoftware.semilla.generador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;
import com.asesoftware.semilla.generador.mapper.IArchivoMapper;
import com.asesoftware.semilla.generador.repository.IArchivoRepository;
import com.asesoftware.semilla.generador.service.IArchivoService;

@RestController
@RequestMapping(path = "/api/v1/archivo")
public class ArchivoController {

	@Autowired
	private IArchivoService archivoService;
	
	
	
	@GetMapping(path = "/todos")
	public List<ArchivoDTO> consultarTodos(){
		
	
		return archivoService.getAll() ;
	}
	
}
