package br.com.livraria.factory;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	public static Session getSession() {
		return new Configuration().configure().buildSessionFactory().getCurrentSession();
	}
}
