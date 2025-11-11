package main.java.ru.merion.classes.practiceannotation;

@FunctionalInterface
public interface Converter<T> {
    public T convert(T value);
}
