package main.java.ru.merion.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Animal {

    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    protected String name;
    protected Integer age;
    protected Integer currentPosition = 0;
    protected MoveType moveType;

    public Animal(MoveType moveType) {
        this.moveType = moveType;
    }

    public Animal(String name, Integer age, MoveType moveType) {
        this.name = name;
        this.age = age;
        this.moveType = moveType;
    }

    public void voice() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Голос!");
        }
    }

    protected void runForward(Integer length) {
        this.currentPosition += length;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}
