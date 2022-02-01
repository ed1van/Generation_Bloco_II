package org.generation.meuBlog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotBlank(message = "Esse campo não pode ficar vazio")
private String nome;

@NotBlank(message = "Esse campo não pode ficar vazio")
@Email(message = "O atributo Usuario deve ser um email válido") // deve ser formato email: @gmail.com
private String usuario;

@NotBlank(message = "O atributo senha é obrigatori")
@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
private String senha;

private String foto;

@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List <PostagensModel> postagem;


public UsuarioModel(long id, String nome,String usuario, String senha,String foto) {

	this.id = id;
	this.nome = nome;
	this.usuario = usuario;
	this.senha = senha;
	this.foto = foto;
}

public UsuarioModel()
{
	
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public List<PostagensModel> getPostagem() {
	return postagem;
}

public void setPostagem(List<PostagensModel> postagem) {
	this.postagem = postagem;
}



	
}
