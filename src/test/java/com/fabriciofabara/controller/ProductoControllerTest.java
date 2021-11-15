package com.fabriciofabara.controller;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.fabriciofabara.entities.Producto;
import com.fabriciofabara.jsons.CreateProductoRest;
import com.fabriciofabara.service.impl.KardexServiceImpl;
import com.fabriciofabara.service.impl.ProductoServiceImpl;

public class ProductoControllerTest {

	private static final String SUCCESS_STATUS = "Created";
	private static final String SUCCESS_CODE = "200 OK";
	private static final String OK = "OK";

	private static final Long ID_PRODUCTO = 1L;
	private static final String NOMBRE = "DC COMIC";
	private static final Integer CANTIDAD = 10;
	private static final BigDecimal PRECIO_UNITARIO = new BigDecimal(10);
	private static final String OBSERVACION = "COMICS PARA LA GENTE QUE GUSTA DE BATMAN";
	private static final String ESTADO = "A";
	private static final Long CATEGORIA = 1L;
	private static final Long KARDEX = 1L;

	CreateProductoRest CREATE_PRODUCTO_REST = new CreateProductoRest();

	@Mock
	private ProductoServiceImpl productoService;

	@Mock
	private KardexServiceImpl kardexService;

	@InjectMocks
	ProductoController productoController;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);

		CREATE_PRODUCTO_REST.setIdProducto(ID_PRODUCTO);
		CREATE_PRODUCTO_REST.setNombre(NOMBRE);
		CREATE_PRODUCTO_REST.setCantidad(CANTIDAD);
		CREATE_PRODUCTO_REST.setPrecioUnitario(PRECIO_UNITARIO);
		CREATE_PRODUCTO_REST.setObservacion(OBSERVACION);
		CREATE_PRODUCTO_REST.setEstado(ESTADO);
		CREATE_PRODUCTO_REST.setCategoria(CATEGORIA);
		CREATE_PRODUCTO_REST.setKardex(KARDEX);

		}

	@Test
	public void findAllTest() {
		final ResponseEntity<List<Producto>> response = productoController.findAll();
		assertEquals(response, OK);
	}

	@Test
	public void findByIdTest()  {
		final  ResponseEntity<Producto> response = productoController.findById(ID_PRODUCTO);
		assertEquals(response, OK);
	}
	
	@Test
	public void crearProdcutoTest() {
//		ResponseEntity<String> response = productoController.crearProducto(CREATE_PRODUCTO_REST);

//		assertEquals(HttpStatus.CREATED.toString(), SUCCESS_STATUS);
//		assertEquals(response.getCode(), SUCCESS_CODE);
//		assertEquals(response.getMessage(), OK);
//		assertEquals(response.getData(), LOCATOR);
	}
}
