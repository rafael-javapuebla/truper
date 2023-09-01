package com.truper.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idcliente;

	private byte activo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to ListaCompra
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private List<ListaCompra> listaCompras;

	public Cliente() {
	}

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ListaCompra> getListaCompras() {
		return this.listaCompras;
	}

	public void setListaCompras(List<ListaCompra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public ListaCompra addListaCompra(ListaCompra listaCompra) {
		getListaCompras().add(listaCompra);
		listaCompra.setCliente(this);

		return listaCompra;
	}

	public ListaCompra removeListaCompra(ListaCompra listaCompra) {
		getListaCompras().remove(listaCompra);
		listaCompra.setCliente(null);

		return listaCompra;
	}

}