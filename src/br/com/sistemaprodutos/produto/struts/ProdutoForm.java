package br.com.sistemaprodutos.produto.struts;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import br.com.sistemaprodutos.categoria.controller.CategoriaFacade;
import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;
import br.com.sistemaprodutos.produto.dto.ProdutoDTO;

/**
 * Classe responsável por conter um atributo para cada campo na tela(JSP).
 * Todas as alterações que quiser fazer nos campos da tela, deverão ser feitas no FORM.
 * Isso porque a tela é carregada com base numa classe FORM, sendo assim, tudo que
 * fizer na classe FORM será refletido nos campos da tela.
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 18/05/2014 12:08:56
 * @version 1.0
 */
public final class ProdutoForm extends ActionForm{

	private static final long serialVersionUID = -8833548014857684893L;
	private ProdutoDTO produto;
	private ArrayList< ProdutoDTO > produtos;
	private FormFile file;

	public FormFile getFile() {
		return file;
	}

	public void setFile( FormFile file ) {
		this.file = file;
	}

	public ProdutoDTO getProduto() {
		if ( produto == null ) {
			produto = new ProdutoDTO();
		}
		return produto;
	}

	public void setProduto( ProdutoDTO produto ) {
		this.produto = produto;
	}

	public ArrayList< ProdutoDTO > getProdutos() {
		if ( produtos == null ) {
			produtos = new ArrayList<>();
		}
		return produtos;
	}

	public void setProdutos( ArrayList< ProdutoDTO > produtos ) {
		this.produtos = produtos;
	}

	/**
	 * 
	 * Método responsável por limpar o formulário
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 18/05/2014 12:10:04
	 * @version 1.0
	 */
	public void limparFormulario() {
		setProduto( null );
		getProdutos().clear();
	}

	public ArrayList< LabelValueBean > getComboCategoria() throws Throwable {
		  ArrayList< LabelValueBean > listacategoria = new ArrayList< LabelValueBean >();

		  try {
		   CategoriaDTO categoriaPesquisa = new CategoriaDTO();
		   
		   ArrayList< CategoriaDTO > categoriasEncontradas = CategoriaFacade.getInstance().filtrar( categoriaPesquisa );
		   
		   Iterator< CategoriaDTO > setIter = categoriasEncontradas.iterator();

		   LabelValueBean lvb = new LabelValueBean();
		   lvb.setLabel( "Selecione..." );
		   lvb.setValue( null );
		   listacategoria.add( lvb );

		   while ( setIter.hasNext() ) {
		    CategoriaDTO categoria = (CategoriaDTO) setIter.next();
		    lvb = new LabelValueBean();

		    lvb.setLabel( categoria.getNome() );
		    lvb.setValue( categoria.getId().toString() );

		    listacategoria.add( lvb );
		   }

		  } catch ( Exception e ) {
		   e.printStackTrace();
		  }
		  return listacategoria;
		 }
}
