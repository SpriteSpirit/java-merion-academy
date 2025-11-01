package main.java.ru.merion.classes;

public class Address implements Cloneable {
    String street;
    Integer house;
    Integer zipcode;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", house=" + house +
            ", zipcode=" + zipcode +
            '}';
    }
}
