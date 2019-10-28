

/*class Employee
{
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}*/

/*
class Employee {

    private final String firstName;
    private final String lastName;
    private final String middleName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
    }

    public Employee(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }
}
*/


/*class Employee {

    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String salutation;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
        salutation = null;
    }

    public Employee(String firstName, String lastName,
                  String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        salutation = null;
    }

    public Employee(String firstName, String lastName,
                  String middleName, String salutation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salutation = salutation;
    }
}*/



/*
class Employee {

    private  String firstName;
    private  String lastName;
    private  String middleName;
    private  String salutation;

    public Employee(String firstName, String lastName) {
        new Employee(firstName, lastName, null);
    }

    public Employee(String firstName, String lastName,
                  String middleName) {
        new Employee(firstName, lastName, middleName, null);
    }

    public Employee(String firstName, String lastName,
                  String middleName, String salutation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salutation = salutation;
    }
}
*/


/*class Employee
{
    private  String salutation;
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  String suffix;
    private  boolean isFemale;
    private  boolean isEmployed;
    private  boolean isHomewOwner;


    public Employee(String salutation, String firstName, String middleName,
                    String lastName, String suffix, boolean isFemale, boolean isEmployed, boolean isHomewOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomewOwner = isHomewOwner;
    }
}*/


import java.util.function.Consumer;

class Employee
{
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;

    public Employee(String salutation, String firstName,
                    String middleName, String lastName, String suffix,
                    boolean isFemale, boolean isEmployed, boolean isHomewOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomewOwner = isHomewOwner;
    }
}


class EmployeeBuilder {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;

    public EmployeeBuilder withSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;

    }

    public EmployeeBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }


    public EmployeeBuilder withIsFemale(boolean isFemale) {
        this.isFemale = isFemale;
        return this;
    }

    public EmployeeBuilder withIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
        return this;
    }

    public EmployeeBuilder withIsHomewOwner(boolean isHomewOwner) {
        this.isHomewOwner = isHomewOwner;
        return this;
    }

    public Employee createEmployee() {
        return new Employee(salutation, firstName, middleName, lastName, suffix, isFemale, isEmployed, isHomewOwner);
    }
}


class AdvancedEmployeeBuilder {
    public String salutation;
    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public boolean isFemale;
    public boolean isEmployed;
    public boolean isHomewOwner;

    public AdvancedEmployeeBuilder with(
            Consumer<AdvancedEmployeeBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Employee createEmployee() {
        return new Employee(salutation, firstName, middleName,
                lastName, suffix, isFemale,
                isEmployed, isHomewOwner);
    }
}





public class BuilderDemo {

    public static void main(String[] args) {
      //  new Employee("John", "Doe");


        Employee employee = new EmployeeBuilder()
                .withSalutation("Mr.")
                .withFirstName("John")
                .withLastName("Doe")
                .withIsFemale(false)
                .createEmployee();


        System.out.println(employee);


        Employee employee2 = new AdvancedEmployeeBuilder()
                .with(employeeBuilder -> {
                    employeeBuilder.salutation = "Mr.";
                    employeeBuilder.firstName = "John";
                    employeeBuilder.lastName = "Doe";
                    employeeBuilder.isFemale = false;
                })
                .createEmployee();


        System.out.println(employee2);

        Employee employee3 = new AdvancedEmployeeBuilder()
                .with(employeeBuilder -> {
                    employeeBuilder.salutation = "Mr.";
                    employeeBuilder.firstName = "John";
                    employeeBuilder.lastName = "Doe";
                    employeeBuilder.isFemale = false;
                })
                .with(employeeBuilder -> employeeBuilder.isHomewOwner = true)
                .createEmployee();

        System.out.println(employee3);


        Employee employee4 = new AdvancedEmployeeBuilder()
                .with(e -> {
                    e.salutation = "Mr.";
                    e.firstName = "John";
                    e.lastName = "Doe";
                    e.isFemale = false;
                })
                .createEmployee();

        System.out.println(employee4);


        Employee employee5 = new AdvancedEmployeeBuilder()
                .with(e -> {
                    e.salutation = "Mr.";
                    e.lastName = "Doe";
                    e.isFemale = false;
                })
                .createEmployee();



        System.out.println(employee5);




    }
}
