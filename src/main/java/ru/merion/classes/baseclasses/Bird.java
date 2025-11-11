package main.java.ru.merion.classes.baseclasses;

public class Bird extends Animal {

    protected Boolean flyModeActive = false;

    public Bird() {
        super(MoveType.FLY);
    }
}
