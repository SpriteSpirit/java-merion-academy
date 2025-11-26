package main.java.ru.merion.classes.practiceannotation;

import java.util.ArrayList;
import java.util.List;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight.WeightType;
import main.java.ru.merion.classes.baseclasses.Dog;

public class Main {

    public static void main(String[] args) {
        PracticeDog dog = new PracticeDog();
        System.out.println(dog);
        dog.makeSound();

        MathUtils sum = new MathUtils();
//        sum.oldGetSum(5, 2);

        Animal dog2 = new PracticeDog();
        dog2.makeSound();
        // кастинг - приведение типов (для уточнения типа, чтобы использовать методы подкласса)
        ((PracticeDog) dog2).playWithToy("bone");

        getRawList("Line 1");
        getSomeWarnings();

        Converter<String> stringConverter = text -> text.toLowerCase();
        System.out.println(stringConverter.convert("HELLO WORLD!"));

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        printFirstElements(stringList);

        OldApi oldApi = new OldApi();
        NewApi newApi = new NewApi();

        Action<Integer> action = number -> System.out.println(number * 2);
        action.someAction(5);

        @SuppressWarnings("deprecation")
        var legacy = oldApi;
        legacy.printOldApi();
        newApi.printNewApi();

        Dog[] dogHomeless = new Dog[]{
            Dog.ofHomeless("Rex", new AnimalWeight(6, WeightType.KG), 3),
            Dog.ofHomeless("Jack", new AnimalWeight(6, WeightType.KG), 2),
            Dog.ofHomeless("Bobby", new AnimalWeight(6, WeightType.KG), 4),
            Dog.ofHomeless("Charlie", new AnimalWeight(6, WeightType.KG), 1),
        };

        System.out.println(dogHomeless[0]);
        System.out.println(dogHomeless[1]);
        System.out.println(dogHomeless[2]);
        System.out.println(dogHomeless[3]);

        System.out.println("");

        List<Dog> dogs = Dog.randomDogArray();

        for (Dog dog_ : dogs) {
            System.out.println(dog_);
        }
    }

    @SuppressWarnings("unchecked")
    public static void getRawList(String element) {
        List list = new ArrayList();
        list.add(element);
        System.out.println(list);
    }

    @SuppressWarnings({"unused", "rawtypes"})
    public static void getSomeWarnings() {
        int warningsCounter = 0;
        List list = new ArrayList();
    }

    @SafeVarargs
    static <T> void printFirstElements(List<T>... lists) {
        for (List<T> list : lists) {
            System.out.println(list.get(0));
        }
    }
}
