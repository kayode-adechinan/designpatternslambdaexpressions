package lambdaanatomy;

public class LambdaAnatomyDemo {
    public static void main(String[] args) {

        LambdaAnatomyDemo lambdaAnatomyDemo = new LambdaAnatomyDemo();

        // passing two numbers with MathOperation's implementation
        int result = lambdaAnatomyDemo.operate(5, 6, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        });

        System.out.println(result);


        int resultwithlambda = lambdaAnatomyDemo.operate(5, 6, (a,b)->a+b);
        System.out.println(resultwithlambda);


    }

    public int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
