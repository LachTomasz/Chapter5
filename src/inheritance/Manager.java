package inheritance;

/**
 * @author Tomek
 *
 */
public class Manager extends Employee {

    private double bonus;

    /**
     *
     * @param name Imię i nazwisko pracownika
     * @param salary Pensja pracownika
     * @param year rok przyjęcia  do pracy
     * @param month miesiąc przyjęcja do pracy 1-styczen .. 12 grudzien
     * @param day dzień przyjęcia do pracy
     */
    public Manager(String name, double salary, int year, int month, int day) {

        super(name,salary,year,month,day);	//"super" wywołuje konstruktor klasy Employee
        bonus = 0;
    }

    /**
     * @param baseSalary zwraca wartość pensji managera
     */
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    /**
     *
     * @param bonus dodatek do pensji
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
