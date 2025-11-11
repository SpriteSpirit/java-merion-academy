package main.java.ru.merion.classes.person;

public class User {
    protected String name;
    protected String surname;
    protected String address;
    protected String email;
    protected Integer age;

    private static int nextId = 1;
    private final int id = nextId++;

    public User() {
        System.out.println("Базовый конструктор");
        this.name = "No name";
        this.surname = "No surname";
        this.address = "No address";
        this.email = "No email";
        this.age = null;
    }

    public User(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public User(String name, String surname, int age) {
        this();
        this.surname = surname;
    }

    public User(String name, String surname, String address, String email, int age) {
        this();
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            ", id=" + id +
            '}';
    }
}
