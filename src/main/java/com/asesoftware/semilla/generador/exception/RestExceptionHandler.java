package com.asesoftware.semilla.generador.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.asesoftware.semilla.generador.controller.UsuarioController;
import com.asesoftware.semilla.generador.dto.ErrorDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;

@Order(2)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler  {

	private static final Logger logger  = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ResponseEntity<Object> handlerException(Exception exception, WebRequest request){
		
		logger.info("handlerException");
		ErrorDTO dto = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
		
		ResponseDTO responseDTO = new ResponseDTO(dto, false,"ERROR" , HttpStatus.INTERNAL_SERVER_ERROR);
		
		return buildHandlerException(responseDTO);
	}
	
	private ResponseEntity<Object> buildHandlerException(ResponseDTO dto){
		
		return new ResponseEntity<>(dto,dto.getStatus());
	}
	
	
}
