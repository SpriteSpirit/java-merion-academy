package main.java.ru.merion.classes.practiceannotation;


public class OldApi {
    @Deprecated(since = "1.0", forRemoval = true)
    public void printOldApi() {
            System.out.println("Old Api Method");
        }
}
