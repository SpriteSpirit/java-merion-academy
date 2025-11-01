## Наследование (Inheritance)

### Задача 1

Создать класс `Animal` с методом `makeSound()`. Класс `Dog` наследует `Animal` и переопределяет
`makeSound()`.
Проверьте динамический полиморфизм.

#### Решение:

```java
class Animal {

    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {

    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound(); // Bark
    }
}

```

### Задача 2

Добавьте поле name в `Animal` и в `Dog`. Выведите name через ссылку типа `Animal` и типа `Dog`.

#### Решение:

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";
}

public class Main {

    public static void main(String[] args) {
        Animal a = new Dog();
        Dog d = new Dog();

        System.out.println(a.name); // Animal
        System.out.println(d.name); // Dog
    }
}
```

### Задача 3

Создать базовый класс `Character` с полем name и методом `attack()`. 
Создать класс `Warrior`, который наследует `Character` и переопределяет метод `attack()`.

#### Решение:
```java
class Character {
    String name;
    Character(String name) { this.name = name; }
    void attack() { System.out.println(name + " attacks generically"); }
}

class Warrior extends Character {
    Warrior(String name) { super(name); }
    @Override
    void attack() { System.out.println(name + " swings a sword!"); }
}

public class Main {
    public static void main(String[] args) {
        Character c = new Warrior("Thor");
        c.attack(); // Thor swings a sword!
    }
}

```

### Задача 4

Создать базовый класс `Product` с полями `name` и `price`. 
Создать класс `Book`, который наследует `Product` и добавляет поле `author`.

#### Решение:
```java
class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
}

class Book extends Product {
    String author;
    Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }
    void printInfo() {
        System.out.println(name + " by " + author + " costs $" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b = new Book("Java 101", 29.99, "Alice");
        b.printInfo(); // Java 101 by Alice costs $29.99
    }
}
```


## Наследование + Интерфейсы (множественная имплементация)

### Задача 1

Создать интерфейсы `Flyable` и `Swimmable` с методом `action()`. Создать класс `Duck`, который
реализует оба интерфейса.

#### Решение:

```java
interface Flyable {

    void fly();
}

interface Swimmable {

    void swim();
}

class Duck implements Flyable, Swimmable {

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}

public class Main {

    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();   // Duck is flying
        d.swim();  // Duck is swimming
    }
}
```

### Задача 2

Создать абстрактный класс `Bird` с методом `sing()`.
Класс `Sparrow` наследует `Bird` и реализует интерфейс `Flyable`.

#### Решение:

```java
abstract class Bird {

    abstract void sing();
}

interface Flyable {

    void fly();
}

class Sparrow extends Bird implements Flyable {

    @Override
    void sing() {
        System.out.println("Chirp");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

public class Main {

    public static void main(String[] args) {
        Bird b = new Sparrow();
        b.sing(); // Chirp
        ((Flyable) b).fly(); // Sparrow is flying
    }
}
```

### Задача 3
Создать интерфейсы `Flyable` и `Swimmable` с методами `fly()` и `swim()`. 
Класс SuperHero наследует `Character` и реализует оба интерфейса.

#### Решение:
```java
interface Flyable { void fly(); }
interface Swimmable { void swim(); }

class Character {
    String name;
    Character(String name) { this.name = name; }
}

class SuperHero extends Character implements Flyable, Swimmable {
    SuperHero(String name) { super(name); }

    @Override
    public void fly() { System.out.println(name + " flies!"); }
    @Override
    public void swim() { System.out.println(name + " swims!"); }
}

public class Main {
    public static void main(String[] args) {
        SuperHero sh = new SuperHero("Aquafly");
        sh.fly();  // Aquafly flies!
        sh.swim(); // Aquafly swims!
    }
}
```

### Задача 4
Создать абстрактный класс `Discount` с методом `apply()`. 
Создать интерфейс `OnlineSale` с методом `buyOnline()`. 
Класс `BookSale` наследует `Discount` и реализует `OnlineSale`.

#### Решение:
```java
abstract class Discount {
    abstract double apply(double price);
}

interface OnlineSale { void buyOnline(); }

class BookSale extends Discount implements OnlineSale {
    @Override
    double apply(double price) { return price * 0.9; } // скидка 10%

    @Override
    public void buyOnline() { System.out.println("Book bought online!"); }
}

public class Main {
    public static void main(String[] args) {
        BookSale bs = new BookSale();
        System.out.println(bs.apply(50)); // 45.0
        bs.buyOnline();                   // Book bought online!
    }
}
```

## Композиция и Агрегация

### Задача 1 (Композиция)

Создайте класс `Car` с полем `Engine`. Двигатель создаётся внутри конструктора `Car`.

#### Решение:

```java
class Engine {

    void start() {
        System.out.println("Engine started");
    }
}

class Car {

    private Engine engine;

    Car() {
        engine = new Engine();
    }

    void start() {
        engine.start();
    }
}

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // Engine started
    }
}
```

### Задача 2 (Агрегация)

Создайте класс `School` с полем `List<Teacher>`. Учителя создаются вне школы и передаются в
конструктор.

#### Решение:

```java
import java.util.List;
import java.util.ArrayList;

