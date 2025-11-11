package main.java.ru.merion.strings;

public class StringExamples {
    private static String getString() {
        return "Welcome";
    }

    private static void runContextEquals() {
        System.out.println("runContextEquals");
        String str1 = getString();  // "Welcome" — это объект класса String
        String str2 = "Hello!";     // тоже String, но с другим текстом

        StringBuffer str3 = new StringBuffer(getString());  // "Welcome", но тип StringBuffer
        StringBuffer str4 = new StringBuffer("Welcome");    // тоже StringBuffer

        // сравнивает содержимое независимо от типа
        boolean result = str1.contentEquals(str3);

        System.out.println("str1.contentEquals(str3) : " + result);
        // String.equals() проверяет не только содержимое, но и тип объекта. Поэтому false
        System.out.println("str1.equals(str3) : " + str1.equals(str3));
    }

    public static void run() {
           getString();
           runContextEquals();
    }

    static void main() {
        run();
    }
}

/**
 * | Переменная | Тип          | Значение  | Класс        |
 * | ---------- | ------------ | --------- | ------------ |
 * | `str1`     | String       | "Welcome" | String       |
 * | `str2`     | String       | "Hello!"  | String       |
 * | `str3`     | StringBuffer | "Welcome" | StringBuffer |
 * | `str4`     | StringBuffer | "Welcome" | StringBuffer |
 */

/**
 * | Свойство                                      | `String`                                                       | `StringBuilder`                               | `StringBuffer`                               |
 * | --------------------------------------------- | -------------------------------------------------------------- | --------------------------------------------- | -------------------------------------------- |
 * | **Изменяемость (mutable)**                    | ❌ Нет — неизменяемый                                           | ✅ Да                                          | ✅ Да                                         |
 * | **Потокобезопасность (thread-safe)**          | ⚙️ Не нужно — неизменяемый                                     | ❌ Нет                                         | ✅ Да (синхронизирован)                       |
 * | **Скорость работы**                           | 🐢 Медленнее при частых изменениях                             | 🚀 Быстрее                                    | 🐇 Средняя (из-за синхронизации)             |
 * | **Можно ли менять содержимое после создания** | ❌ Нет                                                          | ✅ Да (через `.append()`, `.insert()`, и т.д.) | ✅ Да                                         |
 * | **Тип класса**                                | `final`                                                        | обычный                                       | обычный                                      |
 * | **Использование `equals()`**                  | Сравнивает содержимое, но только если `instanceof String`      | Наследует от `Object` → сравнивает по ссылке  | Наследует от `Object` → сравнивает по ссылке |
 * | **Использование `contentEquals()`**           | Может сравнивать `String` с `StringBuilder` или `StringBuffer` | Не реализован                                 | Не реализован                                |
 * | **Основное применение**                       | Тексты, которые не меняются                                    | Частые изменения строк в одном потоке         | Частые изменения строк в многопоточном коде  |
 */
