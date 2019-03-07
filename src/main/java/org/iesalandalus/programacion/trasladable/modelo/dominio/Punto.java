package org.iesalandalus.programacion.trasladable.modelo.dominio;

import java.io.Serializable;

public class Punto implements Serializable,Trasladable {

	private static final long serialVersionUID = 1L;
	protected double x;
	protected double y;

	public Punto() {};
	
	public Punto(double x, double y) {
		setX(x);
		setY(y);
	}

	public Punto(Punto punto) {
		if (punto == null)
			throw new NullPointerException("No puedo copiar un punto nulo.");
		setX(punto.getX());
		setY(punto.getY());
	}

	public void trasladar(double x, double y) {
		setX(this.x + x);
		setY(this.y + y);
	}

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

}
