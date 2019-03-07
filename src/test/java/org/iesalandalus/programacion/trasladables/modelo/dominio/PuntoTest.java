package org.iesalandalus.programacion.trasladables.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.iesalandalus.programacion.trasladable.modelo.dominio.Punto;
import org.junit.Test;

public class PuntoTest {

	@Test
	public void constructorTest() {
		Punto punto = new Punto(0, 0);
		assertEquals(0, punto.getX(), 0);
		assertEquals (0, punto.getY(), 0);
		assertEquals("Punto [x=0.0, y=0.0]", punto.toString());
	}
	
	@Test
	public void constructorCopiaValidoTest() {
		Punto p1 = new Punto(10, 10);
		Punto p2 = new Punto(p1);
		assertEquals(10, p2.getX(), 0);
		assertEquals (10, p2.getY(), 0);
		assertEquals("Punto [x=10.0, y=10.0]", p2.toString());
		assertFalse(p1 == p2);
	}
	
	@Test
	public void constructoCopiaNoValidoTest() {
		Punto p1 = null;
		Punto p2 = null;
		try {
			p2 = new Punto(p1);
		} catch (NullPointerException e) {
			assertNull(p2);
			assertEquals("No puedo copiar un punto nulo.", e.getMessage());
		}
	}
	
	@Test
	public void trasladarTest() {
		Punto punto = new Punto(0,0);
		punto.trasladar(10, 10);
		assertEquals(10, punto.getX(), 0);
		assertEquals(10, punto.getY(), 0);
		punto.trasladar(-10, -10);
		assertEquals(0, punto.getX(), 0);
		assertEquals(0, punto.getY(), 0);
	}
	
	@Test
	public void hashCodeEqualsTest() {
		Punto p1 = new Punto(0, 0);
		Punto p2 = new Punto(0, 10);
		Punto p3 = new Punto(10, 0);
		Punto p4 = new Punto(10, 10);
		Punto p5 = new Punto(0, 0);
		assertEquals(p1.hashCode(), p5.hashCode());
		assertNotEquals(p1.hashCode(), p2.hashCode());
		assertNotEquals(p1.hashCode(), p3.hashCode());
		assertNotEquals(p1.hashCode(), p4.hashCode());
		assertEquals(p1, p5);
		assertNotEquals(p1, p2);
		assertNotEquals(p1, p3);
		assertNotEquals(p1, p4);
	}

}
