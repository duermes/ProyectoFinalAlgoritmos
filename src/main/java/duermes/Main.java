package duermes;


import duermes.collection.ArrayList;
import duermes.collection.Hashtable;
import duermes.gui.MainFrame;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        EmpleadoManager manager = new EmpleadoManager();
        try {
            manager.loadEmployees();
        } catch (Exception e) {
            System.out.println("No se pudo cargar los empleados");
        }

        MainFrame main = new MainFrame(manager);
        //manager.updateEmployee(4,"Anita","Rodríguez", LocalDate.now(),Status.ACTIVO,2000.0,15);
        /*
        ArrayList<Empleado> asd = manager.getEmployees();
        for (int i = 0; i < asd.tamaño(); i++) {
            Empleado empleado = asd.buscarPorIndice(i);
            if (empleado != null) {
                System.out.println(empleado.getId() + "," +
                        empleado.getName() + "," +
                        empleado.getLastName() + "," +
                        empleado.getBirthDate() + "," +
                        empleado.getStatus() + "," +
                        empleado.getMonthlyRate() + "," +
                        empleado.getDaysWorkedInMonth());
            }
        }
       manager.removeEmployee(0);
        ArrayList<Empleado> asd2 = manager.getEmployees();
        for (int i = 0; i < asd2.tamaño(); i++) {
            Empleado empleado = asd2.buscarPorIndice(i);
            if (empleado != null) {
                System.out.println(empleado.getId() + "," +
                        empleado.getName() + "," +
                        empleado.getLastName() + "," +
                        empleado.getBirthDate() + "," +
                        empleado.getStatus() + "," +
                        empleado.getMonthlyRate() + "," +
                        empleado.getDaysWorkedInMonth());
            }
        }
         */


        /*


        manager.addEmployee(new Empleado("tengo","Pérez", (LocalDate.of(1990, Month.JANUARY, 1)),Status.ACTIVO,1500.0,20));
        manager.addEmployee(new Empleado("mucho","Gómez", (LocalDate.of(1995, Month.FEBRUARY, 15)),Status.VACACIONES,1800.0,25));
        manager.addEmployee(new Empleado("sueno","Martínez", (LocalDate.of(1985, Month.MARCH, 30)),Status.ACTIVO,2500.0,30));
        manager.addEmployee(new Empleado("quiero","Sánchez", (LocalDate.of(1980, Month.APRIL, 10)),Status.DESCANSO_MEDICO,3000.0,10));
        manager.addEmployee(new Empleado("dormir","García", (LocalDate.of(1975, Month.MAY, 20)),Status.ACTIVO,3500.0,5));
   */

        try {
            manager.saveEmployees();
        } catch (Exception e) {
            System.out.println("No se pudo guardar los empleados");
        }
    }
}