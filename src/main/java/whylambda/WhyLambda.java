package whylambda;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparingInt;


public class WhyLambda {

    public static void main(String[] args) {

        Product p1 = new Product("samsung", 250000);
        Product p2 = new Product("itel", 78000);
        Product p3 = new Product("xaomi", 120000);

        Product [] productArray = {p1, p2, p3};

         // before java 8
         Arrays.sort(productArray, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });


         // with lambda expression
        Arrays.sort(productArray, (o1, o2) -> o1.getPrice() - o2.getPrice());

        // with methode reference
        Arrays.sort(productArray, comparingInt(Product::getPrice));


    }

}
