package org.generation.meuBlog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.meuBlog.model.UsuarioLoginModel;
import org.generation.meuBlog.model.UsuarioModel;
import org.generation.meuBlog.repository.UsuarioRepository;
import org.generation.meuBlog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	
@Autowired
private UsuarioRepository repository;

@Autowired
private UsuarioService service;

@GetMapping("/all")
public ResponseEntity<List<UsuarioModel>> getAll()
{
	return ResponseEntity.ok(repository.findAll());
}

@PostMapping("/logar")
public ResponseEntity<UsuarioLoginModel> login(@RequestBody Optional<UsuarioLoginModel> userLogin)
{
	return service.autenticarUsuario(userLogin)
		.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
}

@PostMapping("/cadastrar")
public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario)
{
	return service.cadastrarUsuario(usuario)
		.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
}

@PutMapping("/atualizar")
public ResponseEntity<UsuarioModel> putUsuario(@Valid @RequestBody UsuarioModel usuario)
{
	return service.atualizarUsuario(usuario)
		.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
