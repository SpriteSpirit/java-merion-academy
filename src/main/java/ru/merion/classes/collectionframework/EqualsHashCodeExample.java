package main.java.ru.merion.classes.collectionframework;


import main.java.ru.merion.classes.baseclasses.Dog;

public class EqualsHashCodeExample {

    static void main() {
        Dog dog1 = new Dog("Шарик", 2);
        Dog dog2 = new Dog("Рекс", 3);
        Dog dog3 = new Dog("Чарли", 5);
        Dog dog4 = new Dog("Чарли", 5);

        System.out.println("== : " + (dog1 == dog2));
        System.out.println("equal : " + dog1.equals(dog2));
        System.out.println("== : " + (dog3 == dog4));
        System.out.println("equal : " + dog3.equals(dog4));
    }
}
