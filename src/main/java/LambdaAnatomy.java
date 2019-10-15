
public class LambdaAnatomy {

    public static void main(String args[]) {
        LambdaAnatomy tester = new LambdaAnatomy();

        //avec déclaration de type
        MathOperation addition = (int a, int b) -> a + b;

        //sans déclaration de type
        MathOperation subtraction = (a, b) -> a - b;

        // avec l'expression return et accolades
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // avec l'expression return sans accolades
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //sans paranthèses
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //avec paranthèses
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}