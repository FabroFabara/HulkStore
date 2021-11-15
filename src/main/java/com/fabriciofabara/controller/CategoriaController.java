package com.fabriciofabara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciofabara.entities.Categoria;
import com.fabriciofabara.exceptions.ModeloNotFoundException;
import com.fabriciofabara.service.impl.CategoriaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class CategoriaController {

	@Autowired
	private CategoriaServiceImpl categoriaservice;

	@ApiOperation(value = "Metodo que retorna el listado de las Categorias", notes = "Metodo que retorna el listado de las Categorias")
	@GetMapping("/listarCategorias")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> listarCategorias = categoriaservice.listarCategorias();
		if (listarCategorias.isEmpty()) {
			throw new ModeloNotFoundException("No Existen categorias registradas");

		}
		return new ResponseEntity<List<Categoria>>(listarCategorias, HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que recupera la categoria por id", notes = "Metodo que recupera la categoria por id")
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> findById(@PathVariable Long idCategoria) {
		Categoria categoria = categoriaservice.obtenerCategoriaPorId(idCategoria);
		if (categoria == null) {
			throw new ModeloNotFoundException("La categoria con id: " + idCategoria + "  no fue encontrada");

		}
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que permite registrar categorias", notes = "Metodo que permite registrar categorias")
	@PostMapping("/crearCategorias")
	public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
		categoriaservice.crearCategoria(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}

}
