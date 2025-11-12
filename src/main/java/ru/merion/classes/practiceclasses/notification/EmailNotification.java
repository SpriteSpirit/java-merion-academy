package main.java.ru.merion.classes.practiceclasses.notification;

public class EmailNotification extends Notification implements Prioritizable, Trackable {

    private PriorityLevel priority = PriorityLevel.MEDIUM;
    private boolean delivered = false;

    public EmailNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public void send() {
        System.out.println("Send email to " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Priority: " + priority);

        // имитация отправки
        try {
            Thread.sleep(1000);
            markAsDelivered();
        } catch (InterruptedException e) {
            System.out.println("Failed to send email! Error: " + e);
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
        System.out.println("Email delivered to " + recipient);
    }
}
