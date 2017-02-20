package br.com.sistemaprodutos.categoria.controller;

import java.util.ArrayList;

import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;
import br.com.sistemaprodutos.categoria.model.CategoriaPO;
import br.com.sistemaprodutos.categoria.model.CategoriaServiceImpl;
import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.exceptions.DadosInvalidosException;
import br.com.sistemaprodutos.interfaces.GenericInterfaceService;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;
import br.com.sistemaprodutos.utilidades.ModelFactory;
import br.com.sistemaprodutos.utilidades.Utilidades;

/**
 * 
 * Classe que responsável gerar o objeto controlador da categoria
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 04/05/2014 11:54:28
 * @version 1.0
 */
public final class CategoriaFacade {
	private final GenericInterfaceService SERVICE;

	/*
	 * SINGLETON - INICIO
	 */
	private static CategoriaFacade instance;

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou executar
	 * qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 12:15:21
	 * @version 1.0
	 */
	private CategoriaFacade() {
		SERVICE = new CategoriaServiceImpl();
	}

	/**
	 * 
	 * Método responsável por retornar uma instancia do proprio objeto
	 * 
	 * @return CategoriaFacade instance
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 12:10:51
	 * @version 1.0
	 */
	public static CategoriaFacade getInstance() {

		if (Utilidades.isNuloOuVazio(instance)) {
			instance = new CategoriaFacade();
		}
		return instance;
	}

	/*
	 * SINGLETON - TERMINO
	 */

	/**
	 * 
	 * Método responsável por inserir um objeto do tipo CategoriaDTO
	 * 
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 14:39:00
	 * @version 1.0
	 */
	public CategoriaDTO inserir(CategoriaDTO dto) throws ApplicationException {
		try {
			AbstractPO poPersistido = SERVICE.inserir(ModelFactory.getPO(dto));
			return ModelFactory.getDTO((CategoriaPO) poPersistido);
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/**
	 * 
	 * Método responsável por alterar um objeto do tipo CategoriaDTO
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 14:43:06
	 * @version 1.0
	 */
	public void alterar(CategoriaDTO dto) throws ApplicationException {
		try {
			SERVICE.alterar(ModelFactory.getPO(dto));
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/**
	 * 
	 * Método responsável por excluir um objeto do tipo CategoriaDTO
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 15:05:41
	 * @version 1.0
	 */
	public void excluir(CategoriaDTO dto) throws ApplicationException {
		try {
			SERVICE.excluir(ModelFactory.getPO(dto));
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/**
	 * 
	 * Método responsável por filtrar objetos do tipo CategoriaDTO
	 *
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 15:06:30
	 * @version 1.0
	 */
	public ArrayList<CategoriaDTO> filtrar(CategoriaDTO dto)
			throws ApplicationException {
		try {
			ArrayList<CategoriaPO> encontrados = (ArrayList<CategoriaPO>) SERVICE.filtrar(ModelFactory.getPO(dto));

			ArrayList<CategoriaDTO> listaDTO = new ArrayList<>();

			for (CategoriaPO categoriaPO : encontrados) {
				listaDTO.add(ModelFactory.getDTO(categoriaPO));
			}

			return listaDTO;
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

}
