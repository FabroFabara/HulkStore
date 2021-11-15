package com.fabriciofabara.service;

import com.fabriciofabara.entities.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario);
	void cambiarClave(String clave, String nombre);
}
