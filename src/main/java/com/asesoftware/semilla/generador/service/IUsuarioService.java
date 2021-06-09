package com.asesoftware.semilla.generador.service;


import java.util.List;

import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;


public interface IUsuarioService {
	
	
	public ResponseDTO getAll();
	
	public ResponseDTO getUsuarioById(Integer id);
	
	public ResponseDTO createUser(UsuarioDTO UsuarioDTO);
	
	public ResponseDTO updateUser(UsuarioDTO usuarioDTO);
	
	public ResponseDTO deleteUser(Integer id);
	

}
