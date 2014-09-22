package br.edu.granbery.tcc.dao;

import java.io.Serializable;

public interface GenericDao<T , ID extends Serializable> {
    public T findById(ID id);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
}
