package inheritance;

import java.time.*;

/**
 *
 * @author Tomek
 *
 */

public class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    /**
     *
     * @param name Imię i nazwisko pracownika
     * @param salary Pensja pracownika
     * @param year rok przyjęcia  do pracy
     * @param month miesiąc przyjęcja do pracy 1-styczen .. 12 grudzien
     * @param day dzień przyjęcia do pracy
     */
    public Employee (String name, double salary, int year, int month, int day) {

        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    /**
     * Zwraca Imię i Nazwisko pracownika.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Zwraca wartość pensji
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Zwraca date zatrudnienia
     * @return hireDay
     */

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * Podnosi pensję pracownika
     * @param byPercent
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent /100;
        salary += raise;
    }
}