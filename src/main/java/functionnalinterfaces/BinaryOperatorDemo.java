package functionnalinterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator =
                (value1, value2) -> value1+value2;


        System.out.println(binaryOperator.apply(1, 2));
    }
}
