package inheritance;

/**
 * Ten program demonstruje dziedziczenie.
 * @author Tomek
 *
 */
public class ManagerTest {

    public static void main(String[] args) {

        var boss = new Manager("Karol Parol", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        var staff = new Employee[3];

        //wstawianie obiektów klas Manager i Employee do tablicy stuff.
        staff[0] = boss;
        staff[1] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
        staff[2] = new Employee("Artur Kwiatkowski", 40000, 1990, 3, 15);

        //Wyświetlenie informacji o wszystkich obiektach klasy Employee.
        for(Employee e : staff)
            System.out.println("Nazwisko: " + e.getName() + ", salary: " + e.getSalary());
    }
}