package main.java.ru.merion.classes.collectionframework;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import main.java.ru.merion.classes.Dog;

public class CollectionFramework {

    static void main() {
        List<Dog> dogHomeless = Arrays.asList(new Dog[]{
            Dog.ofHomeless("Rex", 3),
            Dog.ofHomeless("Jack", 2),
            Dog.ofHomeless("Bobby", 4),
            Dog.ofHomeless("Charlie", 1),
        });

        System.out.println(dogHomeless.size());
        System.out.println(dogHomeless.get(0));
        System.out.println(dogHomeless.get(1));
        System.out.println(dogHomeless.get(2));

        for (int i = 0; i < 10; i++) {
            System.out.println("i = "+ i);
        }

        for (Dog dog : dogHomeless) {
            System.out.println(dog);
        }

        int index = 0;

        while (index < dogHomeless.size()) {
            index++;

            if (index == 2) {
                continue;
            }
            System.out.println(index);
        }

        do {
            System.out.println("index = " + index);
            index++;

            if (index >= 10) {
                break;
            }
        } while (index < 10);

        for (int i = 0; i < 5; i++) {
            run();
        }
    }

    public static void run() {
        Random random = new Random();
        int example = random.nextInt(1, 5);
        // random.nextInt(1, 5)  // Генерирует числа: 1, 2, 3, 4

        System.out.println(example);

        switch (example) {
            case 1: System.out.println("You won"); break;
            case 2, 3, 4: System.out.println("You lose"); break;
            default:
                System.out.printf("Bye!");
        }
    }
}
