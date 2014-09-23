package br.edu.granbery.tcc.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T extends Serializable , ID extends Serializable> implements GenericDao<T, ID>{

    private Class<T> type;

    @PersistenceContext(unitName="tccEJB")
    private EntityManager em;
    
    
    @PostConstruct
	private void load(){
		setEntityManager(em);
	}    
    
    
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    
    protected EntityManager getEntityManager() {
        if (em == null)
            throw new IllegalStateException("EntityManager não foi setado antes do uso neste DAO");
        return em;
    }

    public Class<T> getType() {
        return type;
    }
    
    public T findById(ID id) {
        return (T) getEntityManager().find(getType(), id);
    }

    public void delete(T obj) {
	  getEntityManager().remove(obj);
    }
    
    public void saveOrUpdate(T obj) {
    	getEntityManager().persist(obj);
    }
}
