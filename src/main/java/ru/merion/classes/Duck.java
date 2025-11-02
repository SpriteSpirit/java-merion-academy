package main.java.ru.merion.classes;

public class Duck extends Bird {

    public Duck() {
        super();
        System.out.println("public Duck");
    }

    static void main() {
        Duck duck = new Duck();

        System.out.println(duck.getClass().getSimpleName() + " " + duck.getMoveType());
    }
}
