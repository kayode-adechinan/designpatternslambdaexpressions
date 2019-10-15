import java.util.*;

public class IteratorPattern {

    public static void main(String[] args) {
        /*
        Vector names = new Vector();

        Enumeration e = names.elements();
        while (e.hasMoreElements())
        {
            String name = (String) e.nextElement();
            System.out.println(name);
        }
        */

        /*
        List names = new LinkedList();

        Iterator i = names.iterator();
        while (i.hasNext())
        {
            String name = (String) i.next();
            System.out.println(name);
        }
        */



       /* List<String> names = new LinkedList<>();

        for (String name : names)
            System.out.println(name);*/


     /*   List<String> names = new LinkedList<>();

        names.forEach(name -> System.out.println(name));
*/


        /*List<String> names = new LinkedList<>();

        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();*/


        List<String> names = new LinkedList<>();

        long count = 0;
        for (String name : names)
        {
            if (name.startsWith("A"))
                ++count;
        }






    }

}
