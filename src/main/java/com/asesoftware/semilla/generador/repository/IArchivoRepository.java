package com.asesoftware.semilla.generador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.generador.entity.ArchivoEntity;

public interface IArchivoRepository extends JpaRepository<ArchivoEntity, Integer> {

}
