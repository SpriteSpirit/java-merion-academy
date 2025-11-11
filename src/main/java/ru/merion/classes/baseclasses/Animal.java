package main.java.ru.merion.classes.baseclasses;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Animal {

    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    protected String name;
    protected Integer age;
    protected Integer currentPosition = 0;
    protected MoveType moveType;
    protected FeedingSchedule feedingSchedule;

    public Animal(MoveType moveType) {
        this.moveType = moveType;
    }

    public Animal(String name, Integer age, MoveType moveType, FeedingSchedule feedingSchedule) {
        this.name = name;
        this.age = age;
        this.moveType = moveType;
        this.feedingSchedule = feedingSchedule;
    }

    public Animal(String name, Integer age, MoveType moveType) {
    }

    public boolean shouldFeedNow(LocalTime time) {
        return feedingSchedule.shouldFeedNow(time);
    }

    public String getFeedingInfo() {
        return String.format(
            "%s ест %s %d раз в день",
            name,
            feedingSchedule.getFoodType(),
            feedingSchedule.getFeedingCountPerDay()
        );
    }

    public String getName() {
        return name;
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
