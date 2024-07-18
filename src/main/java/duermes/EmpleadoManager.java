package duermes;

import duermes.collection.ArrayList;
import duermes.collection.Queue;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmpleadoManager {
    private ArrayList<Empleado> employees;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Queue<Empleado> queue;

    public EmpleadoManager() {
        employees = new ArrayList<>();
        queue = new Queue<>(getEmployees().tamaño() + 1);
    }

    // Método para guardar empleados en un archivo de texto
    public void saveEmployees() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {
            for (int i = 0; i < employees.tamaño(); i++) {
                Empleado empleado = employees.buscarPorIndice(i);
                if (empleado != null) {
                    writer.write(empleado.getId() + "," +
                            empleado.getName() + "," +
                            empleado.getLastName() + "," +
                            empleado.getBirthDate().format(formatter) + "," +
                            empleado.getStatus() + "," +
                            empleado.getMonthlyRate() + "," +
                            empleado.getDaysWorkedInMonth());
                    writer.newLine();
                }
            }
        }
    }

    // Método para cargar empleados desde un archivo de texto
    public void loadEmployees() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String lastName = fields[2];
                LocalDate birthDate = LocalDate.parse(fields[3], formatter);
                Status status = Status.valueOf(fields[4]);
                double monthlyRate = Double.parseDouble(fields[5]);
                int daysWorkedInMonth = Integer.parseInt(fields[6]);

                Empleado empleado = new Empleado(name, lastName, birthDate, status, monthlyRate, daysWorkedInMonth);
                empleado.setId(id); // Set the ID manually
                employees.agregar(empleado);
                maxId = Math.max(maxId, id); // Track the maximum ID
            }
            Empleado.setIdCounter(maxId); // Update the static idCounter
        }
    }



    // Método para agregar un empleado
    public void addEmployee(Empleado employee) throws IOException {
        if (!employeeExist(employee.getId())) {
            employees.agregar(employee);
            System.out.println("Empleado agregado con éxito");
            saveEmployees();
        } else {
            throw new IllegalArgumentException("El empleado ya existe");
        }
    }

    // Método para eliminar un empleado por ID
    public void removeEmployee(int id) {
        Empleado employee = employees.buscar(id);
        if (employee != null) {
            employees.eliminar(id);
        }
    }

    // Método para actualizar un empleado por ID
    public void updateEmployee(int id, String name, String lastName, LocalDate birthDate, Status status, double monthlyRate, int daysWorkedInMonth) {
        Empleado employee = employees.buscar(id);
        if (employee != null) {
            employee.setName(name);
            employee.setLastName(lastName);
            employee.setBirthDate(birthDate);
            employee.setStatus(status);
            employee.setMonthlyRate(monthlyRate);
            employee.setDaysWorkedInMonth(daysWorkedInMonth);
            employees.actualizar(id, employee);
        } else {
            throw new IllegalArgumentException("No se encontró el empleado con id: " + id);
        }
    }
    public void updateEmployee(int id, String name, String lastName, Status status, double monthlyRate, int daysWorkedInMonth) {
        Empleado employee = employees.buscar(id);
        if (employee != null) {
            employee.setName(name);
            employee.setLastName(lastName);
            employee.setStatus(status);
            employee.setMonthlyRate(monthlyRate);
            employee.setDaysWorkedInMonth(daysWorkedInMonth);
            employees.actualizar(id, employee);
        } else {
            throw new IllegalArgumentException("No se encontró el empleado con id: " + id);
        }
    }

    // Método para obtener un empleado por índice
    public Empleado getEmployee(int index) {
        return employees.buscarPorIndice(index);
    }

    // Método para verificar si un empleado ya existe por ID
    private boolean employeeExist(int id) {
        for (int i = 0; i < employees.tamaño(); i++) {
            Empleado empleado = employees.buscarPorIndice(i);
            if (empleado != null && empleado.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Método para obtener el ArrayList de empleados
    public ArrayList<Empleado> getEmployees() {
        return employees;
    }


    // punto 7 metodo
    public Queue<Empleado> employeeQueue() {
        for (int i = 0; i < employees.tamaño(); i++) {
            Empleado empleado = employees.buscarPorIndice(i);
            if (empleado != null) {
                queue.offer(empleado);
            } else {
                System.out.println("ocurrio un error");
            }
        }
        return queue;
    }

    public Queue<Empleado> getQueue() {
        return queue;
    }


}
