package com.truper.error;

public class ListaCompraNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ListaCompraNotFoundException(String msn) {
		super(msn);
	}
}
