package main.java.ru.merion.classes.practiceclasses.notification;

public class SmsNotification extends Notification implements Prioritizable, Trackable {

    private PriorityLevel priority = PriorityLevel.HIGH;
    private boolean delivered = false;

    public SmsNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public void send() {
        System.out.println("Send sms to " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Priority: " + priority);

        // имитация отправки
        try {
            Thread.sleep(1000);
            markAsDelivered();
        } catch (InterruptedException e) {
            System.out.println("Failed to send sms! Error: " + e);
        }
    }

    @Override
    public void setPriority(PriorityLevel level) {
        this.priority = level;
    }

    @Override
    public PriorityLevel getPriority() {
        return priority;
    }

    @Override
    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public void markAsDelivered() {
        delivered = true;
        System.out.println("Sms delivered to " + recipient);
    }
}
