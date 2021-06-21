package com.asesoftware.semilla.generador.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asesoftware.semilla.generador.dto.UsuarioDataDTO;


@Repository
public class ArchivoUsuarioRepository {

	private static final Logger logger = LoggerFactory.getLogger(ArchivoUsuarioRepository.class);
	
	private final EntityManager entityManager;
	
	
	@Autowired
	public ArchivoUsuarioRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public Integer getArchivosXUsuario(Integer idUsuario ) {
		
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("SP_COUNT_ARCHIVOS_USUARIO")
				.registerStoredProcedureParameter("in_idUsuario", Integer.class, ParameterMode.IN)
				.setParameter("in_idUsuario", idUsuario)
				.registerStoredProcedureParameter("out_numeroArchivos", Integer.class, ParameterMode.OUT);
		
		storedProcedureQuery.execute();
		
		Integer resultado = (Integer)storedProcedureQuery.getOutputParameterValue("out_numeroArchivos");
		
		logger.info("El numero de archivos del usuario {} es {}",idUsuario,resultado);
		
		return resultado;
	}
	
	
	public List<UsuarioDataDTO> getUsuario(Integer idUsuario ) {
		
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("SP_USUARIO_ARCHIVOS")
				.registerStoredProcedureParameter("in_idUsuario", Integer.class, ParameterMode.IN)
				.setParameter("in_idUsuario", idUsuario);
		
	
		List<Object[]> listObjects = storedProcedureQuery.getResultList();
		
		List<UsuarioDataDTO> dataDTOs = listObjects.stream()
				.map(datos-> new UsuarioDataDTO((String)datos[0], (String)datos[1], (Date)datos[2]))
				.collect(Collectors.toList());
		
		logger.info("El numero de archivos del usuario {} es {}",idUsuario,dataDTOs);
		
		return dataDTOs;
	}
	
	
	
}
