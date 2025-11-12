package main.java.ru.merion.classes.practiceclasses.notification;

import java.time.LocalDateTime;

abstract class Notification {

    protected String recipient;
    protected String message;
    protected LocalDateTime sentDate;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.sentDate = LocalDateTime.now();
    }

    public void validate() {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }

        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        System.out.println("Validation passed for " + recipient);
    }

    public void logNotification() {
        System.out.println("[Log]: Sent  to " + recipient + " at " + sentDate);
    }

    public abstract void send();

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }
}
