package assignment1.assignment2;

import java.util.List;

public class NotificationManager {
    private final Notification notification;

    // Constructor that accepts any Notification type (DIP)
    public NotificationManager(Notification notification) {
        this.notification = notification;
    }

    // Send notification to a single user
    public void sendNotification(String message, String recipient) {
        notification.send(message, recipient);
    }

    // Send notifications to multiple users (Bulk sending)
    public void sendBulkNotification(String message, List<String> recipients) {
        for (String recipient : recipients) {
            notification.send(message, recipient);
        }
    }
}
