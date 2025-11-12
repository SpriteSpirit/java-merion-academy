package main.java.ru.merion.classes.practiceclasses.notification;

import main.java.ru.merion.classes.practiceclasses.notification.Prioritizable.PriorityLevel;

public class Main {

    static void main(String[] args) {
        SmsNotification smsNotification = new SmsNotification("user@mail.com", "Hello world");
        smsNotification.send();
        smsNotification.setPriority(PriorityLevel.HIGH);
        smsNotification.getPriority();
        smsNotification.getMessage();
        smsNotification.getRecipient();
        smsNotification.isDelivered();
//        smsNotification.markAsDelivered();
//        smsNotification.isDelivered();
    }
}
