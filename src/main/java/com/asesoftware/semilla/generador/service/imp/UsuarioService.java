package com.asesoftware.semilla.generador.service.imp;

import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;
import com.asesoftware.semilla.generador.mapper.IUsuarioMapper;
import com.asesoftware.semilla.generador.repository.ArchivoUsuarioRepository;
import com.asesoftware.semilla.generador.repository.IUsuarioRepository;
import com.asesoftware.semilla.generador.service.IUsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioService implements IUsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private IUsuarioMapper mapperUsuario;

	@Autowired
	private ArchivoUsuarioRepository archivoUsuarioRepository;

	@Override
	public ResponseDTO getAll() {

		return new ResponseDTO( mapperUsuario.listEntityToDto( usuarioRepository.findAll()), true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getUsuarioById(Integer id) {

		// archivoUsuarioRepository.getArchivosXUsuario(id);
		// archivoUsuarioRepository.getUsuario(id);
		
		UsuarioDTO usuarioDTO = getUsuarioDTO(id);
		if (usuarioDTO !=null ) {

			return  new ResponseDTO(usuarioDTO, true, "ok", HttpStatus.OK); 

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

	@Override
	public UsuarioDTO getUsuarioDTO(Integer id) {

		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);

		if (optional.isPresent()) {

			return  mapperUsuario.entityToDto(optional.get());

		}else {
			return null;
		}

	}

	@Override
	public ResponseDTO login(String username) {
		
		
		UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username);
		
		if(usuarioEntity != null) {
			
			UsuarioDTO dto = mapperUsuario.entityToDto(usuarioEntity);
			
			Map<String, Object> dataMap = new HashMap<>();
			
			dataMap.put("usuario", dto);
			dataMap.put("token", generarToken(username));
			
			return new ResponseDTO(dataMap, true, "ok", HttpStatus.OK);
		}else {
			
			return  new ResponseDTO(null, false, "El usuario no existe", HttpStatus.OK);
		}
		
		
		
	}

	private String generarToken(String username) {
		
		
		List<GrantedAuthority> permisos = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts.builder()
				.setId(username) // validar 
				.setSubject(username)
				.claim("authorities", permisos.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, "semilla321".getBytes())
				.compact();

		return "Semilla "+token;
	}



}
