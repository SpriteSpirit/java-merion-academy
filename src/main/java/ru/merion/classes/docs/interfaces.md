## Интерфейсы

### Виды методов в интерфейсе

#### Основные черты интерфейсов в Java (актуально для Java 8+):
* **Абстрактные методы** - объявления без реализации (обязательны для реализации)
* **Методы по умолчанию (default)** - с реализацией, не обязательны для переопределения
* **Статические методы** - принадлежат интерфейсу, вызываются через имя интерфейса
* **Константы** - все поля автоматически public static final
* **Приватные методы** - для организации кода внутри интерфейса (Java 9+)
* **Множественная реализация** - класс может реализовать несколько интерфейсов
* **Наследование интерфейсов** - интерфейсы могут наследовать друг от друга

#### Пример полного интерфейса:
```java
public interface Animal {

    // Константа
    String KINGDOM = "Animalia";

    // Абстрактный метод
    void makeSound();

    // Метод по умолчанию
    default void breathe() {
        System.out.println("Breathing...");
    }

    // Статический метод
    static boolean isAnimal(Object obj) {
        return obj instanceof Animal;
    }
}
```
#### 1. Абстрактные методы (старый добрый контракт)

- Только объявление, без реализации.
- Реализация обязательна в классе, который implements интерфейс.

```java
interface Animal {

    void makeSound(); // абстрактный метод
}

class Dog implements Animal {

    @Override
    public void makeSound() { // обязаны реализовать
        System.out.println("Woof!");
    }
}
```

> 📌 Используются, когда интерфейс задаёт поведение, а реализация оставляется на усмотрение класса.

#### 2. Default методы (Java 8+)

- Имеют реализацию по умолчанию.
    - Класс может:
        - использовать её как есть,
        - или переопределить.

```java
interface Walkable {

    default void walk() {
        System.out.println("Walking on two legs");
    }
}

class Human implements Walkable {

} // не переопределяет

class Robot implements Walkable {

    @Override
    public void walk() {
        System.out.println("Walking on wheels");
    }
}

public class Main {

    public static void main(String[] args) {
        new Human().walk(); // ✅ Walking on two legs (default)
        new Robot().walk(); // ✅ Walking on wheels (переопределил)
    }
}
```

> 📌 Используются, чтобы не ломать старый код, если к интерфейсу добавляются новые методы.

#### 3. Static методы (Java 8+)

- Привязаны к интерфейсу, а не к объекту.
- Вызываются через имя интерфейса.
- Класс, который реализует интерфейс, не наследует эти методы.

```java
interface Utils {

    static void printHello() {
        System.out.println("Hello from interface!");
    }
}

public class Main2 {

    public static void main(String[] args) {
        Utils.printHello(); // ✅ Hello from interface!
        // new Main2().printHello(); ❌ так нельзя
    }
}
```

> 📌 Обычно применяются как вспомогательные функции, связанные с контрактом.

#### 4. Private методы (Java 9+)

- Можно вызывать только внутри интерфейса (в `default` или `static` методах).
- Нужны для рефакторинга — чтобы не дублировать код в нескольких методах интерфейса.

```java
interface Logger {

    default void logInfo(String msg) {
        log("INFO", msg);
    }

    default void logError(String msg) {
        log("ERROR", msg);
    }

    // private метод — общий для default методов
    private void log(String level, String msg) {
        System.out.println("[" + level + "] " + msg);
    }
}

class App implements Logger {

}

public class Main3 {

    public static void main(String[] args) {
        App app = new App();
        app.logInfo("Started");  // ✅ [INFO] Started
        app.logError("Crashed"); // ✅ [ERROR] Crashed
    }
}
```

> 📌 Удобно, если в интерфейсе несколько default методов и нужно вынести общую логику.

📝 Итог:

- `Абстрактные` методы = чистый контракт, реализация обязательна в классе.
- `Default` методы = реализация по умолчанию, можно переопределить.
- `Static` методы = привязаны к интерфейсу, вызываются через имя интерфейса.
- `Private` методы = для внутреннего переиспользования в интерфейсе.

## Методы в интерфейсах Java

| Тип метода      | Есть реализация в интерфейсе? | Кто обязан реализовать           | Как вызывается                | Когда использовать                                                                            |
|-----------------|-------------------------------|----------------------------------|-------------------------------|-----------------------------------------------------------------------------------------------|
| **Абстрактный** | ❌ нет                         | Класс (`implements`)             | Через объект                  | Задать контракт без реализации                                                                |
| **Default**     | ✅ да (по умолчанию)           | Не обязан (можно переопределить) | Через объект                  | Добавить новый метод в интерфейс, не ломая старый код; дать «разумное поведение» по умолчанию |
| **Static**      | ✅ да                          | Никто (не наследуется)           | Через `ИмяИнтерфейса.метод()` | Вспомогательные функции, связанные с интерфейсом                                              |
| **Private**     | ✅ да (только для интерфейса)  | Никто                            | Только внутри интерфейса      | Вынести общую логику для `default`/`static` методов                                           |
