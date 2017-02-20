package br.com.sistemaprodutos.abstractdto;

import java.io.Serializable;


/**
 * 
 * Classe que representa a mãe de todos os DTO
 * do sistema.
 *
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/04/2014 06:35:06
 * @version 1.0
 */

public abstract class AbstractDTO implements Serializable{
	
	
    private static final long serialVersionUID = -8142753805244739696L;
	private String id;

	public AbstractDTO(){}
	
	public AbstractDTO(String id){
		setId( id );
	}

	/**
	 * Método responsável por retornar o valor do atributo id.
	 * 
	 * @return Long id - id a ser retornado(a).
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo id.
	 * 
	 * @param Long id - id a ser atribuido(a).
	 */
	public final void setId( String id ) {
		this.id = id;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		return result;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof AbstractDTO ) ) {
			return false;
		}
		AbstractDTO other = (AbstractDTO) obj;
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [getId()=" + getId()
				+ ", hashCode()=" + hashCode()
				+ "]";
	}


}
