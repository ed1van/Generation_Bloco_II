package org.generation.meuBlog.repository;

import java.util.List;

import org.generation.meuBlog.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{

	public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
