package com.fabriciofabara.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fabriciofabara.entities.Kardex;

@Repository
public interface KardexRepository extends JpaRepository<Kardex, Long> {

	List<Kardex> findAll();

	@Query(value="SELECT * FROM tb_kardex o WHERE o.id_producto=?1",nativeQuery = true)
	List<Kardex> listarKardexProducto(Long idProducto);

}
