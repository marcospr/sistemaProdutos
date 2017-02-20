package br.com.sistemaprodutos.utilidades;

import java.math.BigDecimal;
import java.util.Date;

import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;
import br.com.sistemaprodutos.categoria.model.CategoriaPO;
import br.com.sistemaprodutos.exceptions.DadosInvalidosException;
import br.com.sistemaprodutos.produto.dto.ProdutoDTO;
import br.com.sistemaprodutos.produto.model.ProdutoPO;

/**
 * 
 * Classe responsável por transformar dto em po e vice-versa
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:26:41
 * @version 1.0
 */
public abstract class ModelFactory{

	/**
	 * 
	 * Método responsável por transformar uma categoriaDTO em categoriaPO
	 * 
	 * @param dto
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 27/04/2014 14:26:41
	 * @version 1.0
	 */
	public static CategoriaPO getPO( CategoriaDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}
		// tudo que for String no PO, deverá ser tratato aqui
		Long id = (Long) Utilidades.parseValue( dto.getId(), Long.class );

		// setando os não convertidos
		CategoriaPO po = new CategoriaPO();
		po.setId( id );
		po.setNome( dto.getNome() );

		return po;
	}

	/**
	 * 
	 * Método responsável por pegar um po e transformar em dto
	 * 
	 * @param po
	 * @return
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 04/05/2014 11:18:35
	 * @version 1.0
	 * @throws DadosInvalidosException
	 */
	public static CategoriaDTO getDTO( CategoriaPO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}
		// tudo que for String no PO, deverá ser tratato aqui
		String id = (String) Utilidades.parseValue( po.getId(), String.class );

		// setando os não convertidos
		CategoriaDTO dto = new CategoriaDTO();
		dto.setId( id );
		dto.setNome( po.getNome().toString() );

		return dto;
	}

	/**
	 * 
	 * Método responsável por pegar um ProdutoDTO e transformar em ProdutoPO
	 * 
	 * @param dto
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 07:05:27
	 * @version 1.0
	 */
	public static ProdutoPO getPO( ProdutoDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado, falhou aqui" );
		}

		// tudo que não for String no PO, deverá ser tratato aqui
		Long id = (Long) Utilidades.parseValue( dto.getId(), Long.class );
		BigDecimal preco = (BigDecimal) Utilidades.parseValue( dto.getPreco(), BigDecimal.class );
		Date dataCadastro = (Date) Utilidades.parseValue( dto.getDataCadastro(), Date.class );
		CategoriaPO categoria = getPO( dto.getCategoria() );

		ProdutoPO po = new ProdutoPO( id,dto.getNome(), preco, dataCadastro, categoria, dto.getImagem() );
		return po;
	}

	public static ProdutoDTO getDTO( ProdutoPO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}

		// tudos dados que não forem string
		String preco = po.getPreco().toString();
		String dataCadastro = po.getDataCadastro().toString();
		CategoriaDTO categoria = getDTO( po.getCategoria() );
		String id = po.getId().toString();

		ProdutoDTO dto = new ProdutoDTO(po.getNome(), preco, dataCadastro, categoria, po.getImagem(), id );
		return dto;
	}
}
