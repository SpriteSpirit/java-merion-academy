package main.java.ru.merion.classes.baseclasses;

public class Duck extends Bird implements Swimmable {

    public Duck() {
        super();
        System.out.println("public Duck");
    }

    @Override
    public void swim() {
        System.out.println(String.format("%s is swimmable", getClass().getSimpleName()));
    }

     static void main(String[] args) {
        Duck duck = new Duck();

        System.out.println(duck.getClass().getSimpleName() + " " + duck.getMoveType());
        duck.swim();
    }

    @Override
    public void voice() {
        System.out.println("Quack-quack");
    }
}
