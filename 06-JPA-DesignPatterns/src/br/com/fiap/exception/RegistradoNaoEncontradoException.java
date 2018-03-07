package br.com.fiap.exception;

public class RegistradoNaoEncontradoException extends Exception {

	public RegistradoNaoEncontradoException() {
		// TODO Auto-generated constructor stub
	}

	public RegistradoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public RegistradoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public RegistradoNaoEncontradoException(String message) {
		super(message);
	}

	public RegistradoNaoEncontradoException(Throwable cause) {
		super(cause);
	}
	
	

}