class Teacher {

    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class School {

    private List<Teacher> teachers;

    School(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    void printTeachers() {
        for (Teacher t : teachers)
            System.out.println(t.name);
    }
}

public class Main {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("Alice");
        Teacher t2 = new Teacher("Bob");
        List<Teacher> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);

        School s = new School(list);
        s.printTeachers();
    }
}
```

### Задача 3 (Композиция)
Создать класс `Weapon`. Класс `Hero` создаёт и владеет своим оружием.

#### Решение:
```java
class Weapon {
    void use() { System.out.println("Weapon used!"); }
}

class Hero {
    private Weapon weapon;
    Hero() { weapon = new Weapon(); }
    void attack() { weapon.use(); }
}

public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.attack(); // Weapon used!
    }
}
```

### Задача 4 (Агрегация)
Создать класс `Shop`, который хранит список `Product`. Товары создаются отдельно и передаются в магазин.

#### Решение:
```java
import java.util.List;
import java.util.ArrayList;

class Product {
    String name;
    Product(String name) { this.name = name; }
}

class Shop {
    private List<Product> products;
    Shop(List<Product> products) { this.products = products; }
    void listProducts() {
        for (Product p : products) System.out.println(p.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop");
        Product p2 = new Product("Phone");
        List<Product> list = new ArrayList<>();
        list.add(p1); list.add(p2);

        Shop shop = new Shop(list);
        shop.listProducts();
    }
}
```


## Методы vs поля, динамический полиморфизм
### Задача — Герой и здоровье
Создать класс `Character` с полем `health` и методом `getHealth()`. 
Создать класс `Warrior`, который скрывает поле `health` и переопределяет метод `getHealth()`.

#### Решение:
```java
class Character {
    int health = 100;
    int getHealth() { return health; }
}

class Warrior extends Character {
    int health = 200; // скрываем поле
    @Override
    int getHealth() { return health; } // переопределяем метод
}

public class Main {
    public static void main(String[] args) {
        Character c = new Warrior();
        Warrior w = new Warrior();

        System.out.println(c.health);    // 100 — поле берётся по типу переменной
        System.out.println(c.getHealth()); // 200 — метод динамически диспетчеризуется
        System.out.println(w.health);    // 200
        System.out.println(w.getHealth()); // 200
    }
}
```



## Static методы и скрытие (method hiding)
### Задача — Магазин и метод продажи
Создать класс `Product` с `static void sell()`. 
Создать класс `Book` с `static void sell()`. 
Проверить вызов через переменную родителя и через класс.

#### Решение:
```java
class Product {
    static void sell() { System.out.println("Selling a product"); }
}

class Book extends Product {
    static void sell() { System.out.println("Selling a book"); }
}

public class Main {
    public static void main(String[] args) {
        Product p = new Book();
        p.sell(); // Selling a product — выбор по типу переменной
        Book.sell(); // Selling a book
        Product.sell(); // Selling a product
    }
}
```

## Приведение типов и ClassCastException
### Задача — Герой и зомби
Создать `Character` и `Zombie`. Попробовать привести `Character` к `Zombie` через явное приведение.

#### Решение:
```java
class Character { }
class Zombie extends Character { }

public class Main {
    public static void main(String[] args) {
        Character c = new Character();
        try {
            Zombie z = (Zombie) c; // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("Cannot cast Character to Zombie!");
        }
    }
}
```

## Final поля и методы
### Задача — Магазин и ограниченный товар
Создать класс `Product` с `final double price`. 
Попробовать изменить цену и сделать финальный метод `getPrice()`.

#### Решение:
```java
class Product {
    final double price = 50;
    final double getPrice() { return price; }
}

class Book extends Product {
    // Нельзя переопределять final метод
    // void getPrice() { return 100; } // ❌ ошибка компиляции
}

public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        System.out.println(p.getPrice()); // 50
        // p.price = 100; // ❌ ошибка, поле final
    }
}
```

## Композиция + Агрегация (с подводными камнями)
### Задача — Герой с оружием и магазин с товарами
`Hero` создаёт `Weapon` (композиция).
`Shop` хранит `Product` (агрегация).

#### Решение:
```java
class Weapon {
    void use() { System.out.println("Weapon used!"); }
}

