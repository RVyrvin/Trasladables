package org.iesalandalus.programacion.trasladable;

import java.util.List;
import java.util.Random;

import org.iesalandalus.programacion.trasladable.modelo.dao.Trasladables;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Circunferencia;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Linea;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Punto;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Trasladable;

public class MainApp {

	private static final double LIMITE = 100;
	private static final Random GENERADOR = new Random();
	private static Trasladables modelo;

	private static void mostrarTrasladables() {
		modelo.representar();
	}

	private static void generarInsertarTrasladables() {

		try {
			modelo.insertar(new Punto(generarPunto()));
			modelo.insertar(new Circunferencia(generarPunto(), GENERADOR.nextDouble() * LIMITE));
			modelo.insertar(new Linea(generarPunto(), generarPunto()));
		} catch (Exception e) {
			System.err.println("ERROR" + e);
		}

	}

	private static Punto generarPunto() {
		Punto punto = new Punto(GENERADOR.nextDouble() * LIMITE, GENERADOR.nextDouble() * LIMITE);
		return punto;
	}

	private static void trasladar() {
		List<Trasladable> coleccion = modelo.getTrasladebles();
		for (Trasladable elemento : coleccion) {
			elemento.trasladar(GENERADOR.nextDouble() * LIMITE, GENERADOR.nextDouble() * LIMITE);
		}

	}

	public static void main(String[] args) {
		System.out.println("Tarea presencial PROG05-08 2018/2019");

		modelo = new Trasladables();

		modelo.leer();
		mostrarTrasladables();
		generarInsertarTrasladables();
		mostrarTrasladables();
		trasladar();
		mostrarTrasladables();
		modelo.escribir();

	}

}
