package main.java.ru.merion.classes.practiceclasses.payment;

/* Подписка */
public interface Recurring {
    void activateRecurring(String interval);
    void cancelRecurring(String reason);
    boolean canActivateRecurring();
    String getRecurringStatus();
    java.time.LocalDate getNextPaymentDate();
}
