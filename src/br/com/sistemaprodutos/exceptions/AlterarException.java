package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;

/**
 * Classe que representa o erro ocorrido no ato da
 * alteração de dados na base.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class AlterarException extends SQLException{
	private static final long serialVersionUID = 8128445782418316010L;

	public AlterarException( String message ){
		super( message );
	}

	public AlterarException( String message, Throwable cause ){
		super( message, cause );
	}
}
