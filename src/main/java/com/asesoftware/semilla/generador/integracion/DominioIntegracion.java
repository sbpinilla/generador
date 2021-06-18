package com.asesoftware.semilla.generador.integracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asesoftware.semilla.generador.controller.UsuarioController;
import com.asesoftware.semilla.generador.dto.DominioDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;


@Service
public class DominioIntegracion {
	
	private static final Logger logger  = LoggerFactory.getLogger(DominioIntegracion.class);
	
	
	@Value("${url.dominio.integracion}")
	private String baseUrl;
	
	public ResponseDTO getDominios(DominioDTO dominioDTO) {
		
		logger.info("la url de conexion es : {}",baseUrl);
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		HttpEntity<Object> request = new HttpEntity<>(dominioDTO,headers);
		
		ResponseDTO dto = restTemplate.postForObject(baseUrl + "/api/dominios", request, ResponseDTO.class);
		
		return dto;
	}
	
	

}
