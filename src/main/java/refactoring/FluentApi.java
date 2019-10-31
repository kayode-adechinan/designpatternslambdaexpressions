package refactoring;/*
class Mailer {
    private void print(String val) { System.out.println(val);  }
    public void from(String addr) { print("from"); }
    public void to(String addr) { print("to"); }
    public void subject(String subjectLine) { print("subject"); }
    public void body(String message) { print("body"); }
    public void send() { print("sending..."); }
}
*/

/*class Mailer {
    private Mailer print(String val) {
        System.out.println(val); return this;
    }
    public Mailer from(String addr) {
        print("from"); return this;
    }
    public Mailer to(String addr) {
        print("to"); return this;
    }
    public Mailer subject(String subjectLine) {
        print("subject"); return this;
    }
    public Mailer body(String message) {
        print("body"); return this;
    }
    public void send() {
        print("sending...");
    }
}*/

import java.util.function.Consumer;





class Mailer {
    private Mailer print(String val) {
        System.out.println(val); return this;
    }
    public Mailer from(String addr) {
        print("from"); return this;
    }
    public Mailer to(String addr) {
        print("to"); return this;
    }
    public Mailer subject(String subjectLine) {
        print("subject"); return this;
    }
    public Mailer body(String message) {
        print("body"); return this;
    }
    public static void send(Consumer<Mailer> block) {
        Mailer mailer=new Mailer();
        block.accept(mailer);
        System.out.println("sending...");
    }
}


public class FluentApi {


    public static void main(String[] args) {
       /* Mailer mailer = new Mailer();
        mailer.from("ajay@sample.com");
        mailer.to("sreeram@sample.com");
        mailer.subject("sample subject");
        mailer.body("...");
        mailer.send();*/


       /*new Mailer()
                .from("ajay@sample.com")
                .to("sreeram@sample.com")
                .subject("sample subject")
                .body("...")
                .send();*/


        Mailer.send(mailer -> mailer
                .from("ajay@sample.com")
                .to("sreeram@sample.com")
                .subject("sample subject")
                .body("...")
        );

    }

}
