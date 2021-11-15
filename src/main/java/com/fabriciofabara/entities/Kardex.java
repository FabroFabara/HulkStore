package com.fabriciofabara.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_kardex")
public class Kardex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKardex;

	@Column(name = "tipo", nullable = false, length = 1)
	private String tipo;

	@Column(name = "tipo_dodumento", nullable = false, length = 10)
	private String tipoDocumento;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio_unitario", nullable = false)
	private BigDecimal precioUnitario;

	@Column(name = "stock_anterior", nullable = false)
	private Integer stockAnterior;

	@Column(name = "stock_actual", nullable = false)
	private Integer stockActual;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "kardex")
	private List<Producto> productos;

}
