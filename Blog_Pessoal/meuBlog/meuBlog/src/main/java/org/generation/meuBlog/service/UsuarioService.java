package org.generation.meuBlog.service;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.Optional;

import org.generation.meuBlog.model.UsuarioLoginModel;
import org.generation.meuBlog.model.UsuarioModel;
import org.generation.meuBlog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service // regras de negocio // ex: usuario só pode se cadastrar no site se for +18
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<UsuarioModel> cadastrarUsuario(UsuarioModel usuario) {

		if (repository.findByUsuario(usuario.getUsuario()).isPresent()) // se o usuario ja for cadastrado
			return Optional.empty(); //volta vazio
		
		usuario.setSenha(criptografarSenha(usuario.getSenha())); 

		return Optional.of(repository.save(usuario));
	
	}

	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario) {

		
		if(repository.findById(usuario.getId()).isPresent()) {
			
			Optional<UsuarioModel> buscaUsuario = repository.findByUsuario(usuario.getUsuario());
			
			if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			
			usuario.setSenha(criptografarSenha(usuario.getSenha()));

			return Optional.ofNullable(repository.save(usuario));
			
		}
		
			return Optional.empty();
	
	}	

	public Optional<UsuarioLoginModel> autenticarUsuario(Optional<UsuarioLoginModel> usuarioLogin) {

		Optional<UsuarioModel> usuario = repository.findByUsuario(usuarioLogin.get().getUsuario());

		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha()))
			{

				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setFoto(usuario.get().getFoto());
				usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
				usuarioLogin.get().setSenha(usuario.get().getSenha());

				return usuarioLogin;

			}
		}	
		
		return Optional.empty();
		
	}

	private String criptografarSenha(String senha)
	{

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);

	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) 
	{
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);

	}

	private String gerarBasicToken(String usuario, String senha) 
	{

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);

	}

	
	
	
	
}	
