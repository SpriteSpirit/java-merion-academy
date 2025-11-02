package main.java.ru.merion.classes;

public enum MoveType {
    FLY("Летает"), WALK("Ходит"), SWIM("Плавает");

    private String value;

    MoveType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
