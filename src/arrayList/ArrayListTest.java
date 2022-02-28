package arrayList;

import java.time.LocalDate;
import java.util.*;

/**
 * Ten program demonstruje użycie klasy ArrayList.
 * @author Tomek
 *
 */
public class ArrayListTest {
    public static void main(String[]args) {
        //Wstawianie do listy staff trzech obiektów klasy Employee.
        var staff = new ArrayList<Employee>();

        staff.add(new Employee("Karol Krakowski", 75000, 1987, 12, 15));
        staff.add(new Employee("Henryk Kwiatek", 50000, 1989, 10, 1));
        staff.add(new Employee("Waldemar Kowalski", 40000, 1990, 3, 15));

        //Zwiększenie pensji wszystkich pracowników o 5%.
        for(Employee e : staff)
            e.raiseSalary(5);

        //Drukowanie informacji o wszystkich obiektach Employee.
        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary =" + e.getSalary()
                    + ", hireDay =" + e.getHireDay());
    }
}

class Employee{

    //pola
    private String name;
    private double salary;
    private LocalDate hireDay;

    //Konstruktor
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, month);
    }

    //Metody
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
        //równierz poprawne
        //this.salary += raise;

    }
}