package main.java.ru.merion.classes.practiceannotation;


public class MathUtils {

    /**
     * @deprecated Используйте {@link #getSum(int, int)} вместо этого метода
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public void oldGetSum(int a, int b) {
        System.out.println("Old sum: " + (a + b));
    }

    /**
     * Возвращает сумму двух целых чисел
     * @param a - целое число
     * @param b - целое число
     */
    public int getSum(int a, int b) {
        return a + b;
    }
}
