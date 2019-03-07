package org.iesalandalus.programacion.trasladables.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.iesalandalus.programacion.trasladable.modelo.dominio.Circunferencia;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Punto;
import org.junit.Test;

public class CircunferenciaTest {
	
	private static final Punto P1 = new Punto(0, 0);
	private static final Punto P2 = new Punto(0, 10);
	private static final Punto P3 = new Punto(10, 10);
	private static final double R1 = 10d;
	private static final double R2 = 5d;

	@Test
	public void constructorTest() {
		Circunferencia circunferencia = new Circunferencia(P1, R1);
		assertEquals(P1, circunferencia.getCentro());
		assertEquals(R1, circunferencia.getRadio(), 0);
		assertFalse(P1 == circunferencia.getCentro());
		assertEquals("Circunferencia [centro=Punto [x=0.0, y=0.0], radio=10.0]", circunferencia.toString());
	}
	
	@Test
	public void constructorCopiaValidoTest() {
		Circunferencia c1 = new Circunferencia(P1, R1);
		Circunferencia c2 = new Circunferencia(c1);
		assertEquals(P1, c2.getCentro());
		assertEquals(R1, c2.getRadio(), 0);
		assertFalse(P1 == c2.getCentro());
		assertEquals("Circunferencia [centro=Punto [x=0.0, y=0.0], radio=10.0]", c2.toString());
		assertFalse(c1 == c2);
	}
	
	@Test
	public void constructoCopiaNoValidoTest() {
		Circunferencia c1 = null;
		Circunferencia c2 = null;
		try {
			c2 = new Circunferencia(c1);
		} catch (NullPointerException e) {
			assertNull(c2);
			assertEquals("No puedo copiar una circunferencia nula.", e.getMessage());
		}
	}
	
	@Test
	public void trasladarTest() {
		Circunferencia circunferencia = new Circunferencia(P1, R1);
		circunferencia.trasladar(10, 10);
		assertEquals(P3, circunferencia.getCentro());
		assertEquals(R1, circunferencia.getRadio(), 0);
		circunferencia.trasladar(-10, -10);
		assertEquals(P1, circunferencia.getCentro());
		assertEquals(R1, circunferencia.getRadio(), 0);
	}
	
	@Test
	public void hashCodeEqualsTest() {
		Circunferencia c1 = new Circunferencia(P1, R1);
		Circunferencia c2 = new Circunferencia(P1, R2);
		Circunferencia c3 = new Circunferencia(P2, R1);
		Circunferencia c4 = new Circunferencia(P2, R1);
		Circunferencia c5 = new Circunferencia(P1, R1);
		assertEquals(c1.hashCode(), c5.hashCode());
		assertNotEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c1.hashCode(), c3.hashCode());
		assertNotEquals(c1.hashCode(), c4.hashCode());
		assertEquals(c1, c5);
		assertNotEquals(c1, c2);
		assertNotEquals(c1, c3);
		assertNotEquals(c1, c4);
	}

}
