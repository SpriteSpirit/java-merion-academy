package main.java.ru.merion.classes.practiceclasses.payment;

/**
 * Класс для возврата денежных средств
 */
public interface Refundable {
    void refund(double amount, String reason);
    void cancelRefund();
    boolean canRefund();
    String getRefundStatus();
}
