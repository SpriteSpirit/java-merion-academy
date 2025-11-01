package main.java.ru.merion.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Animal {

    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    protected String name;
    protected Integer age;
    protected Integer currentPosition = 0;
    protected Boolean canFly = false;

    public Animal() {

    }

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void voice() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Голос!");
        }
    }

    protected void runForward(Integer length) {
        this.currentPosition += length;
    }
}
