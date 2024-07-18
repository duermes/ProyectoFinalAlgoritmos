package duermes;

import duermes.collection.ArrayList;

import java.util.LinkedList;

import java.util.LinkedList;


import java.util.List;

public class EmpleadoUtils {

    // Método para ordenar empleados por nombre usando Merge Sort
    public static void sortByName(ArrayList<Empleado> employees, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortByName(employees, left, middle);
            sortByName(employees, middle + 1, right);
            mergeByName(employees, left, middle, right);
        }
    }

    // Método para fusionar empleados por nombre
    private static void mergeByName(ArrayList<Empleado> employees, int left, int middle, int right) {
        ArrayList<Empleado> leftList = new ArrayList<>();
        ArrayList<Empleado> rightList = new ArrayList<>();

        for (int i = left; i <= middle; i++) {
            leftList.agregar(employees.buscarPorIndice(i));
        }
        for (int j = middle + 1; j <= right; j++) {
            rightList.agregar(employees.buscarPorIndice(j));
        }

        int i = 0, j = 0, k = left;

        while (i < leftList.tamaño() && j < rightList.tamaño()) {
            Empleado leftEmp = leftList.buscarPorIndice(i);
            Empleado rightEmp = rightList.buscarPorIndice(j);
            if (leftEmp != null && rightEmp != null && leftEmp.getName().compareTo(rightEmp.getName()) <= 0) {
                employees.set(k++, leftEmp);
                i++;
            } else if (rightEmp != null) {
                employees.set(k++, rightEmp);
                j++;
            }
        }

        while (i < leftList.tamaño()) {
            employees.set(k++, leftList.buscarPorIndice(i++));
        }
        while (j < rightList.tamaño()) {
            employees.set(k++, rightList.buscarPorIndice(j++));
        }
    }


    // Implementa sortByStatus y mergeByStatus de manera similar...
    public static void sortByStatus(ArrayList<Empleado> employees, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortByStatus(employees, left, middle);
            sortByStatus(employees, middle + 1, right);
            mergeByStatus(employees, left, middle, right);
        }
    }
    private static void mergeByStatus(ArrayList<Empleado> employees, int left, int middle, int right) {
        ArrayList<Empleado> leftList = new ArrayList<>();
        ArrayList<Empleado> rightList = new ArrayList<>();

        // Llenar las listas temporales
        for (int i = left; i <= middle; i++) {
            leftList.agregar(employees.buscarPorIndice(i));
        }
        for (int j = middle + 1; j <= right; j++) {
            rightList.agregar(employees.buscarPorIndice(j));
        }

        int i = 0, j = 0, k = left;

        // Fusión ordenada por estado
        while (i < leftList.tamaño() && j < rightList.tamaño()) {
            Empleado leftEmp = leftList.buscarPorIndice(i);
            Empleado rightEmp = rightList.buscarPorIndice(j);
            if (leftEmp != null && rightEmp != null &&
                    (rightEmp.getStatus() == null || leftEmp.getStatus().compareTo(rightEmp.getStatus()) <= 0)) {
                employees.set(k++, leftEmp);
                i++;
            } else if (rightEmp != null) {
                employees.set(k++, rightEmp);
                j++;
            }
        }

        // Copiar elementos restantes de leftList
        while (i < leftList.tamaño()) {
            employees.set(k++, leftList.buscarPorIndice(i++));
        }

        // Copiar elementos restantes de rightList
        while (j < rightList.tamaño()) {
            employees.set(k++, rightList.buscarPorIndice(j++));
        }
    }




}



