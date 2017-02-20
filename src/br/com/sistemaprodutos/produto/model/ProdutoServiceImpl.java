package br.com.sistemaprodutos.produto.model;

import java.util.ArrayList;

import br.com.sistemaprodutos.exceptions.AlterarException;
import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.exceptions.ConexaoException;
import br.com.sistemaprodutos.exceptions.ExcluirException;
import br.com.sistemaprodutos.exceptions.FiltrarException;
import br.com.sistemaprodutos.exceptions.InserirException;
import br.com.sistemaprodutos.exceptions.RollbackException;
import br.com.sistemaprodutos.interfaces.GenericInterfaceDAO;
import br.com.sistemaprodutos.interfaces.GenericInterfaceService;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;
import br.com.sistemaprodutos.produto.dao.ProdutoDAOImpl;

/**
 * Classe responsável por conter as regras de negócios do nosso sistema. Esta
 * classe representa a camada Model(M) do MVC. Será nesta Classe que iremos
 * pegar os dados dos campos da tela( V ) e preencher o nosso PO(M) enviando-o á
 * camada DAO para consultas e persistencias. Neste nosso sistema, todos os
 * tratamentos de exceção estarão centralizados aqui, juntamente com as
 * possíveis validações de campos e regras.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 04/05/2014 01:54:01
 * @version 1.0
 */
public final class ProdutoServiceImpl implements GenericInterfaceService{

	private GenericInterfaceDAO DAO;

	public ProdutoServiceImpl(){
		DAO = new ProdutoDAOImpl();
	}

	@Override
	public AbstractPO inserir( AbstractPO po ) throws ApplicationException {
		ProdutoPO poPersistir = null;
		// verifica se o objeto é do tipo ProdutoDTO
		if ( po instanceof ProdutoPO ) {
			poPersistir = (ProdutoPO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}
		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */

			DAO.iniciarTransacao();

			poPersistir = (ProdutoPO) DAO.inserir( poPersistir );

			/* Comita a sessão* */
			DAO.fecharSessao();
			DAO.commitTransacao();
			return poPersistir;
		} catch ( InserirException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			} catch ( RollbackException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			} catch ( RollbackException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
		}
	}

	@Override
	public void alterar( AbstractPO po ) throws ApplicationException {
		ProdutoPO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if ( po instanceof ProdutoPO ) {
			poPersistir = (ProdutoPO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			DAO.alterar( poPersistir );

			/* Comita a sessão* */
			DAO.commitTransacao();
			DAO.fecharSessao();
		} catch ( AlterarException e ) {

			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
		}

	}

	@Override
	public void excluir( AbstractPO po ) throws ApplicationException {
		ProdutoPO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if ( po instanceof ProdutoPO ) {
			poPersistir = (ProdutoPO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			DAO.excluir( poPersistir );

			/* Comita a sessão* */
			DAO.commitTransacao();
			DAO.fecharSessao();
		} catch ( ExcluirException e ) {

			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
		}

	}

	@SuppressWarnings( "unchecked" )
	@Override
	public Object filtrar( AbstractPO po ) throws ApplicationException {
		ProdutoPO poFiltrar = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if ( po instanceof ProdutoPO ) {
			poFiltrar = (ProdutoPO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poFiltrar );
		}

		try {
			DAO.abrirSessao();
			return (ArrayList< ProdutoPO >) DAO.filtrar( poFiltrar );
		} catch ( FiltrarException e ) {
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e ) {
				throw new ApplicationException( e.getMessage(), e );
			}
		}
	}
}
