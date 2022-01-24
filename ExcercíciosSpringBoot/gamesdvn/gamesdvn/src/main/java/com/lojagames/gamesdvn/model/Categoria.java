package com.lojagames.gamesdvn.model;

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
@Table(name = "tb_categoria")
public class Categoria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotBlank(message = "Esse campo não pode ficar em branco")
@Size(min = 3, max = 30, message = "O minimo de caracteres é 3 e o máximo 30")
private String tituloCategoria;

@NotBlank(message = "Esse campo não pode ficar em branco")
@Size(min = 10, max = 400, message = "O minimo de caracteres é 10 e o máximo 400")
private String descricao;

private boolean ativo;

@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // um categoria para muitos produtos... cascadtype.all apaga todo os produtos se apagar a categoria
@JsonIgnoreProperties("categoria") //se nÃ£o tiver o @JsonIgnoreProperties, fica um loop infinito 
private List <Produto> produto;
//não esquecer os gettes e settes 

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}


public String getTituloCategoria() {
	return tituloCategoria;
}

public void setTituloCategoria(String tituloCategoria) {
	this.tituloCategoria = tituloCategoria;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public boolean getAtivo() {
	return ativo;
}

public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}

public List<Produto> getProduto() {
	return produto;
}

public void setProduto(List<Produto> produto) {
	this.produto = produto;
}


	
}
