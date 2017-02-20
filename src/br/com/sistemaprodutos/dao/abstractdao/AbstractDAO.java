package br.com.sistemaprodutos.dao.abstractdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.sistemaprodutos.exceptions.AlterarException;
import br.com.sistemaprodutos.exceptions.CommitException;
import br.com.sistemaprodutos.exceptions.ConexaoException;
import br.com.sistemaprodutos.exceptions.ExcluirException;
import br.com.sistemaprodutos.exceptions.InserirException;
import br.com.sistemaprodutos.exceptions.RollbackException;
import br.com.sistemaprodutos.interfaces.GenericInterfaceDAO;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;

/**
 * Classe abstrata responsavél por gerenciar as requisições de conexão ao banco
 * de dados. Utilizando o Hibernate para adquirir uma sessão aberta.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 04/05/2014 01:50:33
 * @version 1.0
 */
public abstract class AbstractDAO implements GenericInterfaceDAO {

	/**
	 * Declarando uma constante que conterá uma fábrica de sessões do hibernate.
	 */
	private static final SessionFactory SESSION_FACTORY;
	private static ServiceRegistry serviceRegistry;
	protected Session sessaoCorrente;
	private Transaction transacao;

	static {
		Configuration cfg = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		SESSION_FACTORY = cfg.buildSessionFactory(serviceRegistry);
	}

	public void abrirSessao() throws ConexaoException {
		if (sessaoCorrente == null || !sessaoCorrente.isOpen()) {
			sessaoCorrente = SESSION_FACTORY.openSession();
		}
	}

	public void iniciarTransacao() throws ConexaoException {
		if (sessaoCorrente == null || !sessaoCorrente.isOpen()) {
			sessaoCorrente = SESSION_FACTORY.openSession();

			transacao = sessaoCorrente.beginTransaction();

		} else {
			transacao = sessaoCorrente.beginTransaction();
		}
	}

	public void rollbackTransacao() throws RollbackException, ConexaoException {
		if (transacao != null) {
			transacao.rollback();
		}
		fecharSessao();
	}

	public void commitTransacao() throws CommitException, ConexaoException {
		if (transacao != null) {
			transacao.commit();
		}
		fecharSessao();
	}

	public void fecharSessao() throws ConexaoException {
		if (sessaoCorrente != null && sessaoCorrente.isOpen()) {
			sessaoCorrente.close();
			sessaoCorrente = null;
		}
	}

	/**
	 * Método responsável por inserir um Objeto na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param Object
	 *            obj - Objeto contendo os dados a serem inseridos.
	 * @return AbstractDTO long - Objeto recem inserido
	 */
	public AbstractPO inserir(AbstractPO obj) throws InserirException {


		try {

			/*
			 * Ação desejada a ser executada no banco de dados. SAVE - Após
			 * inserir, o método 'save' retorna o id no qual o objeto foi
			 * inserido.
			 */
			Long idGerado = (Long)sessaoCorrente.save(obj);
			obj.setId(idGerado);
		} catch (Exception e) {
			throw new InserirException("Erro ao tentar inserir o OBJETO ["
					+ obj + "]", e);
		}

		return obj;
	}

	/**
	 * Método responsável por alterar um Objeto na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param Object
	 *            obj - Objeto contendo os dados a serem alterados.
	 */
	public void alterar(AbstractPO obj) throws AlterarException {
		try {
			/*
			 * Ação desejada a ser executada no banco de dados.
			 */
			sessaoCorrente.update(obj);
		} catch (Exception e) {
			throw new AlterarException("Erro ao tentar alterar o OBJETO ["
					+ obj + "]", e);
		}
	}

	/**
	 * Método responsável por excluir um AbstractDTO na base de dados com o
	 * auxílio da framework Hibernate.
	 * 
	 * @param Object
	 *            obj - Objeto contendo os dados a serem excluidos.
	 */
	public void excluir(AbstractPO obj) throws ExcluirException {

		try {
			/*
			 * Ação desejada a ser executada no banco de dados.
			 */
			sessaoCorrente.delete(obj);
		} catch (Exception e) {
			throw new ExcluirException("Erro ao tentar excluir o OBJETO ["
					+ obj + "]", e);
		}
	}
}