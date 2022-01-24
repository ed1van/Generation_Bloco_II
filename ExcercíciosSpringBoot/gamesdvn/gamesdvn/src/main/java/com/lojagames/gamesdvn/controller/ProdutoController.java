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

import com.lojagames.gamesdvn.model.Produto;
import com.lojagames.gamesdvn.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	
@Autowired
public ProdutoRepository repository;
	
@GetMapping
public ResponseEntity<List<Produto>> getAll()
{
	return ResponseEntity.ok(repository.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<Produto> getId(@PathVariable long id)
{
	return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
}

@GetMapping("/nome/{nome}")
public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome)
{
	return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
}

@PostMapping
public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto)
{
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
}

@PutMapping
public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto)
{
	return repository.findById(produto.getId())
			.map(resp -> ResponseEntity.ok().body(repository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteProduto(@PathVariable long id)
{
	return repository.findById(id)
			.map(resposta -> {repository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			})
			.orElse(ResponseEntity.notFound().build());
}



}
