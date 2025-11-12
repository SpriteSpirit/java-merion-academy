package main.java.ru.merion.classes.practiceclasses.payment;

/* Требует двухфакторную аутентификацию */
public interface Secure {
    boolean check2FA(String code);
    void send2FACode();
}
