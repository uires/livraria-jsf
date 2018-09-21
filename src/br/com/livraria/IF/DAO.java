package br.com.livraria.IF;

import java.util.List;

public interface DAO <T>{
	public void save(T object);
	public void update(T object);
	public void delete(T object);
	public List<?> selectAll();
	public T selectById(T object);
}
