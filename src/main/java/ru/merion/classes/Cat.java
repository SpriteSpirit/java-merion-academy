package main.java.ru.merion.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cat extends Animal {

    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    private final int defaultJumpHeight = 120;
    private final int jumpRatio = 20;

    public Cat(String name, Integer age) {
        super(name, age);
        canFly = false;
    }

    public Integer jumpHeight() {
        if (this.age == null) {
            return defaultJumpHeight;
        }

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Jump height: %d cm", this.age * jumpRatio));
        }
        return this.age * jumpRatio;
    }
}
