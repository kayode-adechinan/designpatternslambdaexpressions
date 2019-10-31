package refactoring;/*class Resource{
    public Resource(){
        System.out.println("resource created");
    }
    public void op1() {
        System.out.println("op1 called....");
    }
    public void op2() {
        System.out.println("op2 called...");
    }
    public void finalize() {
        System.out.println("cleaned....");
    }
}*/

/*class Resource{
    public Resource(){
        System.out.println("resource created")
    }
    public void op1() { System.out.println("op1 called...."); }
    public void op2() { System.out.println("op2 called..."); }
    public void close() { System.out.println("cleaned...."); }
}*/

/*class Resource implements AutoCloseable{
    public Resource(){
        System.out.println("resource created")
    }
    public void op1() { System.out.println("op1 called...."); }
    public void op2() { System.out.println("op2 called..."); }
    public void close() { System.out.println("cleaned...."); }
}*/

import java.util.function.Consumer;












class Resource{
    private Resource(){
        System.out.println("resource created");
    }
    public Resource op1() { System.out.println("op1 called....");return this; }
    public Resource op2() { System.out.println("op2 called..."); return this;}
    private void close() { System.out.println("finalize called...."); }
    public static void use(Consumer<Resource> block){
        Resource resource=new Resource();
        try{
            block.accept(resource);
        }finally{
            resource.close();
        }
    }
}


public class LoanPattern  {

    public static void main(String[] args) {

       /* Resource resource=new Resource();
        resource.op1();
        resource.op2();*/

        /*Resource resource=new Resource();
        resource.op1();
        resource.op2();
        resource.close();*/

      /*  Resource resource=new Resource();
        try{
            resource.op1();
            resource.op2();
        }finally{
            resource.close();
        }*/

     /*   try (Resource resource = new Resource()) {
            resource.op1();
            resource.op2();
        }*/

        Resource.use(resource->
                resource.op1()
                        .op2());


    }
}

