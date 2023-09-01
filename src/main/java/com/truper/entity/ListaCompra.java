package com.truper.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * The persistent class for the lista_compra database table.
 * 
 */
@Entity
@Table(name="lista_compra")
@NamedQuery(name="ListaCompra.findAll", query="SELECT l FROM ListaCompra l")
public class ListaCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idlistacompra;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ultima_actualizacion")
	private Date fechaUltimaActualizacion;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="clientes_idcliente", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to ListaCompraDetalle
	@OneToMany(mappedBy="listaCompra", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<ListaCompraDetalle> listaCompraDetalles;

	public ListaCompra() {
	}

	public int getIdlistacompra() {
		return this.idlistacompra;
	}

	public void setIdlistacompra(int idlistacompra) {
		this.idlistacompra = idlistacompra;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ListaCompraDetalle> getListaCompraDetalles() {
		return this.listaCompraDetalles;
	}

	public void setListaCompraDetalles(List<ListaCompraDetalle> listaCompraDetalles) {
		this.listaCompraDetalles = listaCompraDetalles;
	}

	public ListaCompraDetalle addListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		getListaCompraDetalles().add(listaCompraDetalle);
		listaCompraDetalle.setListaCompra(this);

		return listaCompraDetalle;
	}

	public ListaCompraDetalle removeListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		getListaCompraDetalles().remove(listaCompraDetalle);
		listaCompraDetalle.setListaCompra(null);

		return listaCompraDetalle;
	}

}