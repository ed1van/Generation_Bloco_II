package com.blogpessoal.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blog.model.PostagemModel;

@Repository // to falando que isso é um repository // responsavel pela comunicação com o banco de dados
public interface PostagemRespository extends JpaRepository <PostagemModel, Long> {  //Long maiusculo sempre vai ser usado pelo primery key // postagemModel é a classe que eu tinha criado,

	
	
	
}
