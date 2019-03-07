package org.iesalandalus.programacion.trasladable.modelo.dominio;

public interface Trasladable {
	
	public void trasladar(double x, double y);
	
	public int hashCode();
	
	public boolean equals(Object obj);
	
	public String toString();

}
