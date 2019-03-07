package org.iesalandalus.programacion.trasladable.modelo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.trasladable.modelo.dominio.Circunferencia;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Linea;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Punto;
import org.iesalandalus.programacion.trasladable.modelo.dominio.Trasladable;

public class Trasladables {

	private static final String NOMBRE_FICHERO_TRASLADABLE = "ficheros/trasladables.dat";
	List<Trasladable> coleccionTrasladebles;

	public Trasladables() {
		coleccionTrasladebles = new ArrayList<>();
	}

	public Trasladables(Trasladables trasladables) {
		if (trasladables == null)
			throw new NullPointerException("No se copian trasladables nulos.");
		coleccionTrasladebles = copiaProfundaTrasladables(trasladables.coleccionTrasladebles);
	}

	public List<Trasladable> copiaProfundaTrasladables(List<Trasladable> trasladables) {
		if (trasladables == null) {
			throw new IllegalArgumentException("No se puede copiar una lista de nulos.");
		}
		List<Trasladable> otrasTrasladable = new ArrayList<>();
		for (Trasladable trasladable : otrasTrasladable) {
			if (trasladable instanceof Punto) {
				otrasTrasladable.add(new Punto((Punto) trasladable));
			} else if (trasladable instanceof Circunferencia) {
				otrasTrasladable.add(new Circunferencia((Circunferencia) trasladable));
			} else if (trasladable instanceof Linea) {
				otrasTrasladable.add(new Linea((Linea) trasladable));
			}
		}
		return otrasTrasladable;
	}

	public List<Trasladable> getTrasladebles() {
		return coleccionTrasladebles;
	}

	private void setTrasladebles(List<Trasladable> coleccionTrasladebles) {
		this.coleccionTrasladebles = coleccionTrasladebles;
	}

	public void insertar(Trasladable trasladable) throws OperationNotSupportedException {

		if (trasladable == null)
			throw new NullPointerException("No se puede insertar trasladable nulo");

		if (coleccionTrasladebles.contains(trasladable))
			throw new OperationNotSupportedException("El mismo trasladable ya existe");

		if (trasladable instanceof Punto) {
			coleccionTrasladebles.add(new Punto((Punto) trasladable));
		} else if (trasladable instanceof Circunferencia) {
			coleccionTrasladebles.add(new Circunferencia((Circunferencia) trasladable));
		} else if (trasladable instanceof Linea) {
			coleccionTrasladebles.add(new Linea((Linea) trasladable));
		}
	}

	public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		for (Trasladable trasladable : coleccionTrasladebles) {
			representacion.add(trasladable.toString());
		}
		return representacion;
	}

	public void leer() {
		File fichero = new File(NOMBRE_FICHERO_TRASLADABLE);
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
			Trasladable trasladable = null;
			do {
				trasladable = (Trasladable) entrada.readObject();
				insertar(trasladable);
			} while (trasladable != null);
		} catch (ClassNotFoundException e) {
			System.out.println("No puedo encontrar la clase que tengo que leer.");
		} catch (FileNotFoundException e) {
			System.out.println("No puedo abrir el fihero de trasladable.dat.");
		} catch (EOFException e) {
			System.out.println("Fichero alarmas leído satisfactoriamente.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void escribir() {
		File ficheroTrasladable = new File(NOMBRE_FICHERO_TRASLADABLE);
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ficheroTrasladable))) {
			for (Trasladable trasladable : coleccionTrasladebles)
				salida.writeObject(trasladable);
			System.out.println("Fichero trasladables.dat escrito satisfactoriamente.");
		} catch (FileNotFoundException e) {
			System.out.println("No puedo crear el fichero de trasladable.dat");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

}
