package main.java.ru.merion.classes.practiceannotation;

@FunctionalInterface
public interface Converter<T> {
    public void convert(T value);
}
