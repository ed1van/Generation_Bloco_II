package com.blogpessoal.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.repository.PostagemRespository;

import antlr.collections.List;

@RestController // to falando que isso é um restcontroller. reponsavel por responder os https...para rodar no servidor/postamn
@RequestMapping("/Postagens") // onde colocamos no final do localhost para rodar no servidor
@CrossOrigin(origins = "*", allowedHeaders = "*") // serve para liberar todas as requisições
public class PostagemController {

	
	@Autowired // //injeção de dependencia: passa o poder para aquela pessoa
	private PostagemRespository TESTTTEE;
	
	
	
	//@GetMapping
	//public ResponseEntity<List<PostageModel>>getAll()
	//{
		
//	}
}
