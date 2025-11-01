package main.java.ru.merion.classes;

public class Bird extends Animal {
    protected Boolean flyModeActive = false;

    public Bird() {
        super();
        this.canFly = true;
    }
}
