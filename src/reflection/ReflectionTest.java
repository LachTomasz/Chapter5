package reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * Ten program wykorzystuje technikę reflekcji do wydrukowania pełnych informacji o klasie.
 * @author Tomek
 *
 */
public class ReflectionTest {
    public static void main(String[] args) {
        //Wczytanie nazwy klasy z argumentów wiersza poleceń lub danych od użytkownika.
        String name;
        if(args.length >0) name = args[0];
        else
        {
            var in = new Scanner(System.in);
            System.out.println("Podaj nazwę klasy (np. java.util.Date): ");
            name = in.next();
        }
        try
        {
            //Drukowanie nazwy klasy i nadklasy (jeśli != Object).
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());

            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("klasa " + name);

            if(supercl != null && supercl != Object.class)
                System.out.print("rozszerza klasę " + supercl.getName());

            System.out.print("\n{\n");

            printConstructors(cl);
            System.out.println();

            printMethods(cl);
            System.out.println();

            printFields(cl);
            System.out.println("}");

        }
        catch(Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    /**
     * Drukowanie wszystkich konstruktorów klasy.
     * @param cl Klasa
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("\t");
            String modifiers = Modifier.toString(c.getModifiers());

            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //Drukowanie typów parametrów
            Class[] paramTypes = c.getParameterTypes();

            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.println(");");
            }

        }
    }

    /**
     * Drukuje wszystkie metody klasy.
     * @param cl klasa
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("\t");
            //Drukowanie modyfikatorów, typu zwrotnego i nazwy metody.
            String modifiers = Modifier.toString(m.getModifiers());

            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + name + "(");

            //Drukowanie typów parametrów.
            Class[] paramTypes = m.getParameterTypes();

            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println("); ");
        }
    }

    /**
     * Drukowanie wszystkich pól klasy.
     * @param cl klasa
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for(Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("\t");
            String modifiers = Modifier.toString(f.getModifiers());

            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

}
