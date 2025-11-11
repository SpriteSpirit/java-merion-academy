package main.java.ru.merion.classes.baseclasses;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringExample {

    private static void runEqualsIgnoreCase() {
        System.out.println("");
        System.out.println("runEqualsIgnoreCase");

        String str1 = "Hello world!";
        String str2 = str1;
        String str3 = "hello world";
        String str4 = "hello World!";

        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.equalsIgnoreCase(str3));
        System.out.println(str1.equalsIgnoreCase(str4));
    }

    /**
     * Демонстрирует работу метода compareTo() для строк. Метод compareTo() сравнивает строки
     * лексикографически (по алфавиту) и возвращает: - 0, если строки равны - положительное число,
     * если первая строка следует после второй в алфавитном порядке - отрицательное число, если
     * первая строка следует до второй в алфавитном порядке
     * <p>
     * Сравнение происходит посимвольно до первого различия. Регистр символов влияет на результат
     * сравнения. Метод compareTo() возвращает разницу в Unicode значениях первых различных
     * символов. Число показывает, насколько символы отличаются в таблице Unicode.
     */
    static void runCompareTo() {
        System.out.println("");
        System.out.println("runToCompareTo");

        String str1 = "Called method!";
        String str2 = "Called Method!";
        String str3 = "Called class!";

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str2.compareTo(str1));
        System.out.println(str2.compareTo(str3));
        System.out.println(str3.compareTo(str1));
        System.out.println(str3.compareTo(str2));
    }

    /**
     * Демонстрирует работу метода compareToIgnoreCase() для строк. Метод сравнивает строки
     * лексикографически (по алфавиту), ИГНОРИРУЯ РЕГИСТР БУКВ (заглавные/строчные считаются
     * одинаковыми).
     * <p>
     * Возвращает: - 0, если строки равны (без учета регистра) - положительное число, если первая
     * строка следует после второй в алфавитном порядке - отрицательное число, если первая строка
     * следует до второй в алфавитном порядке
     * <p>
     * Пример: "apple".compareToIgnoreCase("APPLE") вернет 0 "apple".compareToIgnoreCase("BANANA")
     * вернет отрицательное число
     */
    static void runCompareToIgnoreCase() {
        System.out.println("");
        System.out.println("runCompareToIgnoreCase");

        String str1 = "Called method!";
        String str2 = "Called Method!";  // Method с заглавной M
        String str3 = "Called Class!";   // Class с заглавной C

        System.out.println(str1.compareToIgnoreCase(str2)); // 0 - одинаковы без учета регистра
        System.out.println(
            str1.compareToIgnoreCase(str3)); // положительное число - "method" после "class"
        System.out.println(str2.compareToIgnoreCase(str1)); // 0 - одинаковы без учета регистра
        System.out.println(
            str2.compareToIgnoreCase(str3)); // положительное число - "method" после "class"
        System.out.println(
            str3.compareToIgnoreCase(str1)); // отрицательное число - "class" до "method"
        System.out.println(
            str3.compareToIgnoreCase(str2)); // отрицательное число - "class" до "method"
    }

    static void runToLowerCase(String text) {
        System.out.println("");
        System.out.println("runToLowerCase");

        System.out.println("Before: " + text);
        System.out.println("After: " + text.toLowerCase());
    }

    static void runToUpperCase(String text) {
        System.out.println("");
        System.out.println("runToUpperCase");

        System.out.println("Before: " + text);
        System.out.println("After: " + text.toUpperCase());
    }

    static void runConcat(String text, String nextText) {
        System.out.println("");
        System.out.println("runConcat");

        System.out.println(text.concat(nextText));
    }

    static void runMatches(String text, String textMatch) {
        System.out.println("");
        System.out.println("runMatches");

        System.out.println(text.matches("(.*)text(.*)"));
    }

    /**
     * Демонстрирует работу метода regionMatches() для сравнения регионов строк.
     * <p>
     * Назначение: - Сравнивает определенные участки (регионы) двух строк между собой - Полезен для
     * проверки наличия подстрок в определенных позициях без создания новых строк
     * <p>
     * Перегруженные версии: 1. regionMatches(int toffset, String other, int ooffset, int len) -
     * Сравнение с учетом регистра
     * <p>
     * 2. regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) -
     * Сравнение с возможностью игнорирования регистра
     * <p>
     * Параметры:
     * <p>
     * ignoreCase - игнорировать ли регистр при сравнении (true/false) toffset    - начальная
     * позиция в ТЕКУЩЕЙ строке (this) other      - строка для сравнения с текущей ooffset    -
     * начальная позиция в ДРУГОЙ строке (other) len        - количество символов для сравнения
     * <p>
     * Возвращает: - true если указанные регионы строк совпадают (с учетом ignoreCase) - false если
     * регионы отличаются или параметры выходят за границы строк
     * <p>
     * Особенности: - Если toffset или ooffset отрицательные - вернет false - Если toffset + len >
     * length() текущей строки - вернет false - Если ooffset + len > other.length() - вернет false -
     * Эффективнее substring().equals() т.к. не создает новых объектов
     */
    static void runRegionMatches(String text) {
        System.out.println("");
        System.out.println("runRegionMatches");

        String text1 = "Hello";
        String text2 = "World";
        String text3 = "hello world";

        // Пример 1: Сравнение с учетом регистра
        // Сравнивает первые 3 символа text с первыми 3 символами text1
        boolean result1 = text.regionMatches(0, text1, 0, 3);
        System.out.println(
            "Сравнение '" + text + "'[0-2] с '" + text1 + "'[0-2] (учет регистра): " + result1);

        // Пример 2: Сравнение разных строк
        // Сравнивает начало text с началом text2
        boolean result2 = text.regionMatches(0, text2, 0, 3);
        System.out.println(
            "Сравнение '" + text + "'[0-2] с '" + text2 + "'[0-2] (учет регистра): " + result2);

        // Пример 3: Сравнение без учета регистра
        // Сравнивает символы начиная с позиции 2 в text с позиции 2 в text3 (8 символов)
        boolean result3 = text.regionMatches(true, 2, text3, 2, 8);
        System.out.println(
            "Сравнение '" + text + "'[2-9] с '" + text3 + "'[2-9] (игнорировать регистр): "
                + result3);

        // Дополнительные демонстрационные примеры
        demonstrateRegionMatches(text);
    }

    /**
     * Дополнительные примеры использования regionMatches()
     */
    private static void demonstrateRegionMatches(String text) {
        System.out.println("\n--- Дополнительные примеры ---");

        // Проверка начала строки (аналог startsWith)
        boolean startsWithHello = text.regionMatches(0, "Hello", 0, 5);
        System.out.println("Начинается с 'Hello': " + startsWithHello);

        // Проверка конца строки (аналог endsWith)
        boolean endsWithWorld = text.regionMatches(text.length() - 5, "World", 0, 5);
        System.out.println("Заканчивается на 'World': " + endsWithWorld);

        // Поиск подстроки в середине
        boolean containsLoWo = text.regionMatches(3, "lo Wo", 0, 5);
        System.out.println("Содержит 'lo Wo' с позиции 3: " + containsLoWo);
    }

    static void runContains(String text, String findText) {
        System.out.println("");
        System.out.println("runContains");

        System.out.println(text.contains(findText));
    }

    static void runStartWith(String currentString, String findSTring) {
        System.out.println("");
        System.out.println("runStartWith");

        System.out.println(currentString.startsWith(findSTring));
    }

    static void runEndWith(String currentString, String findSTring) {
        System.out.println("");
        System.out.println("runEndWith");

        System.out.println(currentString.endsWith(findSTring));
    }

    /*
        text.lines() — создает Stream<String> (поток данных), где каждый элемент это одна строка из
        исходного текста text.
        Разделение происходит по \n, \r или \r\n.
        lines.forEach(System.out::println) — для каждого элемента потока (т.е. для каждой строки)
        выполняется метод println, который выводит эту строку в консоль.
    */
    static void runLines(String text) {
        System.out.println("");
        System.out.println("runLines");

        System.out.println("Before: " + text);
        Stream<String> lines = text.lines();
        System.out.println("After: ");
        lines.forEach(System.out::println);
    }

    static void runToCharArray(String text) {
        System.out.println("");
        System.out.println("runToCharArray");

        System.out.println(text.toCharArray());
        System.out.println("Type: " + text.toCharArray().getClass().getSimpleName());
    }

    static void runFormat(String text, float floatNum, int intNum, boolean boolValue) {
        System.out.println("");
        System.out.println("runFormat");

        String stringFormat = String.format("String: %s, Float: %.2f, Integer: %d, Bool: %b",
            text,
            floatNum,
            intNum,
            boolValue);
        System.out.println(stringFormat);
    }

    static void runValueOf(double doubleValue, boolean boolValue, char charValue) {
        System.out.println("");
        System.out.println("runValueOf");

        System.out.println("Double value: " + String.valueOf(doubleValue) +
            " => type: " + String.valueOf(doubleValue).getClass().getSimpleName());
        System.out.println("Bool value: " + String.valueOf(boolValue) +
            " => type: " + String.valueOf(boolValue).getClass().getSimpleName());
        System.out.println("Char value: " + String.valueOf(charValue) +
            " => type: " + String.valueOf(charValue).getClass().getSimpleName());
    }

    static void runRepeat(String text) {
        System.out.println("");
        System.out.println("runRepeat");

        System.out.println(text.repeat(10));
    }

    /**
     * Демонстрирует работу метода indexOf() для поиска ПЕРВОГО вхождения подстроки.
     * <p>
     * Принцип работы: - indexOf() ищет подстроку в основной строке и возвращает индекс ПЕРВОГО
     * совпадения - Если подстрока не найдена, возвращает -1 - Поиск чувствителен к регистру
     *
     * @param text0 основная строка для поиска
     * @param text1 подстрока, которую ищем в text0
     * @param text2 подстрока, которую ищем в text1
     *              <p>
     *              Пример вызова: runIndexOf("Hello World", "World", "orl") Вывод: "World index
     *              Hello World: 6"  - "World" начинается с индекса 6 в "Hello World" "orl index
     *              World: 1"          - "orl" начинается с индекса 1 в "World" "Hello World index
     *              orl: -1"   - "Hello World" не содержится в "orl" (возврат -1)
     */
    static void runIndexOf(String text0, String text1, String text2) {
        System.out.println("");
        System.out.println("runIndexOf");

        System.out.println(text1 + " index " + text0 + ": " + text0.indexOf(text1));
        System.out.println(text2 + " index " + text1 + ": " + text1.indexOf(text2));
        System.out.println(text0 + " index " + text2 + ": " + text2.indexOf(text0));
    }

    /**
     * Демонстрирует работу метода lastIndexOf() для поиска ПОСЛЕДНЕГО вхождения.
     * <p>
     * Принцип работы: - lastIndexOf() ищет подстроку или символ с КОНЦА строки и возвращает индекс
     * ПОСЛЕДНЕГО совпадения - Если подстрока/символ не найдены, возвращает -1 - Может принимать как
     * String, так и int (код символа) в качестве искомого значения
     *
     * @param text0   основная строка для поиска
     * @param text1   подстрока для поиска в text0, и строка для поиска символа
     * @param intChar код символа (ASCII/Unicode) для поиска в text1
     *                <p>
     *                Пример вызова: runLastIndexOf("hello world", "o", 111) Вывод: "o index hello
     *                world: 7"    - последняя "o" в "hello world" на позиции 7 "hello world index
     *                o: 4"    - символ с кодом 111 ('o') последний раз встречается в "o" на позиции
     *                0
     */
    static void runLastIndexOf(String text0, String text1, int intChar) {
        System.out.println("");
        System.out.println("runLastIndexOf");

        System.out.println(text1 + " index " + text0 + ": " + text0.lastIndexOf(text1));
        System.out.println(text0 + " index " + text1 + ": " + text1.lastIndexOf(intChar));
    }

    /**
     * Демонстрирует работу метода substring() для извлечения подстроки (аналог среза в Python).
     * <p>
     * Принцип работы: - substring() извлекает часть строки по указанным индексам - Работает по
     * принципу [включительно, исключительно): - Начальный индекс ВКЛЮЧЕН в результат - Конечный
     * индекс НЕ ВКЛЮЧЕН в результат - Индексы начинаются с 0 (zero-based)
     *
     * @param text       исходная строка для извлечения подстроки
     * @param startIndex начальный индекс (включительно)
     * @param stopIndex  конечный индекс (исключительно)
     *                   <p>
     *                   Сравнение с Python: | Python          | Java                    | Результат
     *                   | |-----------------|-------------------------|----------------| |
     *                   text[2:7]       | text.substring(2, 7)    | "llo W"        | | text[3:] |
     *                   text.substring(3)       | "lo World"     | | text[:5]        |
     *                   text.substring(0, 5)    | "Hello"        |
     *                   <p>
     *                   Особенности: - Не поддерживает отрицательные индексы (в отличие от Python)
     *                   - При startIndex = stopIndex возвращает пустую строку - При startIndex >
     *                   stopIndex выбрасывает StringIndexOutOfBoundsException
     *                   <p>
     *                   Пример вызова: runSubString("Hello World", 2, 7) Вывод: "llo W" (символы с
     *                   индекса 2 по 6, индекс 7 не включен)
     */
    static void runSubString(String text, int startIndex, int stopIndex) {
        System.out.println("");
        System.out.println("runSubString");

        System.out.println(text.substring(startIndex, stopIndex));
    }

    /**
     * Демонстрирует работу метода subSequence() для извлечения подпоследовательности символов.
     * <p>
     * Принцип работы: - subSequence() работает ИДЕНТИЧНО substring() - те же параметры и тот же
     * результат - Отличие только в возвращаемом типе: - substring() возвращает String -
     * subSequence() возвращает CharSequence (интерфейс)
     * <p>
     * Зачем нужен subSequence()? - Для совместимости с API, которые работают с CharSequence
     * (читаемые последовательности символов) - CharSequence - это интерфейс, который реализуют:
     * String, StringBuilder, StringBuffer и др.
     *
     * @param text       исходная строка для извлечения подпоследовательности
     * @param startIndex начальный индекс (включительно)
     * @param stopIndex  конечный индекс (исключительно)
     *                   <p>
     *                   Особенности: - Поведение идентично substring(): [включительно,
     *                   исключительно) - На практике почти всегда используют substring() -
     *                   subSequence() полезен когда нужна полиморфная работа с разными типами
     *                   символовых последовательностей
     *                   <p>
     *                   Пример вызова: runSubSequence("Hello World", 2, 7) Вывод: "llo W" (точно
     *                   такой же результат как у substring())
     */
    static void runSubSequence(String text, int startIndex, int stopIndex) {
        System.out.println("");
        System.out.println("runSubSequence");

        System.out.println(text.subSequence(startIndex, stopIndex));
    }

    static void runSplit(String text) {
        System.out.println("");
        System.out.println("runSplit");

        Arrays.stream(text.split(" ")).forEach(System.out::println);
        System.out.println("Type: " + text.split(" ").getClass().getSimpleName());
    }

    static void runJoin(String delimiter, String text0, String text1) {
        System.out.println("");
        System.out.println("runJoin");

        System.out.println(String.join(delimiter, text0, text1));
    }

    static void runTrim(String textWithSpaces) {
        System.out.println("");
        System.out.println("runTrim");

        System.out.println(textWithSpaces.trim());
    }

    static void runReplace(String text, String oldChars, String newChars) {
        System.out.println("");
        System.out.println("runReplace");

        System.out.println(text.replace(oldChars, newChars));
    }

    static void main(String[] args) {
        runEqualsIgnoreCase();
        runCompareTo();
        runCompareToIgnoreCase();
        runToLowerCase("Hello WOrld!");
        runToLowerCase("hello world!");
        runConcat("hello", "world!");
        runMatches("hello textworld", "world!");
        runRegionMatches("hello world");
        runContains("Twinkle twinkle little star", "twinkle");
        runContains("Twinkle twinkle little star", "how I wonder");
        runStartWith("Welcome to", "Welc");
        runEndWith("Welcome to", "To");
        runLines("line 1\nline 2\nline 3\nline 4");
        runToCharArray("Welcome to Java");
        runFormat("Hello", 2.365f, 5, false);
        runValueOf(2.356, true, 'a');
        runRepeat("welcome to java");
        runIndexOf("welcome to Java", "Java", "come");
        runLastIndexOf("welcome to Java", "Java", 11);
        runSubString("Welcome to Java", 0, 11);
        runSubSequence("Welcome to Java", 0, 11);
        runSplit("Welcome to Java");
        runJoin(" ** ", "java", "python");
        runTrim("    Hello    ");
        runTrim("...    Hello    ");
        runReplace("Hello", "el", "ol");
    }
}
