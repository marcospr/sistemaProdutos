package br.com.sistemaprodutos.produto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.sistemaprodutos.categoria.model.CategoriaPO;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;

/**
 * 
 * Classe que representa um objeto do tipo produto
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:44:33
 * @version 1.0
 */
@Entity
@Table( name = "produtos", uniqueConstraints = @UniqueConstraint( columnNames = { "nome", "imagem" } ) )
public final class ProdutoPO extends AbstractPO{

	@Column( name = "nome", length = 60, nullable = false )
	private String nome;

	@Column( name = "preco" )
	private BigDecimal preco;

	@Temporal( TemporalType.DATE )
	@Column( name = "data_cadastro", nullable = false )
	private Date dataCadastro;

	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "id_categoria" )
	private CategoriaPO categoria;

	@Column( name = "imagem", nullable = false, length = 50 )
	private String imagem;

	public ProdutoPO(){

	}

	public ProdutoPO( Long id,String nome, BigDecimal preco, Date dataCadastro, CategoriaPO categoria, String imagem ){
		setId( id );
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro( Date dataCadastro ) {
		this.dataCadastro = dataCadastro;
	}

	public CategoriaPO getCategoria() {
		if ( categoria == null ) {
			categoria = new CategoriaPO();
		}
		return categoria;
	}

	public void setCategoria( CategoriaPO categoria ) {
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
	    ProdutoPO other = (ProdutoPO) obj;
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
	    return "ProdutoPO [getNome()=" + getNome() + ", getPreco()=" + getPreco() + ", getDataCadastro()=" + getDataCadastro() + ", getCategoria()=" + getCategoria() + ", getImagem()=" + getImagem() + ", hashCode()=" + hashCode() + "]";
    }

	
}