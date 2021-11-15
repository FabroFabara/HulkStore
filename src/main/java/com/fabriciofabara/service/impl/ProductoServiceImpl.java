package com.fabriciofabara.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciofabara.entities.Producto;
import com.fabriciofabara.exceptions.ModeloNotFoundException;
import com.fabriciofabara.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl {

	@Autowired
	private ProductoRepository productoRepo;

	public List<Producto> listarProductos() {
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos = productoRepo.findAll();
		return listaProductos;
	}

	public Producto obtenerProdutoPorId(Long idProducto) {
		Optional<Producto> producto = productoRepo.findById(idProducto);
		return producto.get();
	}

	public void guardar(Producto producto) {
		productoRepo.save(producto);
	}

	public void eliminar(Long idProducto) {
		productoRepo.deleteById(idProducto);
	}

}
