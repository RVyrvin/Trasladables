package org.iesalandalus.programacion.trasladable.modelo.dominio;

import java.io.Serializable;

public class Linea extends Punto implements Serializable,Trasladable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Punto p1;
	private Punto p2;

	public Linea(Punto p1, Punto p2) {
		setP1(new Punto(p1.getX(), p1.getY()));
		setP2(new Punto(p2.getX(), p2.getY()));
	}

	public Linea(Linea linea) {
		super();
		if (linea == null)
			throw new NullPointerException("No puedo copiar una línea nula.");
		setP1(linea.getP1());
		setP2(linea.getP2());
	}

	public Punto getP1() {
		return p1;
	}

	private void setP1(Punto p1) {
		this.p1 = p1;
	}

	public Punto getP2() {
		return p2;
	}

	private void setP2(Punto p2) {
		this.p2 = p2;
	}

	@Override
	public void trasladar(double x, double y) {
		p1.trasladar(x, y);
		p2.trasladar(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Linea [p1=" + p1 + ", p2=" + p2 + "]";
	}
	
	

}
