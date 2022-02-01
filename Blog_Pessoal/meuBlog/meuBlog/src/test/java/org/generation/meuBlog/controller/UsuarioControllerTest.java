package org.generation.meuBlog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.generation.meuBlog.model.UsuarioModel;
import org.generation.meuBlog.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar Usuário")
	public void deveCriarUmUsuario()
	{
		HttpEntity<UsuarioModel> requisicao = new HttpEntity<UsuarioModel>(new UsuarioModel(0L,
				"Paulo Antunes","paulo_antunes@email.com.br","123456789","realvsbarca2019.png"));
		
		ResponseEntity<UsuarioModel>resposta = testRestTemplate
				.exchange("/usuarios/cadastrar", HttpMethod.POST,requisicao,UsuarioModel.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(),resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsuario(), resposta.getBody().getUsuario());
		//assertEquals(requisicao.getBody().getFoto(), resposta.getBody().getFoto());
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Não deve permitir duplicação de Usuário")
	public void naoDeveDuplicarUsuario()
	{
		usuarioService.cadastrarUsuario(new UsuarioModel(0L,"Cristiano Ronaldo",
				"cr7@gmail.com","eusouomior1234","goldebikenoreal.png"));
		
		HttpEntity<UsuarioModel> requisicao = new HttpEntity<UsuarioModel>(new UsuarioModel(0L,"Cristiano Ronaldo",
				"cr7@gmail.com","eusouomior1234","goldebikenoreal.png"));
		
		ResponseEntity<UsuarioModel> resposta = testRestTemplate
				.exchange("/usuarios/cadastrar", HttpMethod.POST,requisicao,UsuarioModel.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	
	@Test
	@Order(3)
	@DisplayName("Alterar usuário")
	public void deveAtualizarUmUsuario()
	{
			Optional<UsuarioModel> usuarioCreate = usuarioService.cadastrarUsuario(new UsuarioModel(0L,
					"Juliana Andrews","Juliana@gmail.com","Juliana123","ju1242s.png"));
			
			UsuarioModel usuarioUpdate = new UsuarioModel(usuarioCreate.get().getId(),
					"Juliana Andrews Ramos","Juliana@gmail.com","Juliana123","as55da6s.png");
			
			HttpEntity<UsuarioModel> requisicao = new HttpEntity<UsuarioModel>(usuarioUpdate);
			
			ResponseEntity<UsuarioModel> resposta = testRestTemplate
					.withBasicAuth("root", "root")
						.exchange("/usuarios/atualizar", HttpMethod.PUT, requisicao, UsuarioModel.class);
			
			assertEquals(HttpStatus.OK, resposta.getStatusCode());
			assertEquals(usuarioUpdate.getNome(), resposta.getBody().getNome());
			assertEquals(usuarioUpdate.getUsuario(), resposta.getBody().getUsuario());
			
	}
	
	@Test
	@Order(4)
	@DisplayName("Listar todos os usuários")
	public void deveMostrarTodosUsuarios()
	{
		usuarioService.cadastrarUsuario(new UsuarioModel(0L,"Felipe Melo",
				"melo@gmail.com","l123j45678","piorcarrinhodacopa.png"));
		
		usuarioService.cadastrarUsuario(new UsuarioModel(0L,"Daniel Alves",
				"dani@gmail.com","lss1d6j45678","spfc.png"));
		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root", "root")
					.exchange("/usuarios/all", HttpMethod.GET,null,String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		
	}
	
}
