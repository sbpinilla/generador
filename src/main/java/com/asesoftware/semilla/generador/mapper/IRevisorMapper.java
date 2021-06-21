package com.asesoftware.semilla.generador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.generador.dto.RevisorDTO;
import com.asesoftware.semilla.generador.entity.RevisorEntity;



@Mapper(componentModel = "spring")
public interface IRevisorMapper {

	@Mappings({
		@Mapping(source = "revisorPK.documento",target = "documento"),
		@Mapping(source = "revisorPK.tipoDocumento",target = "tipoDocumento"),
	})
	public RevisorDTO entityToDto (RevisorEntity entity);
	
	
	@Mappings({
		@Mapping(source = "documento",target = "revisorPK.documento"),
		@Mapping(source = "tipoDocumento",target = "revisorPK.tipoDocumento"),
	})
	public RevisorEntity dtoToEntity(RevisorDTO dto);
	
	public List<RevisorDTO> listEntityToDto(List<RevisorEntity> entities);
	
	public List<RevisorEntity> listDtoToEntity(List<RevisorDTO> dtos);
	
}
