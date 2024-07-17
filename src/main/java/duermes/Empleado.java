package duermes;

import duermes.collection.Hashtable;

import java.time.LocalDate;
import java.time.Month;

public class Empleado {
    private static int idCounter = 00000;
    private int id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Status status;
    private static final double TAX = 0.15;
    private double salary;
    private Hashtable<Month, Integer> workDaysPerMonth;

    public Empleado(String name, String lastName, LocalDate birthDate, Status status, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.status = status;
        this.salary = salary;
        this.workDaysPerMonth = new Hashtable<>(12);
        setId();
    }

    private void setId() {
        this.id = ++idCounter;
    }

    public double getFinalSalary() {
        return salary - (salary * TAX);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkDays(Month month) {
        return workDaysPerMonth.get(month);
    }

    public void setWorkDaysPerMonth(Month mes, int days) {
        workDaysPerMonth.put(mes, days);
    }

    public int getId() {
        return id;
    }

}
