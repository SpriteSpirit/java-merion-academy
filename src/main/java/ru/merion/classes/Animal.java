package main.java.ru.merion.classes;

import java.util.logging.Level;import java.util.logging.Logger;

public class Animal {
    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    public void voice() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Voice!");
        }
    }
}
