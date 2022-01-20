package org.generation.meuBlog.controller;

import java.util.List;

import org.generation.meuBlog.model.TemaModel;
import org.generation.meuBlog.repository.TemaRepository;
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
@CrossOrigin(origins = "*", allowedHeaders = "*") // para aceitar requisão de qualquer origem
@RequestMapping("/tema")
public class TemaController {

	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable long id)
	{
		return repository.findById(id) 
				.map(resposta -> ResponseEntity.ok(resposta)) //se der certo me retorne a resposta
				.orElse(ResponseEntity.notFound().build()); // se der errado me retorne notFound
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<TemaModel>> getByName(@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> postTema (@RequestBody TemaModel tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<TemaModel> putTema (@RequestBody TemaModel tema)
	{
		return repository.findById(tema.getId())
				.map(resposta -> ResponseEntity.ok().body(repository.save(tema)))
				.orElse(ResponseEntity.notFound().build());	
		
		
	}
	
	@DeleteMapping("/{id}")
public ResponseEntity<?> deleteTema(@PathVariable long id) {
		
		return repository.findById(id)
				.map(resposta -> {repository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	
}

}