class Hero {
    private final Weapon weapon; // композиция
    Hero() { weapon = new Weapon(); }
    void attack() { weapon.use(); }
}

class Product { String name; Product(String n) { name = n; } }

class Shop {
    private final List<Product> products; // агрегация
    Shop(List<Product> p) { products = p; }
    void list() { for(Product x: products) System.out.println(x.name); }
}

public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.attack(); // Weapon used!

        List<Product> list = new ArrayList<>();
        list.add(new Product("Potion"));
        list.add(new Product("Sword"));
        Shop shop = new Shop(list);
        shop.list();
    }
}
```


# Подводные камни наследования в Java

| Тема                                       | Поведение / Правило                                                                                                   | Пример кода                                                                                                                                                                                                                | Вывод / Пояснение                                                      |
|--------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| **Методы vs поля**                         | Методы переопределяются (динамический полиморфизм), поля — скрываются (field hiding)                                  | ```java class A { int x=1; int getX(){return x;} } class B extends A { int x=2; int getX(){return x;} } public class Main { A a = new B(); System.out.println(a.x); System.out.println(a.getX()); } ```                    | 1, 2 → поле берётся по типу переменной, метод — по типу объекта        |
| **Static методы**                          | Статические методы не переопределяются, а скрываются (method hiding)                                                  | ```java class A { static void hello(){System.out.println("A");} } class B extends A { static void hello(){System.out.println("B");} } public class Main { A a = new B(); a.hello(); B.hello(); }```                        | A, B → выбор метода по типу переменной, а не объекта                   |
| **Final поля**                             | Нельзя переназначить после инициализации                                                                              | ```java class A { final int x=5; } public class Main { A a = new A(); // a.x = 10; ❌ }```                                                                                                                                  | Ошибка компиляции при попытке изменить поле                            |
| **Final методы**                           | Нельзя переопределять в наследниках                                                                                   | ```java class A { final void f(){} } class B extends A { /* void f(){} ❌ */ }```                                                                                                                                           | Ошибка компиляции                                                      |
| **Приведение типов**                       | Приведение родитель → потомок требует явного кастинга; неверное приведение → ClassCastException                       | ```java class A{} class B extends A{} public class Main { A a = new A(); B b = (B) a; }```                                                                                                                                 | ClassCastException                                                     |
| **Динамический полиморфизм**               | Метод вызывается по реальному типу объекта, а не по типу переменной                                                   | ```java class A { void f(){System.out.println("A");} } class B extends A { void f(){System.out.println("B");} } A a = new B(); a.f();```                                                                                   | B → метод выбирается по типу объекта                                   |
| **Композиция (Composition)**               | Родитель создаёт и управляет дочерним объектом; жизненный цикл дочернего объекта зависит от родителя                  | ```java class Engine{} class Car { private Engine e = new Engine(); }```                                                                                                                                                   | Car владеет Engine, при уничтожении Car — Engine тоже уничтожается     |
| **Агрегация (Aggregation)**                | Родитель хранит ссылку на объект, который создаётся извне; жизненный цикл независим                                   | ```java class Teacher{} class School { private List<Teacher> teachers; School(List<Teacher> t){teachers=t;} }```                                                                                                           | Teacher существует отдельно, School только хранит ссылку               |
| **Поля и методы в разных уровнях доступа** | Методы могут быть переопределены с более открытым модификатором доступа; поля не переопределяются                     | ```java class A { protected int x; } class B extends A { public int x; }```                                                                                                                                                | Поле B.x скрывает A.x, методы могут расширять доступ                   |
| **Abstract классы + интерфейсы**           | Абстрактный класс может иметь поля и методы с реализацией; интерфейсы (с Java 8+) могут иметь default и static методы | ```java abstract class Animal { abstract void sing(); } interface Flyable { default void fly(){System.out.println("fly");} } class Bird extends Animal implements Flyable { void sing(){System.out.println("chirp");} }``` | Bird обязан реализовать sing(), fly() можно использовать default метод |
