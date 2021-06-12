package com.asesoftware.semilla.generador.service;

import java.util.List;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;

public interface IArchivoService {

	
	public List<ArchivoEntity> getAll();
	
	public ArchivoDTO createArchivo(ArchivoDTO archivoDTO);
	
	public ArchivoDTO buscarPorId(Integer id);
	
	public ResponseDTO consultarTodosCreador(Integer usuarioCreador );
	
	public ResponseDTO consultarTodosNombres(String nombreUsuario);
	
	
	
	
	
}
