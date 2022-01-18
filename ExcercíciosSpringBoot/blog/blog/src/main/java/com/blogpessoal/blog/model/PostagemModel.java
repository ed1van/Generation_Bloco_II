package com.blogpessoal.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity //serve para gerar uma tabela no bd, ou seja, cria a tabela 
@Table(name ="tb_postagens")  // indica um nome na tabela de banco de dados, ou seja, nomeia a tabela.
public class PostagemModel {
	
	@Id // anotação| para saber que isso é uma chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // como se fosse o autoencrement // o identificador começa em 1
	private long id;
	
	
	@NotBlank(message = "O atributo título é obrigatorio e não pode usar espaços em branco") // @notnull == é como se fosse o notnull ou seja, é obrigatorio digitar o titulo
	@Size(min=5, max=100, message = "O atributo titulo deve conter o minimo de 5 caracter e o max 100") // minimo de caracter e maximo e uma mensagem para quem esta vendo
	private String titulo;
	
	@NotNull(message = "O atibuto texto é obrigatoria")
	@Size (min=10, max=1000, message = "min 10 e max 1000")
	private String texto;
	
	
	@UpdateTimestamp //
	private LocalDateTime data;


	
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


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
	
	
}
