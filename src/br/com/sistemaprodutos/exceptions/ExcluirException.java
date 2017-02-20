package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * exclusão de dados na base.
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class ExcluirException extends SQLException {

	private static final long serialVersionUID = 4388643177175543410L;

	public ExcluirException(String message) {
		super(message);
	}

	public ExcluirException(String message, Throwable cause) {
		super(message, cause);
	}
}
