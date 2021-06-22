package com.asesoftware.semilla.generador.service;

import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.dto.UsuarioDTO;

public interface IUsuarioService {
	
	
	public ResponseDTO getAll();
	
	public UsuarioDTO getUsuarioDTO(Integer id);
	
	public ResponseDTO getUsuarioById(Integer id);
	
	public ResponseDTO createUser(UsuarioDTO UsuarioDTO);
	
	public ResponseDTO updateUser(UsuarioDTO usuarioDTO);
	
	public ResponseDTO deleteUser(Integer id);
	
	public ResponseDTO login(String username);
		
}
