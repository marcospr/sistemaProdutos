package br.com.sistemaprodutos.exceptions;


public final class RelatorioException extends Exception {
    private static final long serialVersionUID = 3649384946972879502L;

	public RelatorioException(String message) {
		super(message);		
	}

	public RelatorioException(Throwable cause) {
		super(cause);		
	}

	public RelatorioException(String message, Throwable cause) {
		super(message, cause);
	}
}