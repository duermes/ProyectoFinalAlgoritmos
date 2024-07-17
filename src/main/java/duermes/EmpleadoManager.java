package duermes;

import duermes.collection.Hashtable;
import duermes.collection.Queue;

public class EmpleadoManager {



    public static double salaryOfActiveEmployees(Empleado[] employees) {
        double totalSalary = 0;
        for (Empleado employee : employees) {
            if (employee.getStatus() == Status.ACTIVO) {
                totalSalary += employee.getFinalSalary();
            }
        }
        return totalSalary;
    }

    public Empleado[] employeesReport(Empleado[] employees) {
        Empleado[] report = new Empleado[employees.length];


        return report;
    }

    // punto 7 metodo
    public Queue<Double> employeersSalary(Empleado[] employees) {
        Queue<Double> salaries = new Queue<>(employees.length);
        for (Empleado employee : employees) {
            salaries.offer(employee.getFinalSalary());
        }
        return salaries;
    }


}
