package com.fabriciofabara.jsons;

import java.math.BigDecimal;

import com.fabriciofabara.entities.Categoria;
import com.fabriciofabara.entities.Kardex;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateProductoRest {

	@JsonProperty("idProducto")
	private Long idProducto;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("cantidad")
	private Integer cantidad;

	@JsonProperty("precioUnitario")
	private BigDecimal precioUnitario;

	@JsonProperty("observacion")
	private String observacion;

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("idCategoria")
	private Long categoria;

	@JsonProperty("idKardex")
	private Long kardex;

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getKardex() {
		return kardex;
	}

	public void setKardex(Long kardex) {
		this.kardex = kardex;
	}

}
