package com.asesoftware.semilla.generador.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generador.dto.ResponseDTO;
import com.asesoftware.semilla.generador.entity.RevisorEntity;
import com.asesoftware.semilla.generador.entity.RevisorPK;
import com.asesoftware.semilla.generador.mapper.IRevisorMapper;
import com.asesoftware.semilla.generador.repository.IRevisorRepository;
import com.asesoftware.semilla.generador.service.IRevisionService;

@Service
public class RevisorService implements IRevisionService  {

	@Autowired
	private IRevisorRepository revisorRepository;
	
	@Autowired
	private IRevisorMapper revisorMapper;
	
	@Override
	public ResponseDTO getAll() {
		
		return new ResponseDTO(revisorMapper.listEntityToDto(revisorRepository.findAll()) , true, "ok", HttpStatus.OK); 
	}

	@Override
	public ResponseDTO getID(String doc, String tipoDoc) {
		
		
		Optional<RevisorEntity> revisionEntity = revisorRepository.findById(new RevisorPK(doc, tipoDoc));
		
		if (revisionEntity.isPresent()) {
			
			return new ResponseDTO( revisorMapper.entityToDto(revisionEntity.get()) ,
					true, 
					"ok", 
					HttpStatus.OK); 
		}else {
			return new ResponseDTO( null , true, "Sin resultados", HttpStatus.OK); 
		}
		
		
	}

	@Override
	public ResponseDTO getID(String doc) {
		
		RevisorEntity revisionEntity = revisorRepository.findByRevisorPKDocumento(doc);
		
		if (revisionEntity != null) {
			return new ResponseDTO( revisorMapper.entityToDto(revisionEntity) ,
					true, 
					"ok", 
					HttpStatus.OK); 
		}else {
			return new ResponseDTO( null , true, "Sin resultados", HttpStatus.OK); 
		}
		
	}

	

}
