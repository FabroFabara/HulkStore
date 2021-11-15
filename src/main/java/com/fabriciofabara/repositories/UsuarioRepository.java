package com.fabriciofabara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabriciofabara.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

	Usuario findOneByUsername(String username);	
}
