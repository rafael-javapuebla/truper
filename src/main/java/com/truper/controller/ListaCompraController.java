package com.truper.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.entity.ListaCompra;
import com.truper.error.ListaCompraNotFoundException;
import com.truper.service.ListasCompraService;

@RestController
@RequestMapping("/api")
public class ListaCompraController {
	
	@Autowired
	private ListasCompraService listasCompraService;
	
	@PostMapping("/saveListaCompra")
	public ListaCompra saveListaCompra(@RequestBody ListaCompra listaCompra) {
		return listasCompraService.save(listaCompra);
	}
	
	@GetMapping("/listaComprasPorCliente/{clienteId}")
	public List<ListaCompra> listaComprasPorCliente(@PathVariable("clienteId") Integer clienteId){
		return listasCompraService.fetchListaCompraByClienteId(clienteId);
	}
	
	@PutMapping("/actualizaListaPrecios/{clienteId}")
	public ListaCompra actualizaListaPrecios(@PathVariable("clienteId") Integer clienteId, 
			@RequestBody ListaCompra listaCompra) {
		ListaCompra listaCompraNueva = listasCompraService.updateLista(clienteId, listaCompra);
		return listaCompraNueva;
	}
	
	@DeleteMapping("/eliminarListaCompra/{listaCompraId}")
	public String eliminarListaCompra(@PathVariable("listaCompraId") Integer listaCompraId) throws ListaCompraNotFoundException {
		listasCompraService.eliminarListaCompraById(listaCompraId);
		return "Lista eliminada";
	}
}
