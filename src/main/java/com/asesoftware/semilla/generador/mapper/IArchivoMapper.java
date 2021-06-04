package com.asesoftware.semilla.generador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;

@Mapper(componentModel = "spring")
public interface IArchivoMapper {

	//@Mapping(source = "identificador",target = "id")
	public List<ArchivoDTO> listaEntityToDto (List<ArchivoEntity> listEntity);
	
	public ArchivoDTO entityToDto (ArchivoEntity entity);
	
	
	public ArchivoEntity dtoToEntity ( ArchivoDTO dto);
	
}
