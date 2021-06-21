package com.asesoftware.semilla.generador.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UsuarioDataDTO {

	private String nombreUsuario;
	private String nombreArchivo;
	private Date fecha;
	
	public UsuarioDataDTO() {}
	
	public UsuarioDataDTO(String nombreUsuario, String nombreArchivo, Date fecha) {
		
		this.nombreUsuario = nombreUsuario;
		this.nombreArchivo = nombreArchivo;
		this.fecha = fecha;
	}
	
	
	
	
	
}
