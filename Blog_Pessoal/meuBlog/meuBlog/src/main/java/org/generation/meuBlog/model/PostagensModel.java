package org.generation.meuBlog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_postagem")
public class PostagensModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 100, message = "O mínimo de caracteres é 5 e no máximo 100")
	private String titulo;
	
	@NotNull
	@Size(min = 10, max = 1000, message = "O mínimo de caracteres é 10 e no máximo 1000")
	private String texto;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro = new java.sql.Date(System.currentTimeMillis()); 
	
	@ManyToOne // muitos para um
	@JsonIgnoreProperties("postagem") //se não tiver o @JsonIgnoreProperties, fica um loop infinito mostrando os temas associados a postagens
	private TemaModel tema;
	//não esquecer dos gets e sets de tema
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
}
