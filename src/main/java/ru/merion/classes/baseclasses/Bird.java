package main.java.ru.merion.classes.baseclasses;

public abstract class Bird extends Animal {

    protected Boolean flyModeActive = false;

    public Bird() {
        super(MoveType.FLY);
    }
}
