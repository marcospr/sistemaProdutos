package br.com.sistemaprodutos.utilidades;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages; 

/**
 * Classe responsável por emitir mensagens.
 * 
 * @author gabriel.carvalheiro
 * @version 1.0
 * @since 13/04/2009
 */
public class Messages {
	public static ActionMessages createMessages( String key ) {
		ActionMessages iMessages = new ActionMessages();
		iMessages.add( Globals.MESSAGES_KEY , Messages.createMessage( key ) );
		return iMessages;
	}

	public static ActionMessages createMessages( String key , String[] values ) {
		ActionMessages iMessages = new ActionMessages();
		iMessages.add( Globals.MESSAGES_KEY , Messages.createMessage( key , values ) );
		return iMessages;
	}

	public static ActionMessage createMessage( String key ) {
		return new ActionMessage( key );
	}

	public static ActionMessage createMessage( String key , String[] values ) {
		return new ActionMessage( key , values );
	}
}
