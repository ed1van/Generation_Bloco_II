package org.generation.meuBlog.controller;

import java.util.List;

import org.generation.meuBlog.model.PostagensModel;
import org.generation.meuBlog.repository.PostagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagensController {
	
	@Autowired
	private PostagensRepository namerepository;
	
	@GetMapping
	public ResponseEntity<List<PostagensModel>> GetAll(){
		return ResponseEntity.ok(namerepository.findAll());
		
		
		
	}
	
}
