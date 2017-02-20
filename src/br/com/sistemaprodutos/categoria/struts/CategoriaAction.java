package br.com.sistemaprodutos.categoria.struts;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.sistemaprodutos.categoria.controller.CategoriaFacade;
import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;
import br.com.sistemaprodutos.exceptions.ApplicationException;

/**
 * Classe responsável pela comunicação da camada WEB com a camada JAVA.
 * Todas as requisições feitas a Servlet Struts passarão por classes como esta.
 * Nesta classe conterá todos os métodos que serão, de alguma forma, chamados pela JSP,
 * como por exemplo: inserir, alterar, excluir, consultar, etc...
 * Está classe é a ligação direta com a camada WEB, sendo a ultima classe da camada JAVA.
 * Quando a JSP de categoria for submetida, o Struts procurará loucamente por um método na
 * classe action informada na propriedade "action" do formulario que contenha o nome
 * igual ao nome informado na propriedade "acao" do formulario na JSP.
 * Ex:
 * <form action="equipamentoAction">
 * <html:hidden property="acao" value="inserir"/>
 * .........
 * </form>
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 11/05/2014 15:14:33
 * @version 1.0
 */
public final class CategoriaAction extends DispatchAction{

	/**
	 * Método responsável por abrir a tela de Contato.
	 * Para que este método possa ser chamado na JSP, é necessário que este tenha
	 * a estrutura abaixo:
	 * public ActionForward nome_do_metodo( ActionMapping mapping,
	 * ActionForm form,
	 * HttpServletRequest request,
	 * HttpServletResponse response){
	 * return mapping.findForward("nome da tela mapeada no struts-config");
	 * }
	 * 
	 * @param ActionMapping mapping - Responsável por localizar e abrir a tela cujo nome
	 *        foi informado como parametro ao método "findForward".
	 * @param ActionForm form - Responsável por conter todos os atributos referentes a
	 *        tela preenchidos. Isso apenas se o formulario for submetido.
	 * @param HttpServletRequest request - Responsável por possibiliar a captura de dados
	 *        do meio WEB.
	 * @param HttpServletResponse response - Responsável por possibiliar o envio de dados
	 *        ao meio WEB.
	 * @return ActionForward - Tela a ser aberta.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 15:29:30
	 * @version 1.0
	 */
	public ActionForward abrir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		return mapping.findForward( "abrir_categoria" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		System.out.println( "inserir" );
		CategoriaForm meuForm = (CategoriaForm) form;

		CategoriaDTO dto = meuForm.getCategoria();

		try {
			dto = CategoriaFacade.getInstance().inserir( dto );
			System.out.println( "inserido com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "falha" + e.getMessage() );
		}finally{
			meuForm.limparFormulario();
		}
		return mapping.findForward( "abrir_categoria" );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		System.out.println( "alterar" );
		CategoriaForm meuForm = (CategoriaForm) form;

		CategoriaDTO dto = meuForm.getCategoria();

		try {
			CategoriaFacade.getInstance().alterar( dto );
			System.out.println( "alterado com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "falha" + e.getMessage() );
		}finally{
			meuForm.limparFormulario();
		}
		return mapping.findForward( "abrir_categoria" );
	}

	public ActionForward buscar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		
		System.out.println( "abrir_categoria_consulta" );
		try {
			CategoriaForm meuForm = (CategoriaForm) form;
			CategoriaDTO dto = meuForm.getCategoria();
			
			ArrayList< CategoriaDTO > encontrados = CategoriaFacade.getInstance().filtrar( dto );
			//jogando os registros encontrados na sessão para serem utilizados na DisplayTag
			   request.setAttribute( "categoriaCorrente", encontrados);
			   request.setAttribute( "tamanhoTotal", encontrados.size() );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "falha" + e.getMessage() );
		}
		
		return mapping.findForward( "abrir_categoria_consulta" );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
	
		try {
			CategoriaForm meuForm = (CategoriaForm) form;
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId( meuForm.getCategoria().getId() );
			dto.setNome( meuForm.getCategoria().getNome() );
			
			//CategoriaDTO dto = meuForm.getCategoria();
	        CategoriaFacade.getInstance().excluir( dto );
        } catch ( ApplicationException e ) {
        	System.out.println( "falha ao excluir" + e.getMessage() );
	        e.printStackTrace();
        }
		return mapping.findForward( "abrir_categoria" );
	}

	public ActionForward gerarRelatorio( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		System.out.println( "gerarRelatorio" );
		return mapping.findForward( "abrir_categoria" );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		System.out.println( "abrir_categoria_consulta" );
		try {
			CategoriaForm meuForm = (CategoriaForm) form;
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(meuForm.getCategoria().getId());
			
			ArrayList< CategoriaDTO > encontrados = CategoriaFacade.getInstance().filtrar( dto );
			meuForm.setCategoria( encontrados.get( 0 ) );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "falha" + e.getMessage() );
		}
		return mapping.findForward( "abrir_categoria" );
	}
}
