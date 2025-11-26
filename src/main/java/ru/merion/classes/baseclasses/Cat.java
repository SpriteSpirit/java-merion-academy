package main.java.ru.merion.classes.baseclasses;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.ru.merion.classes.NestedClassesAnimal;

public class Cat extends Animal {

    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    private final int defaultJumpHeight = 120;
    private final int jumpRatio = 20;

    public Cat(String name, Integer age) {
        super(name, age, MoveType.WALK);
    }

    public Cat(String name, Integer age, FeedingSchedule feedingSchedule) {
        super(name, age, MoveType.WALK, feedingSchedule);
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

    static void main(String[] args) {
        List<LocalTime> catFeedingTime = Arrays.asList(
            LocalTime.of(7, 0),
            LocalTime.of(13, 0),
            LocalTime.of(20, 0)
        );
        FeedingSchedule catFeedingSchedule = new TimeBasedFeedingSchedule(
            catFeedingTime,
            "meat"
        );
        Cat cat = new Cat("Барсик", 2, catFeedingSchedule);
        cat.voice();
        String catFeedingResult = cat.shouldFeedNow(LocalTime.now()) ? "Да" : "Нет";
        System.out.println(String.format("%s нужно кормить? %s", cat.getName(), catFeedingResult));

        int jumpHeight = cat.jumpHeight();

        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, String.format("Высота прыжка: %s", jumpHeight));
        }
    }

    @Override
    public void voice() {
        System.out.println("Meow-meow");
    }
}
