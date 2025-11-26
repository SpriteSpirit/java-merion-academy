package main.java.ru.merion.streamsapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight;
import main.java.ru.merion.classes.NestedClassesAnimal.AnimalWeight.WeightType;
import main.java.ru.merion.classes.baseclasses.Dog;
import utils.LoggerFactory;

public class StreamExample {

    private static final Logger logger = LoggerFactory.getLogger(StreamExample.class);

    private StreamExample() {
        throw new UnsupportedOperationException(
            "Этот класс является служебным. Инициализация запрещена.");
    }

    public static void run() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        logger.log(Level.INFO, () -> "foreach -> Список четных чисел: " + getEvenNumber(numbers));
        logger.log(Level.INFO,
            () -> "stream -> Список четных чисел: " + getEvenNumberWithStreamAPI(numbers));
    }

    public static List<Integer> getEvenNumber(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public static List<Integer> getEvenNumberWithStreamAPI(List<Integer> numbers) {
        return numbers.stream()
            .filter(number -> number % 2 == 0)
            .toList();
    }

    public static void workWithNumbers() {
        List<Integer> numbers = List.of(100, 2, 37, -4, 54, 66);

        // вывод чисел > 0
        numbers.stream()
            .filter(num -> num > 0)
            .forEach(num -> logger.log(Level.INFO, () -> String.valueOf(num)));

        // вывод самого минимального значения > 0
        int result = numbers.stream()
            .filter(n -> n > 0)
            .min(Integer::compare)
            .orElse(0);

        logger.log(Level.INFO, () -> "Результат: " + result);

        int sum = numbers.stream()
            .reduce(Integer::sum)
            .orElse(0);

        logger.log(Level.INFO, () -> "Сумма: " + sum);
    }

    public static void workWithString() {
        List<String> originalNames = List.of("Bob", "Max", "Mary", "Alice", "James");

        logger.log(Level.INFO, () -> "Names: " + originalNames);

        // перевод всех имен списка в верхний регистр
        List<String> processedNames = originalNames.stream()
            .filter(name -> !name.isBlank())
            .map(String::toUpperCase)
            .toList();
        logger.log(Level.INFO, () -> "Names: " + processedNames);

        // подсчет кол-ва имен
        long amount = originalNames.stream()
            .filter(name -> name.startsWith("M"))
            .count();

        logger.log(Level.INFO, () -> "Количество имен на букву M: " + amount);
    }

    public static void workWithObject() {
        List<Dog> dogs = List.of(Dog.of("Sharik", new AnimalWeight(5, WeightType.KG), 1),
            Dog.of("Bobik", new AnimalWeight(5, WeightType.KG), 1),
            Dog.of("Rex", new AnimalWeight(5, WeightType.KG), 1)
        );

        Map<String, List<Dog>> dogMap = dogs.stream()
            .collect(Collectors.groupingBy(
                dog -> String.valueOf(dog.getName().charAt(0)), Collectors.toList()
            ));

        logger.log(Level.INFO, () -> "Dog map: " + dogMap);
    }

    static void main() {
        run();
        workWithNumbers();
        workWithString();
        workWithObject();
    }
}
