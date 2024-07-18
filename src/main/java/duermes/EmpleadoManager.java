package duermes;

import duermes.collection.Hashtable;
import duermes.collection.Queue;

public class EmpleadoManager {
    // se tiene aun que usar recursividad.
    // Calculo del Importe total a recibir solo de los trabajadores activos y con vacaciones.
    public static double salaryOfActiveEmployees(Empleado[] employees) {
        double totalSalary = 0;
        for (Empleado employee : employees) {
            if ((employee.getStatus() == Status.ACTIVO) || (employee.getStatus() == Status.VACACIONES)) {
                totalSalary += employee.getMonthlyRate();
            }
        }
        return totalSalary;
    }

    // report of all workers by status (usar un metodo de busqueda)
    public static Empleado[] reportByStatus(Empleado[] employees, Status status) {
        Empleado[] report = new Empleado[employees.length];
        for (Empleado employee : employees) {
            if (employee.getStatus() == status) {
                report[0] = employee;
            }
        }
        return report;
    }


    // reporte de trabajadores en total ordenado por nombre, usar metodo de ordenamiento
    public static Empleado[] employeesReport(Empleado[] employees) {
        Empleado[] report = new Empleado[employees.length];
        return report;
    }

    // punto 7 metodo
    public static Queue<Empleado> employeeQueue(Empleado[] employees) {
        Queue<Empleado> queue = new Queue<>(employees.length);
        for (Empleado employee : employees) {
            queue.offer(employee);
        }
        Empleado first = queue.poll();
        first.getName();
        first.getMonthlyRate();
        return queue;
    }


}
