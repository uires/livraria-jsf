package br.com.livraria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "preco")
	private double preco;
	@Column(name = "data_lancamento")
	private String dataLancamento;
	// tabela associativa gerada pelo relacionamento UNI-DIRECIONAL
	@ManyToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY
	)
	@JoinTable(name="livro_autor",
		joinColumns = @JoinColumn(name = "id_livro"),
		inverseJoinColumns = @JoinColumn(name = "id_autor")
	)
	private List<Autor> autores = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
