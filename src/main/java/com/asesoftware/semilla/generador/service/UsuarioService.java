package com.asesoftware.semilla.generador.service;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;
import com.asesoftware.semilla.generador.mapper.IUsuarioMapper;
import com.asesoftware.semilla.generador.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	private static final Logger logger  = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IUsuarioMapper mapperUsuario;
	

	@Override
	public ResponseDTO getAll() {
		
		return new ResponseDTO( mapperUsuario.listEntityToDto( usuarioRepository.findAll()), true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getUsuarioById(Integer id) {
				
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		
		if (optional.isPresent()) {
			
			return  new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK); 
			
		}else {
			return  new ResponseDTO(null, false, "usuario no encontrado", HttpStatus.OK); 
		}
		
		
	}

	@Override
	public ResponseDTO createUser(UsuarioDTO usuarioDTO) {
		
		try {
			
			UsuarioEntity usuarioEntity = mapperUsuario.dtoToEntity(usuarioDTO);
			
			usuarioRepository.save(usuarioEntity);
			
			
			
			return new ResponseDTO(mapperUsuario.entityToDto(usuarioEntity), true, "ok", HttpStatus.OK); 
		}catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede crear el usuario", HttpStatus.OK); 
		}
		
	}

	@Override
	public ResponseDTO updateUser(UsuarioDTO usuarioDTO) {
		
		
		UsuarioEntity usuarioEntity = mapperUsuario.dtoToEntity(usuarioDTO);
		
		 usuarioRepository.save(usuarioEntity);
		 
		return new ResponseDTO(mapperUsuario.entityToDto(usuarioEntity), true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO deleteUser(Integer id) {
		
		logger.info("ingreso al metodo deleteUser");
		
		try {
			usuarioRepository.deleteById(id);
			
			logger.info("el usuario {} se elimino",id);
			
			return  new ResponseDTO(null, true, "usuario eliminado", HttpStatus.OK); 
		}catch (Exception e) {
			
			logger.error("Error {}",e.getMessage());
			
			return  new ResponseDTO(null, false, "el usuario no se puede eliminar", HttpStatus.OK); 
		}
		
		
	}

	

}
