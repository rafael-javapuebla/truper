package com.truper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.entity.ListaCompra;
import com.truper.error.ListaCompraNotFoundException;
import com.truper.repository.ListaCompraRepository;

@Service
public class ListaCompraServiceImpl implements ListasCompraService{

	@Autowired
	private ListaCompraRepository listaCompraRepository;
	
	@Override
	public ListaCompra save(ListaCompra listaCompra) {
		return listaCompraRepository.save(listaCompra);
	}

	@Override
	public List<ListaCompra> fetchListaCompraByClienteId(Integer clienteId) {
		return listaCompraRepository.findByCliente_Idcliente(clienteId);
	}


	@Override
	public ListaCompra updateLista(Integer clienteId, ListaCompra listaCompra) {
		ListaCompra original = listaCompraRepository.findByIdlistacompraAndCliente_Idcliente(listaCompra.getIdlistacompra(), clienteId);

		System.out.println("clienteId: " + clienteId);
		System.out.println("listaCompra: " + listaCompra.getListaCompraDetalles());
		System.out.println("Original: " + original);
		
		original.setNombre(listaCompra.getNombre());
		original.getListaCompraDetalles().addAll(listaCompra.getListaCompraDetalles());
		
		return listaCompraRepository.save(original);
	}

	@Override
	public void eliminarListaCompraById(Integer listaCompraId) throws ListaCompraNotFoundException {
		if(listaCompraRepository.existsById(listaCompraId))
			listaCompraRepository.deleteById(listaCompraId);
		else
			throw new ListaCompraNotFoundException("Lista de compras no encontrada");
	}

}
