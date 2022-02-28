package enums;

import java.util.*;
/**
 * Program ten demonstruje typy wyliczeniowe.
 * @author Tomek
 *
 */
public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Podaj rozmiar: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Rozmiar: " + size);
        System.out.println("Skrót: " + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
            System.out.println("Dobra robota -- nie pominąłeś znaku podkteślenia _.");
        in.close();
    }
}

enum Size{	//public enum Size
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}