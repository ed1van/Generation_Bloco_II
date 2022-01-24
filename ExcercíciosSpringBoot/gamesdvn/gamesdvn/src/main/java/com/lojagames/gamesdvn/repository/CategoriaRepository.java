package com.lojagames.gamesdvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojagames.gamesdvn.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByTituloCategoriaContainingIgnoreCase(String tituloCategoria);

}
