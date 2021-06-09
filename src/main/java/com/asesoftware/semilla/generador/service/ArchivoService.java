package com.asesoftware.semilla.generador.service;

import java.util.List;
import java.util.Optional;

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
	private IArchivoMapper mapperArchivo;
	
	@Override
	public List<ArchivoEntity> getAll() {
		// TODO Auto-generated method stub
		return archivoRepository.findAll();
	}

	@Override
	public ArchivoDTO createArchivo(ArchivoDTO archivoDTO) {
		
		ArchivoEntity archivoEntity = mapperArchivo.dtoToEntity(archivoDTO);
		
		return mapperArchivo.entityToDto(archivoRepository.save(archivoEntity));
	}

	@Override
	public ArchivoDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
		
		Optional<ArchivoEntity> archivoEntity = archivoRepository.findById(id);
		
	
		return mapperArchivo.entityToDto(archivoEntity.get());
	}

}
