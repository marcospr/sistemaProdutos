package br.com.sistemaprodutos.categoria.dao;

import org.hibernate.Query;

import br.com.sistemaprodutos.categoria.model.CategoriaPO;
import br.com.sistemaprodutos.dao.abstractdao.AbstractDAO;
import br.com.sistemaprodutos.exceptions.FiltrarException;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;

/**
 * 
 * Classe que representa um objeto que irá realizar as operações de persistência
 * de objetos categoriaPO
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 16:01:35
 * @version 1.0
 */
public final class CategoriaDAOImpl extends AbstractDAO {

	@Override
	public Object filtrar(AbstractPO po) throws FiltrarException {
		CategoriaPO poFiltrar = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CategoriaPO) {
			poFiltrar = (CategoriaPO) po;
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
			HQL.append("SELECT cat FROM ");
			HQL.append(" CategoriaPO cat ");
			HQL.append(" WHERE 1=1 ");

			if (poFiltrar.getId() != null ) {
				HQL.append("AND cat.id=:idParam ");
			}
			
			if(poFiltrar.getNome()!=null && !poFiltrar.getNome().isEmpty()){
				HQL.append("AND cat.nome=:nomeParam ");
			}
			
			/*
			 * Criando e inicializando uma variavel responsável por criar uma
			 * Query com base na nossa HQL criada acima deixando-a preparada
			 * para o Hibernate executa-la.
			 */
			Query query = sessaoCorrente.createQuery(HQL.toString());

			if (poFiltrar.getId() != null) {
				query.setLong("idParam", poFiltrar.getId());
			}
			
			if(poFiltrar.getNome()!=null && !poFiltrar.getNome().isEmpty()){
				query.setString("nomeParam", poFiltrar.getNome());
			}
			System.out.println(HQL.toString());

			// Executando a Query retornando o casting de seu resultado.
			return query.list();
		} catch (Throwable e) {
			throw new FiltrarException("Erro ao filtrar",e);
		} 
	}
}
