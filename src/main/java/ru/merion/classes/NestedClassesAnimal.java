package main.java.ru.merion.classes;

import main.java.ru.merion.classes.baseclasses.FeedingSchedule;
import main.java.ru.merion.classes.baseclasses.MoveType;
import main.java.ru.merion.classes.baseclasses.WeightException;

public abstract class NestedClassesAnimal {

    public abstract void voice();

    public static class AnimalWeight {

        public enum WeightType {
            KG, GR
        }

        private Integer value;
        private WeightType weightType;

        public AnimalWeight(Integer value, WeightType weightType) {
            setValue(value);
            this.value = value;
            this.weightType = weightType;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            if (value < 0) {
                throw new WeightException("Вес не может быть отрицательным");
            }
            this.value = value;
        }

        public WeightType getWeightType() {
            return weightType;
        }

        public void setWeightType(
            WeightType weightType) {
            this.weightType = weightType;
        }

        @Override
        public String toString() {
            return "AnimalWeight{" +
                "value=" + value +
                ", weightType=" + weightType +
                '}';
        }
    }

    protected String name;
    protected AnimalWeight weight;
    protected Integer age;
    protected MoveType moveType;
    protected FeedingSchedule feedingSchedule;

    public NestedClassesAnimal(String name, AnimalWeight weight, Integer age, MoveType moveType) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.moveType = moveType;
    }

    public NestedClassesAnimal(String name, AnimalWeight weight, Integer age, MoveType moveType,
        FeedingSchedule feedingSchedule) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.moveType = moveType;
        this.feedingSchedule = feedingSchedule;
    }

    public String getName() {
        return name;
    }

    public AnimalWeight getWeight() {
        return weight;
    }

    public void setWeight(AnimalWeight weight) {
        this.weight = weight;
    }
}
