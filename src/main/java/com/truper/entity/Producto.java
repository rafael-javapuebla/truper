package com.truper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idproducto;

	private byte activo;

	@Column(length=15)
	private String clave;

	@Column(length=150)
	private String descripcion;

	//bi-directional many-to-one association to ListaCompraDetalle
	@OneToMany(mappedBy="producto")
	@JsonIgnore
	private List<ListaCompraDetalle> listaCompraDetalles;

	public Producto() {
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ListaCompraDetalle> getListaCompraDetalles() {
		return this.listaCompraDetalles;
	}

	public void setListaCompraDetalles(List<ListaCompraDetalle> listaCompraDetalles) {
		this.listaCompraDetalles = listaCompraDetalles;
	}

	public ListaCompraDetalle addListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		getListaCompraDetalles().add(listaCompraDetalle);
		listaCompraDetalle.setProducto(this);

		return listaCompraDetalle;
	}

	public ListaCompraDetalle removeListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		getListaCompraDetalles().remove(listaCompraDetalle);
		listaCompraDetalle.setProducto(null);

		return listaCompraDetalle;
	}

}