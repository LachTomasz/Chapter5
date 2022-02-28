package arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * Ten program demonstruje zastosowanie refleksji do manipulacji tablicami.
 * @author Tomek
 *
 */
public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[]b = {"Tomek", "Daniel", "Henryk"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("Poniższe wywołanie spowoduje wyjątek.");
        b = (String[]) badCopyOf(b,10);
    }

    /**
     * Ta metoda próbuje powiększyć tablicę, tworząc nową tablicę i kopiując
     * wszystkie elementy.
     * @param a tablica, która ma być powiększona
     * @param newLength nowa długość tablicy
     * @return większa tablica zawierająca wszystkie elementy tablicy a.
     * Zwrócona tablica jest typu Object[], a nie takiego samego jak a.
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {//nieprzydatna
        var newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }


    /**
     * Ta metoda powiększa tablicę, tworząc nową tablicę tego samego typu
     * i kopiując wszystkie elementy.
     * @param a tablica, która ma być powiększona. Może to być tablica objektów
     * lub elementó typu podstawowego.
     * @return większa tablica zawierająca wszystkie elementy tablicy a.
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if(!cl.isArray()) return null;

        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}