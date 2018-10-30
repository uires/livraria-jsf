package br.com.livraria.MB;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.xml.bind.ValidationException;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.DAO.LivroDAO;
import br.com.livraria.entity.Autor;
import br.com.livraria.entity.Livro;

@ManagedBean(name = "livroMB")
@ViewScoped
public class LivroMB {
	private Long autorId;
	private Livro livro = new Livro();
	
	private LivroDAO daoL = new LivroDAO();
	private AutorDAO daoA = new AutorDAO();
	
	// Getters e Setters
	public List<Autor> getAutores() { return daoA.selectAll(); }
	public List<Livro> getLivros() { return daoL.selectAll(); }
	public Livro getLivro() { return livro; }
	public void setLivro(Livro livro) { this.livro = livro; }
	public Long getAutorId() { return autorId; }
	public void setAutorId(Long autorId) { this.autorId = autorId; }
	
	//	Ações
	public String cadastrarLivro() {
		if (livro.getAutores().size() == 0) {
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Não foi possível gravar o autor!"));
		}
		daoL.save(livro);
		livro = new Livro();
		return "../index.xhtml?faces-redirect=true";
	}

	public void gravarAutor() {
		if (autorId != null) {
			Autor autor = new Autor();
			autor.setId(autorId);
			livro.getAutores().add(daoA.selectById(autor));
		} else {
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Não foi possível gravar o autor!"));
		}
	}
	
	// Validation Rules
	public void validarIsbnModeloLivro(FacesContext facesContext, UIComponent component, Object value) throws ValidationException {
		String valor = value.toString();
		if( !valor.startsWith("9")) {
			throw new ValidatorException(new FacesMessage("Esse campo deve começar por padrão com 9"));
		}
	}
}
