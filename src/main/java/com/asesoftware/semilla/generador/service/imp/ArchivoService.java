package com.asesoftware.semilla.generador.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;
import com.asesoftware.semilla.generador.mapper.IArchivoMapper;
import com.asesoftware.semilla.generador.repository.IArchivoRepository;
import com.asesoftware.semilla.generador.repository.IUsuarioRepository;
import com.asesoftware.semilla.generador.service.IArchivoService;
import com.asesoftware.semilla.generador.service.IUsuarioService;

@Service
public class ArchivoService implements IArchivoService {
	
	@Autowired
	private IArchivoRepository archivoRepository;
	
	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IArchivoMapper mapperArchivo;
		
	@Override
	public List<ArchivoEntity> getAll() {
		
		return archivoRepository.findAll();
	}

	@Override
	public ResponseDTO createArchivo(ArchivoDTO archivoDTO) {
		
		
		UsuarioDTO usuarioDTO = usuarioService.getUsuarioDTO(archivoDTO.getUsuarioCreador());
		
		if (usuarioDTO != null) {
			
			ArchivoEntity archivoEntity = mapperArchivo.dtoToEntity(archivoDTO);
			
			return new ResponseDTO(mapperArchivo.entityToDto(archivoRepository.save(archivoEntity)), true, "ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "Usuario no existe", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}

	@Override
	public ArchivoDTO buscarPorId(Integer id) {
	
		Optional<ArchivoEntity> archivoEntity = archivoRepository.findById(id);
		
	
		return mapperArchivo.entityToDto(archivoEntity.get());
	}

	@Override
	public ResponseDTO consultarTodosCreador(Integer usuarioCreador) {
	
		
		
		// List<ArchivoDTO> lisArchivoDTOs = mapperArchivo.listEntityToDto(archivoRepository.findByUsuarioCreador(usuarioCreador)) ;
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
