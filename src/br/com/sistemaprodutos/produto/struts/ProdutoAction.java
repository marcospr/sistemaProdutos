package br.com.sistemaprodutos.produto.struts;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.produto.controller.ProdutoFacade;
import br.com.sistemaprodutos.produto.dto.ProdutoDTO;
import br.com.sistemaprodutos.utilidades.Utilidades;
/**
 * Classe respons�vel pela comunica��o da camada WEB com a camada JAVA.
 * Todas as requisi��es feitas a Servlet Struts passar�o por classes como esta.
 * Nesta classe conter� todos os m�todos que ser�o, de alguma forma, chamados pela JSP,
 * como por exemplo: inserir, alterar, excluir, consultar, etc...
 * Est� classe � a liga��o direta com a camada WEB, sendo a ultima classe da camada JAVA.
 * Quando a JSP de categoria for submetida, o Struts procurar� loucamente por um m�todo na
 * classe action informada na propriedade "action" do formulario que contenha o nome
 * igual ao nome informado na propriedade "acao" do formulario na JSP.
 * Ex:
 * <form action="equipamentoAction">
 * <html:hidden property="acao" value="inserir"/>
 * .........
 * </form>
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 18/05/2014 12:05:43
 * @version 1.0
 */
public class ProdutoAction extends DispatchAction{
	private String caminhoRelativo;

	/**
	 * M�todo respons�vel por abrir a tela de Contato.
	 * Para que este m�todo possa ser chamado na JSP, � necess�rio que este tenha
	 * a estrutura abaixo:
	 * public ActionForward nome_do_metodo( ActionMapping mapping,
	 * ActionForm form,
	 * HttpServletRequest request,
	 * HttpServletResponse response){
	 * return mapping.findForward("nome da tela mapeada no struts-config");
	 * }
	 * 
	 * @param ActionMapping mapping - Respons�vel por localizar e abrir a tela cujo nome
	 *        foi informado como parametro ao m�todo "findForward".
	 * @param ActionForm form - Respons�vel por conter todos os atributos referentes a
	 *        tela preenchidos. Isso apenas se o formulario for submetido.
	 * @param HttpServletRequest request - Respons�vel por possibiliar a captura de dados
	 *        do meio WEB.
	 * @param HttpServletResponse response - Respons�vel por possibiliar o envio de dados
	 *        ao meio WEB.
	 * @return ActionForward - Tela a ser aberta.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 11/05/2014 15:29:30
	 * @version 1.0
	 */
	public ActionForward abrir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward inserir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		ProdutoForm meuForm = (ProdutoForm)form;
		
		try {
			ProdutoDTO dto = new ProdutoDTO();
			dto = meuForm.getProduto();
	        ProdutoFacade.getInstance().inserir( dto );
	        System.out.println("inserido com sucesso!!");
        } catch ( ApplicationException e ) {
        	System.out.println("Falha ao inserir"+e.getMessage());
	        e.printStackTrace();
        }
		
		System.out.println("inserir");
		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		System.out.println("alterar");
		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		System.out.println("buscar");
		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		System.out.println("excluir");
		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward gerarRelatorio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		System.out.println("gerarRelatorio");
		return mapping.findForward( "abrir_produto" );
	}
	
	public ActionForward upload( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		 ProdutoForm meuForm = (ProdutoForm) form;
		  String caminho = "c:/upload/turma_I";
		  caminhoRelativo = request.getContextPath()+"/upload";
		  try {
		   File arquivoUploaded = Utilidades.upload( meuForm.getFile(), caminhoRelativo );
		   //pega a imagem do upload e seta no form
		   meuForm.getProduto().setImagem(arquivoUploaded.getName() );
		  } catch ( Exception e ) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return mapping.findForward( "abrir_produto" );
		 }
	
	public ActionForward selecionar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		System.out.println("selecionar");
		return mapping.findForward( "abrir_produto" );
	}
}
