package com.asesoftware.semilla.generador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.generador.dto.ArchivoDTO;
import com.asesoftware.semilla.generador.entity.ArchivoEntity;

@Mapper(componentModel = "spring")
public interface IArchivoMapper {

	
	@Mappings({
		@Mapping(source = "id",target = "identificador" ),
		@Mapping(source = "nombre",target = "archivo" )
	})
	public ArchivoDTO entityToDto(ArchivoEntity archivoEntity);
	
	@Mappings({
		@Mapping(source = "identificador",target = "id" ),
		@Mapping(source = "archivo",target = "nombre" )
	})
	public ArchivoEntity dtoToEntity (ArchivoDTO archivoDTO);
	
	public List<ArchivoDTO> listEntityToDto(List<ArchivoEntity> archivoEntity);
	
	public List<ArchivoEntity> listDtoToEntity(List<ArchivoDTO> archivoDTOs);
	
	
}

