package org.iesalandalus.programacion.trasladable.modelo.dominio;

import java.io.Serializable;

public class Circunferencia extends Punto implements Serializable,Trasladable {

	private static final long serialVersionUID = 1L;
	private Punto centro;
	private double radio;

	public Circunferencia(Punto centro, double radio) {
		setCentro(new Punto(centro.getX(), centro.getY()));
		setRadio(radio);
	}

	public Circunferencia(Circunferencia circunferencia) {
		super();
		if (circunferencia == null)
			throw new NullPointerException("No puedo copiar una circunferencia nula.");

		setCentro(circunferencia.getCentro()); // ?????
		setRadio(circunferencia.getRadio());
	}

	public Punto getCentro() {
		return centro;
	}

	private void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getRadio() {
		return radio;
	}

	private void setRadio(double radius) {
		this.radio = radius;
	}

	@Override
	public void trasladar(double x, double y) {
		centro.trasladar(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Circunferencia other = (Circunferencia) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (Double.doubleToLongBits(radio) != Double.doubleToLongBits(other.radio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circunferencia [centro=" + centro + ", radio=" + radio + "]";
	}

}
