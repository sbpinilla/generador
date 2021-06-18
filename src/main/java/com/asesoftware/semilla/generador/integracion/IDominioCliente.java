package com.asesoftware.semilla.generador.integracion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.asesoftware.semilla.generador.dto.DominioDTO;
import com.asesoftware.semilla.generador.dto.ResponseDTO;

@FeignClient(name = "dominio",url = "${url.dominio.integracion}")
public interface IDominioCliente {

	@PostMapping("/api/dominios")
	public ResponseDTO getDominio(@RequestBody DominioDTO dominioDTO);
	
}
