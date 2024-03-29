package br.edu.granbery.tcc.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoImpl<T extends Serializable , ID extends Serializable> implements GenericDao<T, ID>{

    private Class<T> type;
///////teste local
    @PersistenceContext(unitName="tccEJB")
    private EntityManager em;
    
    //////////
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
    
    public List<T> findAll(Class<T> classe){
    	String select = "SELECT DISTINCT o FROM ".concat(classe.getSimpleName()).concat(" o");
    	Query query = getEntityManager().createQuery(select);
    	return query.getResultList();
    }
    
    public void atualizar(T entity) {
    	getEntityManager().merge(entity);
    	getEntityManager().flush();
    }
    
}
