package main.java.ru.merion.classes.baseclasses;

import java.util.Set;

public class FeedingService {
    private final Set<Class<? extends Animal>> fedTypes = Set.of(Dog.class, Cat.class, Duck.class);

    public void feedIfNeeded(Animal animal) {
        if (fedTypes.contains(animal.getClass())) {
            System.out.println("Кормим " + animal.name);
        }
    }

    static void main(String[] args) {
        FeedingService feedingService = new FeedingService();
        Cat cat = new Cat("Мурзик", 2);

        feedingService.feedIfNeeded(cat);
    }
}
