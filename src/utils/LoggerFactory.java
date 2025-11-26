package utils;

import java.util.logging.Logger;

public class LoggerFactory {

    private LoggerFactory() {
        throw new UnsupportedOperationException(
            "Это служебный класс, создание экземпляров запрещено");
    }

    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}
