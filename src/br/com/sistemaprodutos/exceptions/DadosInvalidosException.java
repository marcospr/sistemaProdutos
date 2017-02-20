package br.com.sistemaprodutos.exceptions;

public final class DadosInvalidosException extends Exception{ 
    private static final long serialVersionUID = -3764499778130760199L;

	public DadosInvalidosException(String message) {
		super(message);		
	}

	public DadosInvalidosException(Throwable cause) {
		super(cause);		
	}

	public DadosInvalidosException(String message, Throwable cause) {
		super(message, cause);
	}
}
