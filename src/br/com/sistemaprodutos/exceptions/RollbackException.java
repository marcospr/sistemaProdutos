package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * concelamento dos processos realizados na conexão.
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class RollbackException extends SQLException {

	private static final long serialVersionUID = 2568550407371900819L;

	public RollbackException(String message) {
		super(message);
	}

	public RollbackException(String message, Throwable cause) {
		super(message, cause);
	}
}
