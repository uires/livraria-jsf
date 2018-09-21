package br.com.livraria.MB;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.DAO.LivroDAO;
import br.com.livraria.entity.Autor;
import br.com.livraria.entity.Livro;

@ManagedBean(name = "livroMB")
@ViewScoped
public class LivroMB {
	private Livro livro = new Livro();
	private LivroDAO daoL = new LivroDAO();
	private AutorDAO daoA = new AutorDAO();
	private ArrayList<Autor> autores = (ArrayList<Autor>) daoA.selectAll();
	private Long autorId;

	public String cadastrarLivro() {
		daoL.save(livro);
		livro = new Livro();
		return "index.xhtml";
	}

	public void gravarAutor() {
		if (autorId != null) {
			Autor autor = new Autor();
			autor.setId(autorId);
			livro.getAutores().add(daoA.selectById(autor));
		} else {
			throw new RuntimeException("id do autor não pode ser nulo");
		}

	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
