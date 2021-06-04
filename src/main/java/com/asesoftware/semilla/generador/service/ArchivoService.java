package com.asesoftware.semilla.generador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;
import com.asesoftware.semilla.generador.mapper.IArchivoMapper;
import com.asesoftware.semilla.generador.repository.IArchivoRepository;

@Service
public class ArchivoService implements IArchivoService {
	
	@Autowired
	private IArchivoRepository archivoRepository;

	@Autowired
	private IArchivoMapper mapper;
	
	@Override
	public List<ArchivoDTO> getAll() {
		// TODO Auto-generated method stub
		return mapper.listaEntityToDto(archivoRepository.findAll());
	}

}
