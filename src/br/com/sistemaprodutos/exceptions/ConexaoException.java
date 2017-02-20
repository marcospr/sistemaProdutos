package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;

/**
 * Classe que representa o erro ocorrido no ato da
 * obtenção de uma conexão.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class ConexaoException extends SQLException{

	private static final long serialVersionUID = 9117181008920300596L;

	public ConexaoException( String message ){
		super( message );
	}

	public ConexaoException( String message, Throwable cause ){
		super( message, cause );
	}
}
