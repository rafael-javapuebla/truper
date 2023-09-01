package com.truper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truper.entity.ListaCompra;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaCompra, Integer>{
	List<ListaCompra> findByCliente_Idcliente(Integer idCliente);
	ListaCompra findByIdlistacompraAndCliente_Idcliente(Integer idlistacompra, Integer clienteId);
}
