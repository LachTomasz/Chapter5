package abstractClasses;

/**
 * Ten program demonstruje klasy abstrakcyjne.
 * @author Tomek
 *
 */
public class PersonTest {

    public static void main(String[] args) {

        var people = new Person[2];

        //Wstawianie do tablicy people obiektów Student i Employee.
        people[0] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Mrozowska", "Informatyka");

        //Drukowanie imion i nazwisk oraz opisów klasy Person.
        for(Person p : people)
            System.out.println(p.getName() +  ", " + p.getDescription());

    }

}