package com.fabriciofabara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabriciofabara.entities.ResetToken;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer>{
	
	ResetToken findByToken(String token);

}
