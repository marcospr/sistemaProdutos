package br.com.sistemaprodutos.categoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.sistemaprodutos.model.abstractpo.AbstractPO;
/**
 * 
 * Classe que representa objetos do tipo categoria
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:40:06
 * @version 1.0
 */
@Entity
@Table(name="categorias")
public final class CategoriaPO extends AbstractPO {
	
	@Column(name="nome",length=60,nullable=false,unique=false)
	private String nome;

	public CategoriaPO() {
	
	}
	public CategoriaPO(String nome,Long id){
		setId(id);
		setNome(nome);
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
		CategoriaPO other = (CategoriaPO) obj;
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
