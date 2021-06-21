package com.asesoftware.semilla.generador.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.generador.entity.RevisorEntity;
import com.asesoftware.semilla.generador.entity.RevisorPK;

public interface IRevisorRepository extends JpaRepository<RevisorEntity, RevisorPK> {

	public RevisorEntity findByRevisorPKDocumento(String documento);
	
}
