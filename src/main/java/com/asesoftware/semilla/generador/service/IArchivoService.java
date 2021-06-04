package com.asesoftware.semilla.generador.service;

import java.util.List;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;

public interface IArchivoService {

	
	public List<ArchivoDTO> getAll();
	
}
