package refactoring;

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
    private boolean isHomeOwner;

    public Employee(String salutation, String firstName,
                    String middleName, String lastName, String suffix,
                    boolean isFemale, boolean isEmployed, boolean isHomeOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomeOwner = isHomeOwner;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salutation='" + salutation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomeOwner=" + isHomeOwner +
                '}';
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
    private boolean isHomeOwner;

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

    public EmployeeBuilder withIsHomeOwner(boolean isHomeOwner) {
        this.isHomeOwner = isHomeOwner;
        return this;
    }

    public Employee createEmployee() {
        return new Employee(salutation, firstName, middleName, lastName, suffix, isFemale, isEmployed, isHomeOwner);
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
    public boolean isHomeOwner;

    public AdvancedEmployeeBuilder with(
            Consumer<AdvancedEmployeeBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Employee createEmployee() {
        return new Employee(salutation, firstName, middleName,
                lastName, suffix, isFemale,
                isEmployed, isHomeOwner);
    }
}





public class BuilderDemo {

    public static void main(String[] args) {

        Employee employee = new AdvancedEmployeeBuilder()
                .with(e -> {
                    e.salutation = "Mr.";
                    e.lastName = "Doe";
                    e.isFemale = false;
                })
                .createEmployee();


        System.out.println(employee);


    }
}
