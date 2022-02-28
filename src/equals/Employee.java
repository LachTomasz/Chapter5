package equals;

import java.time.*;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        //Sprawdzenie, czy obiekty są identycznee.
        if (this == otherObject) return true;

        //Musi zwrócić false, jeśli jawny parametr jest null
        if (otherObject == null) return false;

        //Jeśli klasy się nie zgadzają, nie mogą być jednakowe
        if(getClass() != otherObject.getClass()) return false;

        //Teraz wiadomo, że otherObject jest typu Employee i nie jest null.
        var other = (Employee) otherObject;

        //Sprawdzenie czy pola mają identyczne wartości.
        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name +
                ".salary=" + salary + ".hireDay=" + hireDay + "]";
    }
}
