package main.java.ru.merion;

public class TypeConversion {

    /**
     * Демонстрирует преобразование строки в числовой тип byte.
     * <p>
     * Принцип работы: - Оба метода (valueOf() и parseByte()) преобразуют строковое представление
     * числа в значение типа byte - Строка должна содержать целое число в диапазоне от -128 до 127 -
     * Строка может содержать знак минус для отрицательных чисел - Преобразование чувствительно к
     * формату числа (не допускаются пробелы, буквы, десятичные точки)
     * <p>
     * Разница между методами: - Byte.parseByte(String s) → возвращает примитивный тип byte -
     * Byte.valueOf(String s) → возвращает объект-обертку Byte
     * <p>
     * ВАЖНЫЕ ОГРАНИЧЕНИЯ: - Диапазон допустимых значений: от -128 до 127 включительно - Числа вне
     * этого диапазона вызовут NumberFormatException - Нечисловые строки вызовут
     * NumberFormatException - Пустые строки или null вызовут исключения
     *
     * @param numberText строковое представление числа для преобразования Должно быть целым числом в
     *                   диапазоне -128..127 Примеры допустимых значений: "0", "127", "-128", "64"
     *                   <p>
     *                   Примеры вызова: runStringToByte("100")    // ✅ Успешно: число в диапазоне
     *                   runStringToByte("-50")    // ✅ Успешно: отрицательное число в диапазоне
     *                   runStringToByte("12345")  // ❌ NumberFormatException: число больше 127
     *                   runStringToByte("12.5")   // ❌ NumberFormatException: не целое число
     *                   runStringToByte("abc")    // ❌ NumberFormatException: не число
     *                   <p>
     *                   Рекомендации по использованию: 1. Всегда проверяйте, что строка содержит
     *                   число в правильном диапазоне 2. Используйте try-catch для обработки
     *                   возможных NumberFormatException 3. Для больших чисел используйте
     *                   Integer.valueOf() или Long.valueOf() 4. Для чисел с плавающей точкой
     *                   используйте Float.valueOf() или Double.valueOf()
     */
    private static void runStringToByte(String numberText) {
        System.out.println("runStringToByte");
        System.out.println("Byte.valueOf() => " + Byte.valueOf(numberText));
        System.out.println("Byte.parseByte() => " + Byte.parseByte(numberText));
    }

    /**
     * Безопасная версия преобразования строки в byte с обработкой исключений.
     *
     * @param numberText строка для преобразования
     * @return преобразованное значение byte или null при ошибке
     */
    private static Byte safeStringToByte(String numberText) {
        try {
            byte result = Byte.parseByte(numberText);
            System.out.println("Успешное преобразование: '" + numberText + "' -> " + result);
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования: '" + numberText +
                "' - должно быть целое число от -128 до 127");
            return null;
        }
    }

    /**
    * Используй Integer.valueOf() когда:
    * Нужен объект для коллекций (List<Integer>, Map<Integer, ...>)
    * Работаешь с nullable значениями
    * Используешь методы класса Integer
    * Медленнее - создает объект
    *
    * Используй Integer.parseInt() когда:
    * Нужен примитив для вычислений
    * Важна производительность (избегаем упаковки)
    * Работаешь с массивами примитивов (int[])
    * Быстрее - возвращает примитив
     */
    private static void runStringToInt(String intText) {
        System.out.println("");
        System.out.println("runStringToInt");

        Integer numberObj = Integer.valueOf(intText);
        int number = Integer.parseInt(intText);

        System.out.println("Integer: " + numberObj);
        System.out.println("int: " + number);
    }

    private static void runStringToBool(String boolText) {
        System.out.println("");
        System.out.println("runStringToBool");

        Boolean boolObj = Boolean.valueOf(boolText);
        boolean boolValue = Boolean.parseBoolean(boolText);

        System.out.println("Boolean: " + boolObj);
        System.out.println("boolean: " + boolValue);
    }

    static void main(String[] args) {
        runStringToByte("123");
        runStringToInt("1235");
        runStringToBool("TRue");
        runStringToBool("Java");
    }
}
