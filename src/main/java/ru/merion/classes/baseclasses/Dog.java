package main.java.ru.merion.classes.baseclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import main.java.ru.merion.classes.NestedClassesAnimal;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight.WeightType;

public class Dog extends NestedClassesAnimal {

    private static Logger logger = Logger.getLogger(Dog.class.getName());
    protected Integer currentPosition = 0;

    public Dog(String name, AnimalWeight weight, Integer age) {
        super(name, weight, age, MoveType.WALK);
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
    public static Dog ofHomeless(String name, AnimalWeight weight, Integer age) {
        return new Dog(name, weight, age);
    }

    public static Dog of(String name, AnimalWeight weight, Integer age) {
        return new Dog(name, weight, age);
    }

    public static List<Dog> randomDogArray() {
        List<Dog> dogs = new ArrayList<>();

        dogs.add(Dog.of("Sharik", new AnimalWeight(5, WeightType.KG), 3));
        dogs.add(Dog.of("Bobik", new AnimalWeight(6, WeightType.KG), 3));
        dogs.add(Dog.of("Charlie", new AnimalWeight(7, WeightType.KG), 1));

        return dogs;
    }

    protected void runForward(Integer length) {
        this.currentPosition += length;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

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

    @Override
    public void voice() {
        logger.info("Woof-woof");
    }

    public static void main(String[] args) {

        Dog dog = new Dog("Bob", new AnimalWeight(2, WeightType.KG), 5);

        try {
            dog.getWeight().setValue(-5);
        } catch (WeightException _) {
            // Берем вес по модулю
            int positiveWeight = Math.abs(-5);
            dog.getWeight().setValue(positiveWeight);

            // Сообщаем пользователю
            logger.info("Вы указали отрицательный вес, что недопустимо. ");
            logger.info(
                "Вес автоматически исправлен на положительный: " + positiveWeight + " кг");
        }

        // Программа продолжает работу
        logger.info("Текущий вес собаки: " + dog.getWeight().getValue() + " кг");

    }
}
