package main.java.ru.merion.classes.anonymousclass;

import main.java.ru.merion.classes.baseclasses.Swimmable;

public class AnonExample {

    public static void run() {
        Swimmable swimmable = new Swimmable() {
            @Override
            public void swim() {
                System.out.println("Swimmable.swim()");
            }
        };
    }
}
