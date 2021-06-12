package com.asesoftware.semilla.generador.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ArchivoDTO {

	private Integer identificador;
	
	private String archivo;
	
	private Integer usuarioCreador;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd",timezone = "America/New_York")
	private Date fecha;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date hora;
	
	private String nombreUsuario;

	public ArchivoDTO() {
		
	}
	
	public ArchivoDTO(Integer identificador, 
			String archivo, 
			Integer usuarioCreador, 
			Date fecha, 
			Date hora,
			String nombreUsuario) {
		
		this.identificador = identificador;
		this.archivo = archivo;
		this.usuarioCreador = usuarioCreador;
		this.fecha = fecha;
		this.hora = hora;
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
	
	

}
