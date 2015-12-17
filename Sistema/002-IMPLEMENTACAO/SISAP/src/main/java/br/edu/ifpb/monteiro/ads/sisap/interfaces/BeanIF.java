package br.edu.ifpb.monteiro.ads.sisap.interfaces;

import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public interface BeanIF<T> {
	
	public String salvar() throws SisapException;

    public String atualizar() throws SisapException;

    public void remover(T identificavel) throws SisapException;

    public T consultarPorId(Long id) throws SisapException;



}
