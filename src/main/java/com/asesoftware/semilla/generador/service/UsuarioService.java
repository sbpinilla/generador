package com.asesoftware.semilla.generador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;
import com.asesoftware.semilla.generador.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	

	@Override
	public List<UsuarioEntity> getAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity getUsuarioById(Integer id) {
		
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		
		if (optional.isPresent()) {
			return optional.get() ;
		}else {
			return null;
		}
		
		
	}

	@Override
	public UsuarioEntity createUser(UsuarioEntity usuarioEntity) {
		
		try {
			return usuarioRepository.save(usuarioEntity);
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public UsuarioEntity updateUser(UsuarioEntity usuarioEntity) {
		
		
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public void deleteUser(Integer id) {
		
		usuarioRepository.deleteById(id);
		
	}

	

}
