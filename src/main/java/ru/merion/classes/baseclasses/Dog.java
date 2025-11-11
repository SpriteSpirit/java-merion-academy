package main.java.ru.merion.classes.baseclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dog extends Animal {

    public Dog(String name, Integer age) {
        super(name, age, MoveType.WALK);
    }

    /**
     * Определяет расстояние до палки
     *
     * @param stickPosition - координаты палки
     */
    public void goToStick(Integer stickPosition) {
        Integer delta = stickPosition - currentPosition;
        runForward(delta);
    }

    public String whereTheDog() {
        return "Текущая позиция собаки: " + currentPosition;
    }

    /**
     * Создает и возвращает объект вместо того, чтобы вызывать new напрямую
     *
     * @param name
     * @param age
     * @return
     */
    public static Dog ofHomeless(String name, Integer age) {
        return new Dog(name, age);
    }

    public static Dog of(String name, Integer age) {
        return new Dog(name, age);
    }

    public static List<Dog> randomDogArray() {
        List<Dog> dogs = new ArrayList<>();

        dogs.add(Dog.of("Sharik", 5));
        dogs.add(Dog.of("Bobik", 3));
        dogs.add(Dog.of("Charlie", 1));

        return dogs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Dog other = (Dog) obj;

        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Dog{" +
            "currentPosition=" + currentPosition +
            ", age=" + age +
            ", name='" + name + '\'' +
            '}';
    }
}
