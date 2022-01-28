package org.generation.meuBlog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.meuBlog.model.UsuarioModel;
import org.generation.meuBlog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	
@Autowired
private UsuarioRepository repository;

//@Autowired
//private UsuarioService service;

@GetMapping
public ResponseEntity<List<UsuarioModel>> getAll()
{
	return ResponseEntity.ok(repository.findAll());
}

/*@PostMapping("/logar")
public ResponseEntity<UsuarioModel> login(@RequestBody Optional<U> )
{
	re
}*/

/*@PostMapping("/cadastrar")
public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario)
{
	
}*/





}
