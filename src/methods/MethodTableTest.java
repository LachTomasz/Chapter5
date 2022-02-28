package methods;

import java.lang.reflect.*;

/**
 * Ten program demonstruje sposób wywoływania metod poprzez refleksję.
 * @author Tomek
 *
 */
public class MethodTableTest {
    public static void main(String args[]) throws ReflectiveOperationException{
        //Pobieranie wskaznikow do metod square i sqrt.
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        //Drukowanie tabel wartosci x i y
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * @param x liczba
     * @return x podniesione do kwadratu
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Drukuje tablice wartosci x i y dla danej metody.
     * @param from od dolnej granicy wartosci x
     * @param to do gornej granicy wartosci x
     * @param n liczba wierszy w tabeli
     * @param f metoda z parametrem i typem zwrotnym typu double
     */
    public static void printTable(double from, double to, int n, Method f)
            throws ReflectiveOperationException{
        //Drukowanie metody jako naglowka tabeli
        System.out.println(f);

        double dx = (to - from) / (n-1);

        for(double x = from; x <= to; x += dx) {
            double y = (Double) f.invoke(null,  x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}