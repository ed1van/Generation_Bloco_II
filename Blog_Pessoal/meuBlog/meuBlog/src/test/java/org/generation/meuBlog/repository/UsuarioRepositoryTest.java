package org.generation.meuBlog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.meuBlog.model.UsuarioModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository repository;
	
	@BeforeAll
	void start()
	{
		repository.save(new UsuarioModel(0L,"João Silva Augusto", "hdayag@gmail.com","48745574564","hjsajuash.png"));
		
		repository.save(new UsuarioModel(0L,"Ricardo  Augusto", "emkkl@gmail.com","teste584123456","gfddsdww.png"));

		repository.save(new UsuarioModel(0L,"Manu Santos", "hddksag@gmail.com","teste125543456","hjsajuewsash.png"));
		
		repository.save(new UsuarioModel(0L,"Fernanda Rodrigues", "aksodo@gmail.com","teste445123456","hjsaassjuash.png"));

	}
	
	@Test
	@DisplayName("Retorne 1 usuario")
	public void deveRetornarUmUsuario()
	{
		Optional<UsuarioModel> usuario = repository.findByUsuario("hdayag@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("hdayag@gmail.com"));
	}
	@Test
	@DisplayName("Retorne 3 usuarios")
	public void deveRetornarTresUsuarios()
	{
		List<UsuarioModel> listaUsuarios = repository.findAllByNomeContainingIgnoreCase("Silva");
		
		assertEquals(3, listaUsuarios.size());
		assertTrue(listaUsuarios.get(0).getNome().equals("João Silva Augusto"));
		assertTrue(listaUsuarios.get(1).getNome().equals("Ricardo  Augusto"));
		assertTrue(listaUsuarios.get(2).getNome().equals("Manu Santos"));
	}
	
}
