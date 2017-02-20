package br.com.sistemaprodutos.testa;

import java.util.ArrayList;

import javax.persistence.Temporal;

import br.com.sistemaprodutos.categoria.controller.CategoriaFacade;
import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;
import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.produto.controller.ProdutoFacade;
import br.com.sistemaprodutos.produto.dto.ProdutoDTO;
import br.com.sistemaprodutos.utilidades.Utilidades;

public final class TestaBackend {

	/**
	 * cadastrar categoria
	 */
	
	public static void inserirCategoria() {
		try {

				CategoriaDTO dto = new CategoriaDTO();
				dto.setId("12");
				dto.setNome("categoria xx");

				CategoriaFacade.getInstance().inserir(dto);

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * cadastrar produto
	 */
	private static void inserirProduto(){
	
		try {
			CategoriaDTO categoria = pegarCategoriaPorId("1" );
			ProdutoDTO dto = new ProdutoDTO("Farinha", "2.70", "11/03/2014",categoria , "img_farinha.jpg","10");
			ProdutoFacade.getInstance().inserir(dto);
		} catch (ApplicationException e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir "+e.getMessage());
		}
	}
	
	
	private static void alterarProduto(){
		
		try {
			
			CategoriaDTO categoria = pegarCategoriaPorId("2" );
			ProdutoDTO dto = new ProdutoDTO("Farinha trigo", "2.79", "18/05/2014",categoria , "img_farinha.jpg","10");
			ProdutoFacade.getInstance().alterar( dto );
		} catch (ApplicationException e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir "+e.getMessage());
		}
	}
	
	//filtra produtos
	private static ArrayList< ProdutoDTO > filtrarProduto(String id) throws ApplicationException{
		ProdutoDTO produto = new ProdutoDTO();
		produto.setCategoria( pegarCategoriaPorId( id ) );
		produto.setNome( "Produto xx" );
		ArrayList< ProdutoDTO > encontrados = ProdutoFacade.getInstance().filtrar( produto);
		return encontrados;
	}
	 
	private static CategoriaDTO pegarCategoriaPorId(String id) throws ApplicationException{
		
		ArrayList< CategoriaDTO > encontrados = CategoriaFacade.getInstance().filtrar( new CategoriaDTO(id) );
		
		return (Utilidades.isNuloOuVazio(encontrados)? null: encontrados.get(0 ) );
	}

	public static void main(String[] args) {
		inserirCategoria();
		//inserirProduto();
		//alterarProduto();
		
		/**
		try {
	        ArrayList< ProdutoDTO > produto = filtrarProduto("1");
	        for ( ProdutoDTO produtoDTO : produto ) {
	            System.out.println(produtoDTO);
	            System.out.println(produtoDTO.getCategoria().getNome());
            }
        } catch ( ApplicationException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
        */
		
	}

}
