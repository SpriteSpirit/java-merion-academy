package main.java.ru.merion.base;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Base {

    public static final Logger logger = Logger.getLogger(Base.class.getName());

    public static void run() {
        int x = 0;
        long i = 100L, j = 200L, k = 300L;
        byte bx0 = 0x06, bx1 = 0x07;
        short s = 17;

        char symbol0 = 'f';
        char symbol1 = '\u0042';

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("x = %d", x));
            logger.info(String.format("i = %d, j = %d, k = %d", i, j, k));
            logger.info(String.format("bx0 = %d, bx1 = %d", bx0, bx1));
            logger.info(String.format("s = %d", s));

            logger.info(String.format("symbol = %s", symbol0));
            logger.info(String.format("symbol = %s", symbol1));
        }

        Integer age = 25;                           // авто-упаковка (int -> Integer)
        String text = "123";
        int num = Integer.parseInt(text);           // метод обёртки

        List<Integer> numbers = new ArrayList<>();  // только обёртки!
        numbers.add(42);
        numbers.add(38);
        numbers.add(14);

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("age = %d", age));
            logger.info(String.format("num = %d", num));
            logger.info("numbers: " +
                numbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }
}
