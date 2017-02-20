package br.com.sistemaprodutos.categoria.struts;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;

/**
 * Classe respons�vel por conter um atributo para cada campo na tela(JSP).
 * Todas as altera��es que quiser fazer nos campos da tela, dever�o ser feitas no FORM.
 * Isso porque a tela � carregada com base numa classe FORM, sendo assim, tudo que
 * fizer na classe FORM ser� refletido nos campos da tela.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 11/05/2014 15:31:48
 * @version 1.0
 */
public final class CategoriaForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7428722218248039562L;
	private CategoriaDTO categoria;
	private ArrayList< CategoriaDTO > categorias;

	public CategoriaDTO getCategoria() {
		if ( categoria == null ) {
			categoria = new CategoriaDTO();
		}
		return categoria;
	}

	public void setCategoria( CategoriaDTO categoria ) {
		this.categoria = categoria;
	}

	public ArrayList< CategoriaDTO > getCategorias() {
		if ( categorias == null ) {
			categorias = new ArrayList<>();
		}
		return categorias;
	}

	public void setCategorias( ArrayList< CategoriaDTO > categorias ) {
		this.categorias = categorias;
	}

	/**
	 * 
	 * M�todo respons�vel por limpar os campos do formul�rio
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 15:56:57
	 * @version 1.0
	 */
	public void limparFormulario() {
		setCategoria( null );
		getCategorias().clear();

	}

}
