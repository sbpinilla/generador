package com.asesoftware.semilla.generador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.generador.entity.UsuarioEntity;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer>  {

}
