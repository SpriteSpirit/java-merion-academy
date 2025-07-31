package main.java.ru.merion;


import main.java.ru.merion.base.Base;
import main.java.ru.merion.classes.Animal;import main.java.ru.merion.classes.Cat;

public class Main {

    public static void main(String[] args) {
        Base.run();

        Animal animal = new Animal();
        animal.voice();

        Cat cat = new Cat();
        cat.voice();
    }
}