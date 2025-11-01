package main.java.ru.merion.classes.practiceannotation;

public class PracticeDog extends Animal {
    @Override
    public void makeSound() {
        System.out.println(String.format("%s make sound", getClass().getSimpleName()));
    }

    public void playWithToy(String toy) {
        System.out.println(String.format("%s play with %s", getClass().getSimpleName(), toy));
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
