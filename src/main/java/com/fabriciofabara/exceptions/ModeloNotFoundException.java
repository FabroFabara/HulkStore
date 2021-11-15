package com.fabriciofabara.exceptions;

public class ModeloNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486667744912338816L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
