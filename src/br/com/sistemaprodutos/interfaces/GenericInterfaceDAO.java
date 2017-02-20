package br.com.sistemaprodutos.interfaces;

import br.com.sistemaprodutos.exceptions.AlterarException;
import br.com.sistemaprodutos.exceptions.CommitException;
import br.com.sistemaprodutos.exceptions.ConexaoException;
import br.com.sistemaprodutos.exceptions.ExcluirException;
import br.com.sistemaprodutos.exceptions.FiltrarException;
import br.com.sistemaprodutos.exceptions.InserirException;
import br.com.sistemaprodutos.exceptions.RollbackException;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;

/**
 * 
 * Interface 
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 10:27:17
 * @version 1.0
 */
public interface GenericInterfaceDAO {
	/**
	 * 
	 * Método responsável por inserir um AbstractDTO
	 *
	 * @param po
	 * @return
	 * @throws InserirException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 27/04/2014 10:28:40
	 * @version 1.0
	 */
	AbstractPO inserir(AbstractPO po) throws InserirException;
	
	/**
	 * 
	 * Método responsável por alterar
	 *
	 * @param AbstractDTO po
	 * @throws AlterarException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 27/04/2014 10:30:24
	 * @version 1.0
	 */
	void alterar(AbstractPO po) throws AlterarException;
	
	void excluir(AbstractPO po) throws ExcluirException;
	Object filtrar(AbstractPO po) throws FiltrarException;
	void abrirSessao() throws ConexaoException;
	void iniciarTransacao() throws ConexaoException;
	void rollbackTransacao() throws RollbackException, ConexaoException;
	void commitTransacao() throws CommitException, ConexaoException;
	void fecharSessao() throws ConexaoException;
}
