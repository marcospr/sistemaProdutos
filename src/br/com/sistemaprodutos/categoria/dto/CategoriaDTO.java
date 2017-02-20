package br.com.sistemaprodutos.categoria.dto;

import br.com.sistemaprodutos.abstractdto.AbstractDTO;

/**
 * 
 * Classe que representa objetos do tipo categoria
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:40:06
 * @version 1.0
 */

public final class CategoriaDTO extends AbstractDTO {

    private static final long serialVersionUID = 7318349449618896455L;
	private String nome;
	
	public CategoriaDTO(){
		
	}
	public CategoriaDTO(String id){
		super( id );
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [getNome()=" + getNome() + ", hashCode()="
				+ hashCode() + "]";
	}

}
