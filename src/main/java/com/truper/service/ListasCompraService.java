package com.truper.service;

import java.util.List;

import com.truper.entity.ListaCompra;
import com.truper.error.ListaCompraNotFoundException;

public interface ListasCompraService {
	ListaCompra save(ListaCompra listaCompra);

	List<ListaCompra> fetchListaCompraByClienteId(Integer clienteId);

	ListaCompra updateLista(Integer clienteId, ListaCompra listaCompra);

	void eliminarListaCompraById(Integer listaCompraId) throws ListaCompraNotFoundException;
}
