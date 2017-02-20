package br.com.sistemaprodutos.produto.dao;

import org.hibernate.Query;

import br.com.sistemaprodutos.dao.abstractdao.AbstractDAO;
import br.com.sistemaprodutos.exceptions.ConexaoException;
import br.com.sistemaprodutos.exceptions.FiltrarException;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;
import br.com.sistemaprodutos.produto.model.ProdutoPO;

/**
 * 
 * Classe que representa um objeto do tipo ProdutoDAOImpl que fará a
 * persistência do ProdutoDTO
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 16:38:34
 * @version 1.0
 */
public final class ProdutoDAOImpl extends AbstractDAO {

	@Override
	public Object filtrar(AbstractPO po) throws FiltrarException {
		ProdutoPO poFiltrar = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof ProdutoPO) {
			poFiltrar = (ProdutoPO) po;
		} else {
			throw new FiltrarException(
					"Objeto informado não condiz com o contexto: " + poFiltrar);
		}

		try {
			abrirSessao();

			// Criando uma HQL(Hibernate Query Language) como se estivessemos
			// criando uma NamedQuery
			/** Constante que contém a HQL a ser executada */
			final StringBuffer HQL = new StringBuffer();
			HQL.append("SELECT prod FROM ");
			HQL.append("ProdutoPO prod ");
			HQL.append("WHERE 1=1 ");

			if (poFiltrar.getId() != null) {
				HQL.append("AND prod.id=:idParam ");
			}
			if (poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty()) {
				HQL.append("AND prod.nome=:nomeParam ");
			}

			if (poFiltrar.getPreco() != null) {
				HQL.append("AND prod.preco=:precoParam");
			}
			if (poFiltrar.getDataCadastro() != null) {
				HQL.append("AND prod.dataCadastro=:dataCadastroParam");
			}
			
			//##inicio Montando o IF do JOIN
			
			if(poFiltrar.getCategoria().getNome()!=null && !poFiltrar.getCategoria().getNome().isEmpty()){
				HQL.append("AND prod.categoria.nome=:nomeCategoriaParam ");
			}
			
			//##fim Montando o IF do JOIN
			
			
			/*
			 * Criando e inicializando uma variavel responsável por criar uma
			 * Query com base na nossa HQL criada acima deixando-a preparada
			 * para o Hibernate executa-la.
			 */
			Query query = sessaoCorrente.createQuery(HQL.toString());

			if (poFiltrar.getId() != null) {
				query.setLong("idParam", poFiltrar.getId());
			}
			if (poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty()) {
				query.setString("nomeParam", poFiltrar.getNome());
			}

			if (poFiltrar.getPreco() != null ) {
				query.setBigDecimal("precoParam", poFiltrar.getPreco());
			}
			if (poFiltrar.getDataCadastro() != null) {
				query.setDate("dataCadastroParam", poFiltrar.getDataCadastro());
			}
						
			//##inicio Montando o IF do JOIN
			if(poFiltrar.getCategoria().getNome()!=null && !poFiltrar.getCategoria().getNome().isEmpty()){
				query.setString("nomeCategoriaParam", poFiltrar.getCategoria().getNome());
			}
			//##fim Montando o IF do JOIN

			System.out.println(HQL.toString());

			// Executando a Query retornando o casting de seu resultado.
			return query.list();
		} catch (Throwable e) {
			throw new FiltrarException("Erro ao filtrar", e);
		} finally {
			try {
				fecharSessao();
			} catch (ConexaoException e) {
			}
		}
	}

}
