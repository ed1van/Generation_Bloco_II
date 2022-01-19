package org.generation.meuBlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.meuBlog.model.PostagensModel;
import org.generation.meuBlog.repository.PostagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping("/{id}") 
	public ResponseEntity<PostagensModel> getById(@PathVariable long id){ 
		return namerepository.findById(id) 
				.map(resposta -> ResponseEntity.ok(resposta)) 
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagensModel>> getByTitulo(@PathVariable String titulo)
	{
		return ResponseEntity.ok(namerepository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	@PostMapping
	public ResponseEntity<PostagensModel> postPostagensModel (@Valid @RequestBody PostagensModel postagem) 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(namerepository.save(postagem));
	}
	
	
	@PutMapping
	public  ResponseEntity<PostagensModel> putPostagensModel (@Valid @RequestBody PostagensModel postagensMo)
	{
	return namerepository.findById(postagensMo.getId())
			.map(resposta -> ResponseEntity.ok().body(namerepository.save(postagensMo)))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagensModel(@PathVariable long id) {
		
		return namerepository.findById(id)
				.map(resposta -> {
					namerepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}


