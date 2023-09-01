package com.truper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the lista_compra_detalle database table.
 * 
 */
@Embeddable
public class ListaCompraDetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int idlistacompra;

	@Column(nullable=false)
	private int codigoproducto;

	public ListaCompraDetallePK() {
	}
	public int getIdlistacompra() {
		return this.idlistacompra;
	}
	public void setIdlistacompra(int idlistacompra) {
		this.idlistacompra = idlistacompra;
	}
	public int getCodigoproducto() {
		return this.codigoproducto;
	}
	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ListaCompraDetallePK)) {
			return false;
		}
		ListaCompraDetallePK castOther = (ListaCompraDetallePK)other;
		return 
			(this.idlistacompra == castOther.idlistacompra)
			&& (this.codigoproducto == castOther.codigoproducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idlistacompra;
		hash = hash * prime + this.codigoproducto;
		
		return hash;
	}
}