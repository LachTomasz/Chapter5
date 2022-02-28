package objectAnalyzer;


import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

/**
 * Ten program analizuje objekty za pomocą refleksji.
 * @author Tomek
 *
 */
public class ObjectAnalyzerTest {
    public static void main (String[]  args) throws ReflectiveOperationException, InaccessibleObjectException {
        var squares = new ArrayList<Integer>();
        for(int i = 1; i <=5; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

}
