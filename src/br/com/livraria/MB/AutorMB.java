package br.com.livraria.MB;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.entity.Autor;

@ManagedBean(name = "autorMB")
@SessionScoped
public class AutorMB {
	private Autor autor = new Autor();
	private AutorDAO dao = new AutorDAO();

	public void cadastarAutor() { 
		dao.save(autor); 
		autor = new Autor(); 
	}

	public Autor getAutor() { return autor; }
	public void setAutor(Autor autor) { this.autor = autor; }
	
	public List<Autor> getAutores(){
		return dao.selectAll();
	}

}
