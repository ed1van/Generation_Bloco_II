package com.lojagames.gamesdvn.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.lojagames.gamesdvn.model.Categoria;
import com.lojagames.gamesdvn.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {

@Autowired
public CategoriaRepository repository;

@GetMapping
public ResponseEntity<List<Categoria>> getAll()
{
	return ResponseEntity.ok(repository.findAll());
}
	
@GetMapping("/{id}")
public ResponseEntity<Categoria> getId (@PathVariable long id)
{
	return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());	
}

@GetMapping("titulo/{titulo}")
public ResponseEntity<List<Categoria>> getTitulo (@PathVariable String titulo)
{
	return ResponseEntity.ok(repository.findAllByTituloCategoriaContainingIgnoreCase(titulo));
}

@PostMapping
public ResponseEntity<Categoria> postCategoria (@Valid @RequestBody Categoria categoria)
{
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
}

@PutMapping
public ResponseEntity<Categoria> putCategoria (@Valid @RequestBody Categoria categoria)
{
	return repository.findById(categoria.getId())
			.map(resp -> ResponseEntity.ok().body(repository.save(categoria)))
					.orElse(ResponseEntity.notFound().build());	
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteCategoria(@PathVariable long id) {
	return repository.findById(id)
			.map(resp -> {repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		})
				.orElse(ResponseEntity.notFound().build());
	
}
}


