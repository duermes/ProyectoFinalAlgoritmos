package duermes.collection;

import duermes.Empleado;

public class ArrayList<T> {
    private Object[] elementos;
    private int tamaño;

    public ArrayList() {
        elementos = new Object[10]; // Tamaño inicial
        tamaño = 0;
    }

    public ArrayList(int size) {
        elementos = new Object[10]; // Tamaño inicial
        tamaño = size;
    }

    public void agregar(T elemento) {
        if (tamaño == elementos.length) {
            grow();
        }
        elementos[tamaño++] = elemento;
    }

    public T buscar(int idEmployee) {
        for (int i = 0; i < tamaño; i++) {
            if (((Empleado) elementos[i]).getId() == idEmployee) {
                return (T) elementos[i];
            }
        }
        return null;
    }

    public T buscarPorIndice(int indice) {
        if (indice >= tamaño || indice < 0) {
            return null;

        }
        return (T) elementos[indice];
    }

    public void actualizar(int idEmployee, T elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (((Empleado) elementos[i]).getId() == idEmployee) {
                elementos[i] = elemento;
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró el empleado con id: " + idEmployee);
    }

    public void set(int indice, T elemento) {
        if (indice >= tamaño || indice < 0) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        elementos[indice] = elemento;
    }


    public void eliminar(int idEmployee) {
        int indice = -1;
        for (int i = 0; i < tamaño; i++) {
            if (((Empleado) elementos[i]).getId() == idEmployee) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new IndexOutOfBoundsException("No se encontró el empleado con id: " + idEmployee);
        }
        for (int i = indice; i < tamaño - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--tamaño] = null;
        if (tamaño < elementos.length / 2) {
            shrink();
        }
    }

    public int tamaño() {
        return tamaño;
    }

    private void grow() {
        Object[] nuevoArray = new Object[elementos.length * 2];
        System.arraycopy(elementos, 0, nuevoArray, 0, elementos.length);
        elementos = nuevoArray;
    }

    private void shrink() {
        Object[] nuevoArray = new Object[elementos.length / 2];
        System.arraycopy(elementos, 0, nuevoArray, 0, tamaño);
        elementos = nuevoArray;
    }
}

