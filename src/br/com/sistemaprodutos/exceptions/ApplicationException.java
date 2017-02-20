package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;

/**
 * Classe que representa o erro ocorrido na Aplicação.
 * 
 * Este erro será lançado sempre para as camadas de front-end.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 12/09/2013 21:30:13
 * @version 1.0
 */
public final class ApplicationException extends SQLException{

	private static final long serialVersionUID = -3663170990643470657L;

	public ApplicationException( String message ){
		super( message );
	}

	public ApplicationException( String message, Throwable cause ){
		super( message, cause );
	}
}
