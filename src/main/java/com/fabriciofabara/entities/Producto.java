package com.fabriciofabara.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "cantidad", nullable = false, length = 4)
	private Integer cantidad;
	
	@Column(name = "precio_unitario", nullable = false)
	private BigDecimal precioUnitario;
	
	@Column(name = "observacion", nullable = false, length = 300)
	private String observacion;
	
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false, foreignKey = @ForeignKey(name = "FK_categoria_producto"))
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_kardex", nullable = false, foreignKey = @ForeignKey(name = "FK_kardex_producto"))
	private Kardex kardex;
}
