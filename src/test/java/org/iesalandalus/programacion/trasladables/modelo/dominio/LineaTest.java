package org.iesalandalus.programacion.trasladables.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.iesalandalus.programacion.trasladable.modelo.dominio.Linea;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Punto;
import org.junit.Test;

public class LineaTest {
	
	private static final Punto P1 = new Punto(0, 0);
	private static final Punto P2 = new Punto(0, 10);
	private static final Punto P3 = new Punto(10, 0);
	private static final Punto P4 = new Punto(10, 10);
	private static final Punto P5 = new Punto(10, 20);

	@Test
	public void constructorTest() {
		Linea linea = new Linea(P1, P2);
		assertEquals(P1, linea.getP1());
		assertEquals(P2, linea.getP2());
		assertFalse(P1 == linea.getP1());
		assertFalse(P2 == linea.getP2());
		assertEquals("Linea [p1=Punto [x=0.0, y=0.0], p2=Punto [x=0.0, y=10.0]]", linea.toString());
	}
	
	@Test
	public void constructorCopiaValidoTest() {
		Linea l1 = new Linea(P1, P2);
		Linea l2 = new Linea(l1);
		assertEquals(P1, l2.getP1());
		assertEquals(P2, l2.getP2());
		assertFalse(P1 == l2.getP1());
		assertFalse(P2 == l2.getP2());
		assertEquals("Linea [p1=Punto [x=0.0, y=0.0], p2=Punto [x=0.0, y=10.0]]", l2.toString());
		assertFalse(l1 == l2);
	}
	
	@Test
	public void constructoCopiaNoValidoTest() {
		Linea l1 = null;
		Linea l2 = null;
		try {
			l2 = new Linea(l1);
		} catch (NullPointerException e) {
			assertNull(l2);
			assertEquals("No puedo copiar una línea nula.", e.getMessage());
		}
	}
	
	@Test
	public void trasladarTest() {
		Linea linea = new Linea(P1, P2);
		linea.trasladar(10, 10);
		assertEquals(P4, linea.getP1());
		assertEquals(P5, linea.getP2());
		linea.trasladar(-10, -10);
		assertEquals(P1, linea.getP1());
		assertEquals(P2, linea.getP2());
	}
	
	@Test
	public void hashCodeEqualsTest() {
		Linea l1 = new Linea(P1, P2);
		Linea l2 = new Linea(P1, P4);
		Linea l3 = new Linea(P3, P4);
		Linea l4 = new Linea(P4, P5);
		Linea l5 = new Linea(P1, P2);
		assertEquals(l1.hashCode(), l5.hashCode());
		assertNotEquals(l1.hashCode(), l2.hashCode());
		assertNotEquals(l1.hashCode(), l3.hashCode());
		assertNotEquals(l1.hashCode(), l4.hashCode());
		assertEquals(l1, l5);
		assertNotEquals(l1, l2);
		assertNotEquals(l1, l3);
		assertNotEquals(l1, l4);
	}

}
