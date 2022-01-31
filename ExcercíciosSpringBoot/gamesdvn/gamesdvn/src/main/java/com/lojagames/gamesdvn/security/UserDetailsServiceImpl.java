package com.lojagames.gamesdvn.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lojagames.gamesdvn.model.Usuario;
import com.lojagames.gamesdvn.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		Optional<Usuario> usuario = repository.findByUsuario(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
		return usuario.map(UserDetailsImpl::new).get();
	}

	
	
}
