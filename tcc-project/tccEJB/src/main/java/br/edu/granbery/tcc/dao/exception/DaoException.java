package br.edu.granbery.tcc.dao.exception;

public class DaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -640941937188353626L;
	public final static int _FAIL_TO_INSERT = 1;
    public final static int _UPDATE_FAILED = 2;
    public final static int _SQL_ERROR = 3;
    private int errorCode;
    
    
    public DaoException(int errorCode) {
        this.errorCode = errorCode;
    }
    
    public int getErrorCode() {
        return errorCode;
    }
}
