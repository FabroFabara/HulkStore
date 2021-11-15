package com.fabriciofabara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciofabara.entities.Kardex;
import com.fabriciofabara.exceptions.ModeloNotFoundException;
import com.fabriciofabara.service.impl.KardexServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class KardexController {

	@Autowired
	private KardexServiceImpl kardexService;

	@ApiOperation(value = "Metodo que retorna el kardex", notes = "Metodo que retorna el kardex")
	@GetMapping("/listarKardex")
	public ResponseEntity<List<Kardex>> findAll() {
		List<Kardex> listarKardex = kardexService.listarKardex();
		if (listarKardex.isEmpty()) {
			throw new ModeloNotFoundException("No Existe kardex registrado");

		}
		return new ResponseEntity<List<Kardex>>(listarKardex, HttpStatus.OK);
	}

}
