import java.util.function.Consumer;

class PersonBuilder {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;

    public PersonBuilder withSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }


    public PersonBuilder withIsFemale(boolean isFemale) {
        this.isFemale = isFemale;
        return this;
    }

    public PersonBuilder withIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
        return this;
    }

    public PersonBuilder withIsHomewOwner(boolean isHomewOwner) {
        this.isHomewOwner = isHomewOwner;
        return this;
    }

    public Person createPerson() {
        return new Person(salutation, firstName, middleName, lastName, suffix, isFemale, isEmployed, isHomewOwner);
    }
}


class Person
{
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;

    public Person(String salutation, String firstName, String middleName, String lastName, String suffix, boolean isFemale, boolean isEmployed, boolean isHomewOwner) {
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


class AdvancedPersonBuilder {
    public String salutation;
    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public boolean isFemale;
    public boolean isEmployed;
    public boolean isHomewOwner;

    public AdvancedPersonBuilder with(
            Consumer<AdvancedPersonBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Person createPerson() {
        return new Person(salutation, firstName, middleName,
                lastName, suffix, isFemale,
                isEmployed, isHomewOwner);
    }
}


class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .withSalutation("Mr.")
                .withFirstName("John")
                .withLastName("Doe")
                .withIsFemale(false)
                .createPerson();


        System.out.println(person);


        Person person2 = new AdvancedPersonBuilder()
                .with(personBuilder -> {
                    personBuilder.salutation = "Mr.";
                    personBuilder.firstName = "John";
                    personBuilder.lastName = "Doe";
                    personBuilder.isFemale = false;
                })
                .createPerson();


        System.out.println(person2);


        Person person3 = new AdvancedPersonBuilder()
                .with(personBuilder -> {
                    personBuilder.salutation = "Mr.";
                    personBuilder.firstName = "John";
                    personBuilder.lastName = "Doe";
                    personBuilder.isFemale = false;
                })
                .with(personBuilder -> personBuilder.isHomewOwner = true)
                .createPerson();

        System.out.println(person3);


        Person person4 = new AdvancedPersonBuilder()
                .with(p -> {
                    p.salutation = "Mr.";
                    p.firstName = "John";
                    p.lastName = "Doe";
                    p.isFemale = false;
                })
                .createPerson();

        System.out.println(person4);


        Person person5 = new AdvancedPersonBuilder()
                .with(p -> {
                    p.salutation = "Mr.";
                    p.lastName = "Doe";
                    p.isFemale = false;
                })
                .createPerson();


        System.out.println(person5);

    }
}