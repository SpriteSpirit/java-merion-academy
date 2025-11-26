package main.java.ru.merion.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.LoggerFactory;

public class LambdaExample {

    private static final Logger logger = LoggerFactory.getLogger(LambdaExample.class);

    private LambdaExample() {
        // Приватный конструктор, чтобы скрыть публичный конструктор по умолчанию
        throw new UnsupportedOperationException(
            "Это служебный класс, создание экземпляров запрещено");
    }

    static {
        logger.setLevel(java.util.logging.Level.INFO);
    }

    public static void run() {
        LambdaOperator lambdaOperator = (x, y) -> x * y;
        int result = lambdaOperator.multiply(5, 2);
        logger.log(Level.INFO, () -> "Результат: " + result);
    }

    static void main() {
        run();
    }
}
