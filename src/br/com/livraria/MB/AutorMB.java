package br.com.livraria.MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.entity.Autor;

@ManagedBean(name = "autorMB")
@ViewScoped
public class AutorMB {
	private Autor autor = new Autor();
	private AutorDAO dao = new AutorDAO();

	public void cadastarAutor() {
		dao.save(autor);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
