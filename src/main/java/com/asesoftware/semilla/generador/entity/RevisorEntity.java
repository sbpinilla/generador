package com.asesoftware.semilla.generador.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "revisor")
public class RevisorEntity  {

	@EmbeddedId
	private RevisorPK revisorPK;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "antiguedad")
	private Integer antiguedad;
	
}
