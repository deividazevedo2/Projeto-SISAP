package br.edu.ifpb.monteiro.ads.sisap.interfaces;

import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public interface DaoIF<T> {
	
	public void salvar(T entity) throws SisapException;

	public T atualizar(T entity) throws SisapException;

	public void remover(T entity) throws SisapException;
	
	public T buscaPorId(Long id) throws SisapException;

}
