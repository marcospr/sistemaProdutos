package br.com.sistemaprodutos.produto.dto;

import br.com.sistemaprodutos.abstractdto.AbstractDTO;
import br.com.sistemaprodutos.categoria.dto.CategoriaDTO;

/**
 * 
 * Classe que representa um objeto do tipo produtoDTO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:44:33
 * @version 1.0
 */
public final class ProdutoDTO extends AbstractDTO{

    private static final long serialVersionUID = -399209272662272727L;
	private String nome;
	private String preco;
	private String dataCadastro;
	private CategoriaDTO categoria;
	private String imagem;

	public ProdutoDTO(){

	}

	public ProdutoDTO( String id ){
		super( id );
	}

	public ProdutoDTO(String nome, String preco, String dataCadastro, CategoriaDTO categoria, String imagem, String id ){
		super( id );
		setNome( nome );
		setPreco( preco );
		setDataCadastro( dataCadastro );
		setCategoria( categoria );
		setImagem( imagem );
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco( String preco ) {
		this.preco = preco;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro( String dataCadastro ) {
		this.dataCadastro = dataCadastro;
	}

	public CategoriaDTO getCategoria() {
		if(categoria==null){
			categoria = new CategoriaDTO();
		}
		return categoria;
	}

	public void setCategoria( CategoriaDTO categoria ) {
		this.categoria = categoria;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem( String imagem ) {
		this.imagem = imagem;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = super.hashCode();
	    result = prime * result + ( ( categoria == null ) ? 0 : categoria.hashCode() );
	    result = prime * result + ( ( dataCadastro == null ) ? 0 : dataCadastro.hashCode() );
	    result = prime * result + ( ( imagem == null ) ? 0 : imagem.hashCode() );
	    result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
	    result = prime * result + ( ( preco == null ) ? 0 : preco.hashCode() );
	    return result;
    }

	@Override
    public boolean equals( Object obj ) {
	    if ( this == obj )
		    return true;
	    if ( !super.equals( obj ) )
		    return false;
	    if ( getClass() != obj.getClass() )
		    return false;
	    ProdutoDTO other = (ProdutoDTO) obj;
	    if ( categoria == null ) {
		    if ( other.categoria != null )
			    return false;
	    } else if ( !categoria.equals( other.categoria ) )
		    return false;
	    if ( dataCadastro == null ) {
		    if ( other.dataCadastro != null )
			    return false;
	    } else if ( !dataCadastro.equals( other.dataCadastro ) )
		    return false;
	    if ( imagem == null ) {
		    if ( other.imagem != null )
			    return false;
	    } else if ( !imagem.equals( other.imagem ) )
		    return false;
	    if ( nome == null ) {
		    if ( other.nome != null )
			    return false;
	    } else if ( !nome.equals( other.nome ) )
		    return false;
	    if ( preco == null ) {
		    if ( other.preco != null )
			    return false;
	    } else if ( !preco.equals( other.preco ) )
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return "ProdutoDTO [getNome()=" + getNome() + ", getPreco()=" + getPreco() + ", getDataCadastro()=" + getDataCadastro() + ", getCategoria()=" + getCategoria() + ", getImagem()=" + getImagem() + ", hashCode()=" + hashCode() + "]";
    }

	

}