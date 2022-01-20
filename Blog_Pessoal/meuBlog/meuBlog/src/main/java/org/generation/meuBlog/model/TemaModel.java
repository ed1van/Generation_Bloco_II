package org.generation.meuBlog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank(message = "O atributo descrição não pode ficar vazio")
	@Size(min = 5, max = 100)
	private String descricao;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) // um tema para muitas postagens
	@JsonIgnoreProperties("tema") //se não tiver o @JsonIgnoreProperties, fica um loop infinito mostrando os temas
	private List <PostagensModel> postagem;
	//não esquecer de gerar os gets e sets de postagens
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<PostagensModel> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<PostagensModel> postagem) {
		this.postagem = postagem;
	}
	
	
	
}
