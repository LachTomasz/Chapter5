package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @author Tomek
 *
 */
class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Konwertuje objekt na łańcuch zawierający listę wszystkich pól.
     * @param obj objekt
     * @return łańcuch zawierający nazwę klasy objektu oraz nazwy i wartości wszystkich pól.
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {

        if(obj == null) return "null";

        if(visited.contains(obj)) return "...";

        visited.add(obj);
        Class cl = obj.getClass();

        if(cl == String.class) return (String) obj;
        if(cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for(int i = 0; i < Array.getLength(obj); i++) {
                if ( i > 0) r += ",";
                Object val = Array.get(obj, i);
                if(cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        //Inspekcja pól tej klasy i wszystkich nadklas.
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //Pobranie nazw i wartości wszystkich pól.
            for(Field f : fields) {
                if(!Modifier.isStatic(f.getModifiers())) {
                    if(!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    if(t.isPrimitive()) r += val;
                    else r += toString(val);
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }
}