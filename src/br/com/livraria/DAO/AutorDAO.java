package br.com.livraria.DAO;

import java.util.List;

import org.hibernate.Session;

import br.com.livraria.IF.DAO;
import br.com.livraria.entity.Autor;
import br.com.livraria.factory.HibernateSessionFactory;

public class AutorDAO implements DAO<Autor> {
	private Session session;

	@Override
	public void save(Autor autor) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(autor);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Autor> selectAll() {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		List list = session.createQuery("from Autor").getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Autor selectById(Autor object) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Autor autor = session.get(Autor.class, object.getId());
		session.getTransaction().commit();
		session.close();
		return autor;
	}

	@Override
	public void update(Autor object) {
	}

	@Override
	public void delete(Autor object) {
	}

}
