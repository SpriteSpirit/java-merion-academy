package main.java.ru.merion.classes.baseclasses;

import java.time.LocalTime;
import java.util.List;

public class TimeBasedFeedingSchedule implements FeedingSchedule {

    private final List<LocalTime> feedingTimes;
    private final String foodType;

    public TimeBasedFeedingSchedule(List<LocalTime> feedingTimes, String foodType) {
        this.feedingTimes = feedingTimes;
        this.foodType = foodType;
    }

    /**
     * Проверяет, находится ли текущее время в 15-минутном интервале, начинающемся в указанное время
     * кормления. Интервал включает время начала кормления и длится 15 минут.
     * <p>
     * Пример: для времени кормления 13:00 интервал [13:00, 13:15)
     *
     * @param currentTime - текущее время
     * @return true - если текущее время попадает в интервал кормления, иначе false
     */
    @Override
    public boolean shouldFeedNow(LocalTime currentTime) {

        for (LocalTime feedingTime : feedingTimes) {
            if (!currentTime.isBefore(feedingTime) && currentTime.isBefore(
                feedingTime.plusMinutes(15))) {
                return true;
            }
        }
//        LocalTime current = LocalTime.of(currentTime.getHour(), currentTime.getMinute());
//        return feedingTimes.contains(current);
        return false;
    }

    @Override
    public int getFeedingCountPerDay() {
        return feedingTimes.size();
    }

    @Override
    public String getFoodType() {
        return foodType;
    }
}
