package com.asesoftware.semilla.generador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
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

	@Override
	public ResponseDTO consultarTodosCreador(Integer usuarioCreador) {
		// TODO Auto-generated method stub
		
		
		//List<ArchivoDTO> lisArchivoDTOs = mapperArchivo.listEntityToDto(archivoRepository.findByUsuarioCreador(usuarioCreador)) ;
		List<ArchivoDTO> lisArchivoDTOs = mapperArchivo.listEntityToDto(archivoRepository.queryUsuarioCreadorNativo(usuarioCreador)) ;

		
		return new ResponseDTO(lisArchivoDTOs, true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO consultarTodosNombres(String nombreUsuario) {
		
		
		//List<ArchivoDTO> lisArchivoDTOs = mapperArchivo.listEntityToDto(archivoRepository.queryUsuarioCreador(nombreUsuario)) ;
		List<ArchivoDTO> lisArchivoDTOs = archivoRepository.queryUsuarioCreadorDTO(nombreUsuario);
		
		
		return new ResponseDTO(lisArchivoDTOs, true, "ok", HttpStatus.OK);
	}

}
