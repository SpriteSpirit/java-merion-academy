package main.java.ru.merion.classes.practiceannotation;

@FunctionalInterface
public interface Action<T> {
    void someAction(T value);
}
