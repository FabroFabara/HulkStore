package com.fabriciofabara.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciofabara.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findAll();

	Optional<Producto> findById(Long idProducto);

}
