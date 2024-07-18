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
    private double monthlyRate;
    private int daysWorkedInMonth;


    public Empleado(String name, String lastName, LocalDate birthDate, Status status, double monthlyRate, int daysWorkedInMonth) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.status = status;
        this.monthlyRate = monthlyRate;
        this.daysWorkedInMonth = daysWorkedInMonth;
        setId();
    }

    public double monthlyAmount() {
        return monthlyRate * (double) (daysWorkedInMonth/30);
    }

    public double salary() {
        return monthlyAmount() - (monthlyAmount() * TAX);
    }

    private void setId() {
        this.id = ++idCounter;
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

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public int getId() {
        return id;
    }

}
