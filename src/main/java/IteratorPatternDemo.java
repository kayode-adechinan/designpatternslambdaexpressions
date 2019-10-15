import java.util.List;

public class IteratorPatternDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3);

        for(int i = 0; i<numbers.size(); i++)
            System.out.println(numbers.get(i));

        for(int e:numbers)
            System.out.println(e);

        numbers.forEach(e->System.out.println(e));

        numbers.forEach(System.out::println);




    }
}
