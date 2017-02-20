package br.com.sistemaprodutos.exceptions;

import java.sql.SQLException;

/**
 * Classe que representa o erro ocorrido no ato da
 * confirmação dos processos realizados na conexão.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class CommitException extends SQLException{

	private static final long serialVersionUID = -1782279019692835818L;

	public CommitException( String message ){
		super( message );
	}

	public CommitException( String message, Throwable cause ){
		super( message, cause );
	}
}
