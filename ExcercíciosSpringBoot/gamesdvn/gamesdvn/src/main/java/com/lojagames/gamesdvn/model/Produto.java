package com.lojagames.gamesdvn.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotBlank(message = "Esse campo não pode ficar em branco")
@Size(max = 80, message = "O máximo de 80 caracteres")
private String nome;

@NotBlank(message = "Esse campo não pode ficar em branco")
@Size(max = 600, message = "O máximo de 600 caracteres")
private String descricaojogo;

@NotBlank
private int preco;

@NotBlank
private int quantidade;

@NotBlank
private Date dataJogo;


@ManyToOne // muitos para um
@JsonIgnoreProperties("produto") //se nÃ£o tiver o @JsonIgnoreProperties, fica um loop infinito de produtos e categorias
private Categoria categoria;
//nÃ£o esquecer dos gets e sets do produto

@ManyToOne
@JsonIgnoreProperties("produto")
private Usuario usuario;

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

public String getDescricaojogo() {
	return descricaojogo;
}

public void setDescricaojogo(String descricaojogo) {
	this.descricaojogo = descricaojogo;
}

public int getPreco() {
	return preco;
}

public void setPreco(int preco) {
	this.preco = preco;
}

public int getQuantidade() {
	return quantidade;
}

public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}

public Date getDataJogo() {
	return dataJogo;
}

public void setDataJogo(Date dataJogo) {
	this.dataJogo = dataJogo;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}





	
}
