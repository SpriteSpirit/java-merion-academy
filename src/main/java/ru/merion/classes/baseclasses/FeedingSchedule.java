package main.java.ru.merion.classes.baseclasses;

import java.time.LocalTime;

public interface FeedingSchedule {

    boolean shouldFeedNow(LocalTime currentTime);

    int getFeedingCountPerDay();

    String getFoodType();
}
