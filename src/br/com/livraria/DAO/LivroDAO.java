package br.com.livraria.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.livraria.IF.DAO;
import br.com.livraria.entity.Livro;
import br.com.livraria.factory.HibernateSessionFactory;

public class LivroDAO implements DAO<Livro> {
	private Session session;

	@Override
	public void save(Livro object) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(Livro object) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.merge(object);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Livro object) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Livro> selectAll() {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		ArrayList<Livro> resultList = (ArrayList<Livro>) session.createQuery("from Livro").getResultList();
		session.getTransaction().commit();
		session.close();
		return resultList;
	}

	@Override
	public Livro selectById(Livro object) {
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.get(Livro.class, object.getId());
		session.getTransaction().commit();
		session.close();
		return object;
	}

}
