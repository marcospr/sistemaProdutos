package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * consulta de dados na base.
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class FiltrarException extends SQLException {

	private static final long serialVersionUID = 7944722662633765597L;

	public FiltrarException(String message) {
		super(message);
	}

	public FiltrarException(String message, Throwable cause) {
		super(message, cause);
	}
}
