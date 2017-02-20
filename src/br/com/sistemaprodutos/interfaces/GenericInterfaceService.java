package br.com.sistemaprodutos.interfaces;

import br.com.sistemaprodutos.exceptions.ApplicationException;
import br.com.sistemaprodutos.model.abstractpo.AbstractPO;

public interface GenericInterfaceService {
	AbstractPO inserir(AbstractPO po) throws ApplicationException;

	void alterar(AbstractPO po) throws ApplicationException;

	void excluir(AbstractPO po) throws ApplicationException;

	Object filtrar(AbstractPO po) throws ApplicationException;
}
