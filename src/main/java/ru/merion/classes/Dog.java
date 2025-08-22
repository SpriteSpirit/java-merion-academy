package main.java.ru.merion.classes;

public class Dog extends Animal {

    public Dog(String name, Integer age) {
        super(name, age);
    }

    /**
     * Определяет расстояние до палки
     * @param stickPosition - координаты палки
     */
    public void goToStick(Integer stickPosition) {
        Integer delta = stickPosition - currentPosition;
        runForward(delta);
    }

    public String whereTheDog() {
        return "Текущая позиция собаки: " + currentPosition;
    }

    /**
     * Создает и возвращает объект вместо того, чтобы вызывать new напрямую
     * @param name
     * @param age
     * @return
     */
    public static Dog ofHomeless(String name, Integer age) {
        return new Dog(name, age);
    }
}
