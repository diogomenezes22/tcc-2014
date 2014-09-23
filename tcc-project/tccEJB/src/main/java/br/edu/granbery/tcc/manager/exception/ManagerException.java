package br.edu.granbery.tcc.manager.exception;

import javax.ejb.ApplicationException;

import br.edu.granbery.tcc.dao.exception.DaoException;

@ApplicationException(rollback=true)
public class ManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5441155010716319649L;

	public ManagerException(String string) {
		super(string);
	}
	
	public ManagerException(String string, Throwable cause) {
		super(string, cause);
	}

	public ManagerException(DaoException e) {
		super(e);
	}
}
