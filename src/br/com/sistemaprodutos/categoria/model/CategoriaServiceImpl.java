package br.com.sistemaprodutos.categoria.model;

import java.util.ArrayList;

import br.com.sistemaprodutos.categoria.dao.CategoriaDAOImpl;
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

/**
 * Classe responsável por conter as regras de negócios do nosso sistema. Esta
 * classe representa a camada Model(M) do MVC. Será nesta Classe que iremos
 * pegar os dados dos campos da tela( V ) e preencher o nosso PO(M) enviando-o á
 * camada DAO para consultas e persistencias. Neste nosso sistema, todos os
 * tratamentos de exceção estarão centralizados aqui, juntamente com as
 * possíveis validações de campos e regras.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 17:11:57
 * @version 1.0
 */
public final class CategoriaServiceImpl implements GenericInterfaceService {

	private GenericInterfaceDAO DAO;

	public CategoriaServiceImpl() {
		DAO = new CategoriaDAOImpl();
	}

	@Override
	public AbstractPO inserir(AbstractPO po) throws ApplicationException {
		CategoriaPO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CategoriaPO) {
			poPersistir = (CategoriaPO) po;
		} else {
			throw new ApplicationException(
					"Objeto informado não condiz com o contexto: "
							+ poPersistir);
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			poPersistir = (CategoriaPO) DAO.inserir(poPersistir);
			
			/* Comita a sessão* */
			DAO.commitTransacao();
			
			return poPersistir;
		} catch (InserirException e) {

			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		} catch (Exception e) {
			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		}finally{
			try {
				DAO.fecharSessao();
			} catch (ConexaoException e) {
			
				e.printStackTrace();
			}
		}

	}

	@Override
	public void alterar(AbstractPO po) throws ApplicationException {
		CategoriaPO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CategoriaPO) {
			poPersistir = (CategoriaPO) po;
		} else {
			throw new ApplicationException(
					"Objeto informado não condiz com o contexto: "
							+ poPersistir);
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			DAO.alterar(poPersistir);

			/* Comita a sessão* */
			DAO.commitTransacao();
			
		} catch (AlterarException e) {

			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		} catch (Exception e) {
			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		}finally{
			try {
				DAO.fecharSessao();
			} catch (ConexaoException e) {
			
				e.printStackTrace();
			}
		}

	}

	@Override
	public void excluir(AbstractPO po) throws ApplicationException {

		CategoriaPO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CategoriaPO) {
			poPersistir = (CategoriaPO) po;
		} else {
			throw new ApplicationException(
					"Objeto informado não condiz com o contexto: "
							+ poPersistir);
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();
			System.out.println("id para excluir"+poPersistir.getId());
			DAO.excluir(poPersistir);

			/* Comita a sessão* */
			DAO.commitTransacao();
		} catch (ExcluirException e) {

			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		} catch (Exception e) {
			try {
				DAO.rollbackTransacao();
			} catch (RollbackException e1) {
				e1.printStackTrace();
			} catch (ConexaoException e1) {
				throw new ApplicationException(e1.getMessage(), e1);
			}
			throw new ApplicationException(e.getMessage(), e);
		}finally{
			try {
				DAO.fecharSessao();
			} catch (ConexaoException e) {
			
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object filtrar(AbstractPO po) throws ApplicationException {
		CategoriaPO poFiltrar = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CategoriaPO) {
			poFiltrar = (CategoriaPO) po;
		} else {
			throw new ApplicationException(
					"Objeto informado não condiz com o contexto: " + poFiltrar);
		}

		try {
			DAO.abrirSessao();
			return (ArrayList<CategoriaPO>) DAO.filtrar(poFiltrar);
		} catch (FiltrarException e) {
			throw new ApplicationException(e.getMessage(), e);
		} catch (Exception e) {
			throw new ApplicationException("Erro desconhecido ao inserir", e);
		} finally {
			try {
				DAO.fecharSessao();
			} catch (ConexaoException e) {
				throw new ApplicationException(e.getMessage(), e);
			}
		}
	}
}
