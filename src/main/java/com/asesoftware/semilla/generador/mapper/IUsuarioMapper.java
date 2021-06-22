package com.asesoftware.semilla.generador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper {

	
	public UsuarioEntity dtoToEntity(UsuarioDTO dto);
	
	public UsuarioDTO entityToDto (UsuarioEntity usuarioEntity);
	
	public List<UsuarioDTO> listEntityToDto(List<UsuarioEntity> archivoEntity);
	
	
}
