package com.asesoftware.semilla.generador.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ErrorDTO {

	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStam;
	
	private String mesanje;
	
	private String debuggMensaje;
	
	private String origen;

	private ErrorDTO() {
		timeStam = LocalDateTime.now();	
	}
	
	public ErrorDTO(HttpStatus status, String mesanje, Throwable ex) {
		this();
		this.status = status;
		this.mesanje = mesanje;
		this.debuggMensaje = ex.getLocalizedMessage();
		
	}
	
	
	
	
}
