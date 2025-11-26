package main.java.ru.merion;


import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.ru.merion.base.Base;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight.WeightType;
import main.java.ru.merion.classes.baseclasses.Cat;
import main.java.ru.merion.classes.baseclasses.Dog;
import main.java.ru.merion.classes.baseclasses.Duck;
import main.java.ru.merion.classes.baseclasses.FeedingSchedule;
import main.java.ru.merion.classes.baseclasses.MoveType;
import main.java.ru.merion.classes.baseclasses.TimeBasedFeedingSchedule;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Base.run();

        Duck duck = new Duck();
        duck.voice();

        int x0 = 10;

        modifyPrimitive(x0);

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Измененный примитив: %d", x0));
        }

        // Создаём объект Box с value = 10
        Box myBox = new Box(10);

        // Лог до изменения
        if (logger.isLoggable(Level.INFO)) {
            logger.info("До метода: myBox.value = " + myBox.value);
        }

        // Передаём объект в метод
        modifyBox(myBox);

        // Лог после метода
        if (logger.isLoggable(Level.INFO)) {
            logger.info("После метода: myBox.value = " + myBox.value);
        }

        // Уровни методов в Java
        Dog dog = new Dog("Рекс", new AnimalWeight(7, WeightType.KG), 5);
        dog.voice();

        dog.goToStick(14);
        logger.info(dog.whereTheDog());

        dog.goToStick(20);
        logger.info(dog.whereTheDog());

        dog.goToStick(5);
        logger.info(dog.whereTheDog());

        Dog homelessDog = Dog.ofHomeless("Bob", new AnimalWeight(10, WeightType.KG), 2);

        if (logger.isLoggable(Level.INFO)) {
            logger.info(homelessDog.toString());
        }

    }

    // Метод, который меняет поле объекта
    public static void modifyBox(Box box) {
        box.value *= 2;

        if (logger.isLoggable(Level.INFO)) {
            logger.info("Внутри метода: box.value = " + box.value);
        }
    }

    void print(double x) {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("x = " + x);
        }
    }

    int print(int x, int y) {
        return x + y;
    }

    int print(int x) {
        return x * x;
    }

    public static void modifyPrimitive(int x) {
        x *= 2; // ← это только ЛОКАЛЬНАЯ копия! это не влияет на оригинальный x снаружи.
    }
}

// Простой класс с полем int
class Box {

    int value;

    Box(int value) {
        this.value = value;
    }
}
