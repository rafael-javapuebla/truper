package com.truper.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the lista_compra_detalle database table.
 * 
 */
@Entity
@Table(name="lista_compra_detalle")
@NamedQuery(name="ListaCompraDetalle.findAll", query="SELECT l FROM ListaCompraDetalle l")
public class ListaCompraDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListaCompraDetallePK id;

	@Column(nullable=false)
	private int cantidad;

	//bi-directional many-to-one association to ListaCompra
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="lista_compra_idlistacompra", nullable=true)
	private ListaCompra listaCompra;

	//bi-directional many-to-one association to Producto
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productos_idproducto", nullable=false)
	private Producto producto;

	public ListaCompraDetalle() {
	}

	public ListaCompraDetallePK getId() {
		return this.id;
	}

	public void setId(ListaCompraDetallePK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ListaCompra getListaCompra() {
		return this.listaCompra;
	}

	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}