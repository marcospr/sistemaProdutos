package br.com.sistemaprodutos.produto.controller;

import java.util.ArrayList;

import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.exceptions.DadosInvalidosException;
import br.com.sistemaprodutos.interfaces.GenericInterfaceService;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;
import br.com.sistemaprodutos.produto.dto.ProdutoDTO;
import br.com.sistemaprodutos.produto.model.ProdutoPO;
import br.com.sistemaprodutos.produto.model.ProdutoServiceImpl;
import br.com.sistemaprodutos.utilidades.ModelFactory;

public final class ProdutoFacade{
	private final GenericInterfaceService SERVICE;

	/*
	 * SINGLETON - INICIO
	 */
	private static ProdutoFacade instance;

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou executar
	 * qualquer a��o no momento da cria��o da classe. esse contrutor � privado
	 * para n�o deixar instanciar o objeto diretamente
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 06:49:40
	 * @version 1.0
	 */
	private ProdutoFacade(){
		SERVICE = new ProdutoServiceImpl();
	}

	/**
	 * 
	 * M�todo respons�vel por instanciar o controlador
	 * e devolver uma �nica inst�ncia
	 * 
	 * @return ProdutoFacade instance
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 06:52:42
	 * @version 1.0
	 */
	public static ProdutoFacade getInstance() {
		if ( instance == null ) {
			instance = new ProdutoFacade();
		}
		return instance;
	}

	/*
	 * SINGLETON - TERMINO
	 */

	/**
	 * 
	 * M�todo respons�vel por inserir um produto
	 * 
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 07:14:13
	 * @version 1.0
	 */
	public ProdutoDTO inserir( ProdutoDTO dto ) throws ApplicationException {
		try {
			AbstractPO poPersistido = SERVICE.inserir( ModelFactory.getPO( dto ) );
			return ModelFactory.getDTO( (ProdutoPO) poPersistido );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	/**
	 * 
	 * M�todo respons�vel por alterar um produto
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 07:15:15
	 * @version 1.0
	 */
	public void alterar( ProdutoDTO dto ) throws ApplicationException {
		try {
			SERVICE.alterar( ModelFactory.getPO( dto ) );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	/**
	 * 
	 * M�todo respons�vel por excluir um produto
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 07:16:33
	 * @version 1.0
	 */
	public void excluir( ProdutoDTO dto ) throws ApplicationException {
		try {
			SERVICE.excluir( ModelFactory.getPO( dto ) );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	public ArrayList< ProdutoDTO > filtrar( ProdutoDTO dto ) throws ApplicationException {
		try {
			/**
			 * cria um array de produtoPO e fitra com base na service, mas convertendo para ProdutoPO
			 * pois a service requer um po como par�metro para filtrar
			 */
			ArrayList< ProdutoPO > encontrados = (ArrayList< ProdutoPO >) SERVICE.filtrar( ModelFactory.getPO( dto ) );

			ArrayList< ProdutoDTO > listaDTO = new ArrayList<>();

			/**
			 * recupera o resultado da busca e
			 * coloca num novo array, mas agora com a convers�o para dto
			 */
			for ( ProdutoPO ProdutoPO : encontrados ) {
				listaDTO.add( ModelFactory.getDTO( ProdutoPO ) );
			}

			return listaDTO;
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}
}
