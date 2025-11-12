package main.java.ru.merion.classes.practiceclasses.notification;

public interface Prioritizable {
    enum PriorityLevel {
        LOW, MEDIUM, HIGH, URGENT
    }

    void setPriority(PriorityLevel level);
    PriorityLevel getPriority();
}
