package br.com.livraria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Autor() {

	}

	public Autor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + "]";
	}

}
