package main.java.ru.merion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StepikTasks {

    public static void main(String[] args) {
//        getNewHeroPosition();
//        getOddRange();
//        calculateDerangements();
        issuesByMonthsStreams(new int[]{1, 6, 10, 8, 12, 5, 4});
    }


    public static void getStars() {
        int stars = readInput1();
        String result = switch (stars) {
            case 1 -> "★";
            case 2 -> "★★";
            case 3 -> "★★★";
            case 4 -> "★★★★";
            case 5 -> "★★★★★";
            default -> "";
        };

        System.out.println(result);
    }

    public static int readInput1() {
        int stars = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            stars = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return stars;
    }

    public static void getNewHeroPosition() {
        int x, y;
        int step = 1;
        String direction, result = "";

        String[] inputValues = readInput2();
        x = Integer.parseInt(inputValues[0]);
        y = Integer.parseInt(inputValues[1]);
        direction = inputValues[2];

        switch (direction) {
            case "up" -> y -= step;
            case "down" -> y += step;
            case "left" -> x -= step;
            case "right" -> x += step;
        }

        x = Math.min(x, 100);
        x = Math.max(x, 0);
        y = Math.min(y, 100);
        y = Math.max(y, 0);

        result = String.format("x: %d, y: %d, direction: %s", x, y, direction);

        System.out.println(result);
    }

    public static String[] readInput2() {
        String[] inputValues = new String[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] values = input.split(" ");
            for (int i = 0; i < 3; i++) {
                inputValues[i] = values[i];
            }
        }
        scanner.close();

        return inputValues;
    }

    public static void getPositiveNegative() {
        /*
         * У вас есть переменная n, которая содержит входные пользовательские данные.
         * Напишите код, который проверяет является ли значение n негативным, позитивным или равно 0 и записывает результат в переменную result.
         * Если n позитивное число тогда result = "Число позитивное"
         * Если n негативное число тогда result = "Число негативное"
         * Если n равно 0 число тогда result = "Число равно 0"
         * <p>
         * Sample Input:
         * 2
         * Sample Output:
         * Число позитивное
         */
        int n = readInput3();
        String result = "";

        if (n > 0) {
            result = "Число позитивное";
        } else if (n < 0) {
            result = "Число негативное";
        } else {
            result = "Число равно 0";
        }

        System.out.println(result);
    }

    public static int readInput3() {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return n;
    }

    public static void getOddRange() {
        /*
         * У вас есть переменная n, которая содержит входные пользовательские данные.
         * n всегда содержит нечетное число.
         * Напишите код, который возвращает сумму всех нечетных чисел до n (включительно) и записывает результат в переменную result.
         *
         * Например:
         * Eсли n = 3 тогда 1 + 3 = 4
         * Eсли n = 5 тогда 1 + 3 + 5 = 9
         * Eсли n = 7 тогда 1 + 3 + 5 + 7 = 16
         * и тд.
         *
         * Sample Input 1: 3
         * Sample Output 1: 4
         * Sample Input 2: 5
         * Sample Output 2: 9
         */
        int n = readInput4();
        int result = 0;

        for (int i = 1; i <= n; i += 2) {
            result += i;
        }

        System.out.println(result);
    }

    public static int readInput4() {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return n;
    }

    public static void getTextLenStars() {
        /*
         * У вас есть переменная message, которая содержит входные пользовательские данные.
         * Напишите код, который в зависимости от длины строки message записывает количество * в переменную result.
         * Важно!
         * Учитывайте то что ваш код должен работать как с кириллицей так и с латиницей.
         * Sample Input 1: a
         * Sample Output 1: *
         * Sample Input 2: аб
         * Sample Output 2: **
         */
        String message = readInput5();
        StringBuilder result;

        result = new StringBuilder("*".repeat(message.length()));

        System.out.println(result.toString());
    }

    public static String readInput5() {
        String message = "";

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            message = scanner.nextLine();
        }
        scanner.close();

        return message;
    }

    public static void calculateDerangements() {
        int n = readInput6();
        int result;

        result = subfactorial(n);

        System.out.println(result);
    }

    public static int subfactorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }

        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 0;

        for (int people = 2; people <= n; people++) {
            results[people] = (people - 1) * (results[people - 1] + results[people - 2]);
        }

        return results[n];
    }

    public static int readInput6() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printSeparator(String symbol) {
        System.out.println(symbol.repeat(100));
    }

    public static int sumStandart(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int sumStream(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static void issuesByMonthsStandart(int[] issues) {
        Arrays.sort(issues);

        for (int i = 0; i < issues.length; i++) {
            System.out.println(String.format("Issues: %d", issues[i]));

            if ((i + 1) % 3 == 0) {
                printSeparator("=");
            }
        }

        printSeparator("=");
        System.out.println(sumStream(issues));
    }

    public static void issuesByMonthsStreams(int[] issues) {
        AtomicInteger counter = new AtomicInteger(1);

        Arrays.stream(issues)
            .sorted()
            .forEach(issue -> {
                System.out.println(String.format("Issues: %d", issue));

                if (counter.getAndIncrement() % 3 == 0) {
                    printSeparator("=");
                }
            });

        printSeparator("=");
        System.out.println(
            String.format("Total issues: %d. By %d months", sumStream(issues), issues.length));
    }
}
