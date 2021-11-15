package com.fabriciofabara.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciofabara.entities.Producto;
import com.fabriciofabara.exceptions.ModeloNotFoundException;
import com.fabriciofabara.service.impl.KardexServiceImpl;
import com.fabriciofabara.service.impl.ProductoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class ProductoController {

	@Autowired
	private ProductoServiceImpl productoService;

	@Autowired
	private KardexServiceImpl kardexService;

	@ApiOperation(value = "Metodo que retorna el listado de productos", notes = "Metodo que retorna el listado de productos")
	@GetMapping("/listarProductos")
	public ResponseEntity<List<Producto>> findAll() {
		List<Producto> listarProductos = productoService.listarProductos();
		if (listarProductos.isEmpty()) {
			throw new ModeloNotFoundException("No Existen productos registrados");

		}
		return new ResponseEntity<List<Producto>>(listarProductos, HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que recupera el producto por id", notes = "Metodo que recupera el producto por id")
	@GetMapping("/producto/{idProducto}")
	public ResponseEntity<Producto> findById(@PathVariable Long idProducto) {
		Producto producto = productoService.obtenerProdutoPorId(idProducto);
		if (producto == null) {
			throw new ModeloNotFoundException("El Producto con id: " + idProducto + "  no fue encontrado");

		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que permite registrar productos", notes = "Metodo que permite registrar productos")
	@PostMapping("/crearProductos")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		productoService.guardar(producto);
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Metodo que permite actualizar un producto", notes = "Metodo que permite actualizar un producto")
	@PutMapping("/actualizarProducto")
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto) throws Exception {
		Producto productoActualizar = productoService.obtenerProdutoPorId(producto.getIdProducto());
		if (productoActualizar == null) {
			productoService.guardar(producto);
			return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);

		} else {
			productoService.guardar(producto);
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Metodo que permite eliminar un producto", notes = "Metodo que permite eliminar un producto")
	@DeleteMapping("/producto/{idProducto}")
	public ResponseEntity<Void> eliminar(@PathVariable("idProducto") Long idProducto) throws Exception {
		Producto producto = productoService.obtenerProdutoPorId(idProducto);
		if (producto == null) {
			throw new ModeloNotFoundException(
					"El Producto con id: " + idProducto + " no se puede eliminar porque no fue encontrado");

		} else {
			productoService.eliminar(idProducto);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Metodo que permite comprar productos", notes = "Metodo que permite comprar productos")
	@PostMapping("/comprarProducto")
	public ResponseEntity<Producto> comprarProducto(@RequestBody Producto producto) {
		Producto productoCompra = productoService.obtenerProdutoPorId(producto.getIdProducto());
		if (productoCompra != null) {
			if (productoCompra.getCantidad() > 0) {
				kardexService.registrarKardex(productoCompra);
			} else {
				throw new ModeloNotFoundException(
						"El Producto con id: " + producto.getNombre() + " no cuenta con stock suficiente");
			}
		} else {
			throw new ModeloNotFoundException(
					"El Producto con id: " + producto.getNombre() + " no cuenta con stock suficiente");

		}
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}
}
