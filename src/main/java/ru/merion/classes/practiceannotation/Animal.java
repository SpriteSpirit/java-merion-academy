package main.java.ru.merion.classes.practiceannotation;

public class Animal {
    public void makeSound() {
        System.out.println(String.format("%s make sound", getClass().getSimpleName()));
    }
}
