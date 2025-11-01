package main.java.ru.merion.classes;

public class Person implements Cloneable {

    String name;
    Integer age;
    Address address;

    public Person() {

    }

    public Person(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", address=" + address +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 1. Вызываем родительский clone() (из Object)
        Person clone = (Person) super.clone();
        // 2. Глубокое копирование для мутабельных полей
        clone.address = (Address) address.clone();
        // 3. Возвращаем копию
        return clone;
    }

    static void main() throws CloneNotSupportedException {
        // shallow copy
        Address aliceAddress = new Address();

        aliceAddress.street = "456 New St.";
        aliceAddress.zipcode = 12354;
        aliceAddress.house = 45;

        Person alice = new Person("Alice", 25, aliceAddress);
        Person aliceCopy = new Person(alice.name, alice.age, alice.address);

        System.out.println("Alice: " + alice);
        System.out.println("Alice copy: " + aliceCopy);

        // deep copy
        Person aliceDeepCopy = (Person) alice.clone();

        aliceCopy.address.street = "78 Old St.";

        System.out.println("Alice: " + alice);
        System.out.println("Alice copy: " + aliceCopy);
        System.out.println("Alice deep copy: " + aliceDeepCopy);

        aliceDeepCopy.setAge(35);

        System.out.println(alice.getAddress());
        System.out.println(alice.getName());
        System.out.println(alice.getAge());

        System.out.println(aliceDeepCopy.getAge());
    }
}
