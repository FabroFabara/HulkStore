package com.fabriciofabara.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciofabara.entities.Kardex;
import com.fabriciofabara.entities.Producto;
import com.fabriciofabara.repositories.KardexRepository;

@Service
public class KardexServiceImpl {

	@Autowired
	private KardexRepository kardexRepo;

	public List<Kardex> listarKardex() {
		List<Kardex> listarKardex = new ArrayList<>();
		listarKardex = kardexRepo.findAll();
		return listarKardex;
	}

	@Transactional
	public Kardex registrarKardex(Producto producto) {
		Kardex newKardex = initKardex(producto);
		return kardexRepo.save(newKardex);
	}

	private Kardex initKardex(Producto producto) {
		Kardex kardexkObj = new Kardex();
		List<Kardex> listarKardexProducto = kardexRepo.listarKardexProducto(producto.getIdProducto());
		listarKardexProducto.forEach(p -> {
			if (p.getStockActual() >= producto.getCantidad()) {
				kardexkObj.setTipo("EG");
			} else {
				kardexkObj.setTipo("IG");
			}
		});
		kardexkObj.setTipoDocumento("FC");
		kardexkObj.setCantidad(producto.getCantidad());
		kardexkObj.setPrecioUnitario(producto.getPrecioUnitario());
//		kardexkObj.setStockActual(listarKardexProducto.stream().mapToInt(Kardex::getStockActual).max() - producto.getCantidad());

		return kardexkObj;
	}

}
