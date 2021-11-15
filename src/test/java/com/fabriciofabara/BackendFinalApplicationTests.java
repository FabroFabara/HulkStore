package com.fabriciofabara;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fabriciofabara.entities.Usuario;
import com.fabriciofabara.repositories.UsuarioRepository;

@SpringBootTest
class BackendFinalApplicationTests {
	
	@Autowired
	private UsuarioRepository repo;	
	
	@Autowired
	private PasswordEncoder bcrypt;
	
	@Test
	void creacionUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("fabriciofabara@gmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getPassword().equals(us.getPassword()));
	}
	
	@Test
	void contextLoads() {
	}

}
