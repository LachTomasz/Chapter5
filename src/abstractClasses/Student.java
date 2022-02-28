package abstractClasses;

/**
 * @author Tomek
 *
 */
public class Student extends Person {

    private String major;
    /**
     * @param name imię i nazwisko studenta.
     * @param major specjalizacja studenta.
     */
    public Student(String name, String major) {

        super(name);
        this.major = major;

    }

    public String getDescription() {

        return "Student specjalizacji " + major;

    }

}