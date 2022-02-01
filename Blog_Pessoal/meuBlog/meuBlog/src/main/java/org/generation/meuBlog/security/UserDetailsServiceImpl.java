package org.generation.meuBlog.security;

import java.util.Optional;

import org.generation.meuBlog.model.UsuarioModel;
import org.generation.meuBlog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * A annotation @Service indica que esta é uma Classe de Serviço, ou seja,
 * implementa regras de negócio da aplicação
 */

/* Implementa a interface UserDetailsService, que é responsável por recuperar os dados
*  do usuário no Banco de Dados pelo usuário e converter em um objeto da Classe 
*  UserDetailsImpl.*/

//implemetar mais coisas no UserDetailsService // ela só possui o metodo loadUserByUsername
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException
	{
		Optional<UsuarioModel> user = repository.findByUsuario(userName); //metodo de busca
		
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found.")); // se a resposta for null ela retorna userName + "not found."
		
		return user.map(UserDetailsImpl::new ).get();	// mesma coisa que UserDetailsImpl user = new UserDetailsImpl(); para a criação de um novo objeto
	}
	
	
	
	
	
}
