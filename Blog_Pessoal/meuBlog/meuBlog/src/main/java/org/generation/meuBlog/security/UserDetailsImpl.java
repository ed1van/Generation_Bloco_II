package org.generation.meuBlog.security;

import java.util.Collection;
import java.util.List;

import org.generation.meuBlog.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe UserDetailsImpl 
 * 
 * Implementa a interface UserDetails, que descreve o usuário para 
 * o Spring Security,ou seja, ele vai detalha as caracteríticas do usuário.
 * 
 * Por se tratar de uma implementação de uma interface, a classe
 * deve ter em seu nome o sufixo Impl para indicar que se trata de
 * uma implementação*/

public class UserDetailsImpl implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	
	/*As características descritas na interface UserDetails são:
		 * 
		 * 1) Credenciais do usuário (Username e Password)
		 * 2) As Autorizações do usuário (o que ele pode e não pode fazer),
		 *    através da Collection authorities do tipo GrantedAuthority
		 * 3) As Restrições (isAccountNonExpired(), isAccountNonLocked(), 
		 *    isCredentialsNonExpired() e isEnabled()) da conta do usuário.*/
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities; //lista de autorizações
	
	
	public UserDetailsImpl (UsuarioModel user) // a documentação pede dois construtores uma com parametro
	{
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl () // e outra sem parametro
	{
		
	}
	/*
	 * @Override metodo de autorização da conta usuario
	 * , nesta implementação não há nenhuma autorização negada
	 */
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	/**
	 *  Sobrescreve (@Override) o método que Indica se a conta do usuário 
	 *  expirou.
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 *  Sobrescreve (@Override) o método que Indica se o usuário 
	 *  está bloqueado ou desbloqueado.
	 */

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 *  Sobrescreve (@Override) o método que indica se as 
	 *  credenciais do usuário (senha) expiraram.  
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Sobrescreve (@Override) o método que Indica se o usuário 
	 *  está habilitado ou desabilitado.
	 *  Se mudar para false nenhum usuário conseguirá logar.
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
