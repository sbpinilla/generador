package com.asesoftware.semilla.generador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


import lombok.Data;

@Data
@Embeddable
public class RevisorPK implements Serializable  {


	private static final long serialVersionUID = 1L;

	@Column(name = "documento")
	private String documento;
	
	@Column(name = "tipo_documento")
	private String tipoDocumento;

	public RevisorPK() {}
	
	public RevisorPK(String documento, String tipoDocumento) {
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
	}
	
}
