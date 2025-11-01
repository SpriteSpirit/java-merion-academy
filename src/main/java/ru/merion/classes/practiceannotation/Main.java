package main.java.ru.merion.classes.practiceannotation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        dog.makeSound();

        MathUtils sum = new MathUtils();
//        sum.oldGetSum(5, 2);


        Animal dog2 = new Dog();
        dog2.makeSound();
        // кастинг - приведение типов (для уточнения типа, чтобы использовать методы подкласса)
        ((Dog) dog2).playWithToy("bone");

        getRawList("Line 1");
        getSomeWarnings();

        Converter<String> stringConverter = text -> System.out.println(text.toLowerCase());
        stringConverter.convert("HELLO WORLD!");

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
