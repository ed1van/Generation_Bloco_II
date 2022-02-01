package org.generation.meuBlog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* Esta classe é responsável por habilitar a segurança básica da aplicação e o login
 na aplicação */

@EnableWebSecurity //Habilita a configuração padrão de segurança do spring security na api.
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired  //Injeção de dependência para usarmos os dados dos usuários salvos no db da tb_usuario. //so pode ser usada em interface
	private UserDetailsService userDetailsService;
	
	@Override //
	protected void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		
		/*AuthenticationManagerBuilder é uma classe que controla/organiza a autenticação.
		 * 
		 */
		auth.userDetailsService(userDetailsService); //estamos falando como vai ser a estrutura para ser validada. ex: nome, usuario, senha...
		 auth.inMemoryAuthentication()
			.withUser("root") //qual vair o usuario
			.password(passwordEncoder().encode("root")) //qual vai ser a senha
			.authorities("ROLE_USER"); //autorização de acesso
	}
	
	/*
	 *  A annotation @Bean transforma a instância retornada pelo método como um 
	 *  objeto, desta forma, ele pode ser injetado em qualquer
	 *  classe, a qualquer momento que precisar sem a necessidade de usar a 
	 *  annotation @Autowired
	 * 
	 *  O método abaixo é responsável por criptografar a senha do usuário utilizando o
	 *  método hash Bcrypt.
	 */
	//@Bean só pode ser usada na classe que ela é chamada
	@Bean // @Bean fala que isso é um "objeto" que pode usar os metodos sem que precise fazer uma classe || parecido com a injeção de dependencia mas com class
	public PasswordEncoder passwordEncoder() //esse metodo faz a criptografia da senha
	{
		return new BCryptPasswordEncoder(); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception // throws Exception (se não der certo) faça...
	{ /*
		
		*/
		
		http.authorizeRequests() // permite o usuario fazer uma requisição
			.antMatchers("/usuarios/logar").permitAll() //permite que ("/usuarios/logar") tenha acesso total
			.antMatchers("/usuarios/cadastrar").permitAll() // mesma coisa ^
			.antMatchers(HttpMethod.OPTIONS).permitAll() //permite metodos de acesso. CRUD
			.anyRequest().authenticated() // qualquer outra rota precisa ser autenticada
			.and().httpBasic() //Tipo de autenticação http (Basic Security)
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //mesmo se nao estivemos mexendo no site, ele nao vai desligar
			.and().cors() //permite o acesso do front, das requisições
			.and().csrf().disable();// o csrf é padrão do spring, então é preciso desabilita-lo
		
		
		/* sessionManagement() -> Cria um gerenciador de Sessões
		 * 
		 * sessionCreationPolicy(SessionCreationPolicy.STATELESS) -> Define
		 * como o Spring Secuiryt irá criar (ou não) as sessões
		 * 
		 * STATELESS -> Nunca será criada uma sessão, ou seja, basta enviar
		 * o token através do cabeçalho da requisição que a mesma será processada.*/
	}
	
	
	
	

}
