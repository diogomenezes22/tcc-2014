package br.edu.granbery.tcc.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T , ID extends Serializable> {
   
	//////////////
	public T findById(ID id);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
    public List<T> findAll(Class<T> classe);
    public void atualizar(T entity);
}
