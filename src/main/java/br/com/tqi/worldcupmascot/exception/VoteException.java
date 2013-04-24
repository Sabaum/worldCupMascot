package br.com.tqi.worldcupmascot.exception;

public class VoteException extends Exception {

	private static final long serialVersionUID = 4693531717000445439L;

	public VoteException(String message) {
		super(message);
	}
	
	public VoteException(String message, Throwable e) {
		super(message, e);
		
	}
}
