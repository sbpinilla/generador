package com.asesoftware.semilla.generador.service;


import java.util.List;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;


public interface IUsuarioService {
	
	
	public List<UsuarioEntity> getAll();
	
	public UsuarioEntity getUsuarioById(Integer id);
	
	public UsuarioEntity createUser(UsuarioEntity usuarioEntity);
	
	public UsuarioEntity updateUser(UsuarioEntity usuarioEntity);
	
	public void deleteUser(Integer id);
	

}
