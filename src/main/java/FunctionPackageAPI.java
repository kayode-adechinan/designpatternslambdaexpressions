import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface MyRectangle {
    int calculateVolume(int length, int height, int width);
}


class FunctionalInterface {


    public static void main(String[] args) {

        List<String> countries = List.of("America", "India", "Russia", "China", "Japan", "Indonesia");


        // Example #1 - Implementing user-defined functional interface using lambda expression.
        MyRectangle rectangle = (int length, int height, int width) -> length * height * width;
        System.out.println(rectangle.calculateVolume(5, 5, 5));

        // Example #2 - Runnable functional interface using old implementation (i.e. anonymous class).
        Runnable runnableUsingAnonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World from Anonymous Class!");
            }
        };
        Thread myThread1 = new Thread(runnableUsingAnonymousClass);
        myThread1.start();

        // Example #3 - Runnable functional interface using lambda expression.
        Runnable runnableUsingLambda = () -> {
            System.out.println("Hello World from Lambda Expression!");
        };
        Thread myThread2 = new Thread(runnableUsingLambda);
        myThread2.start();

        // Example #4 - Predicate functional interface.
        Predicate<String> predicate = (name) -> name.startsWith("I");
        for(String name : countries) {
            if(predicate.test(name))
                System.out.println(name);
        }
    }
}



class FunctionDemo {

    public static void main(String[] args) {
        int incr = 20;
        int myNumber = 10;
        modifyTheValue(myNumber, val-> val + incr);

        myNumber = 15;
        modifyTheValue(myNumber, val-> val * 10);
        modifyTheValue(myNumber, val-> val - 100);
        modifyTheValue(myNumber, val-> "somestring".length() + val - 100);
    }

    //API which accepts an implementation of
    //Function interface
    static void modifyTheValue(int valueToBeOperated,
                               Function<Integer, Integer> function){
        int newValue = function.apply(valueToBeOperated);
        /*
         * Do some operations using the new value.
         */
        System.out.println(newValue);
    }

}


class ConsumerTest {

    public static void main(String[] args) {

        System.out.println("E.g. #1 - Java8 Consumer Example\n");

        Consumer<String> consumer = ConsumerTest::printNames;
        consumer.accept("C++");
        consumer.accept("Java");
        consumer.accept("Python");
        consumer.accept("Ruby On Rails");
    }

    private static void printNames(String name) {
        System.out.println(name);
    }
}

class SupplierTest {

    public static void main(String[] args) {

        System.out.println("E.g. #2 - Java8 Supplier Example\n");

        List<String> names = new ArrayList<String>();
        names.add("Harry");
        names.add("Daniel");
        names.add("Lucifer");
        names.add("April O' Neil");

        names.stream().forEach((item)-> {
            printNames(()-> item);
        });
    }

    private static void printNames(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}


public class FunctionPackageAPI {

    public static void main(String[] args) {

    }
}
