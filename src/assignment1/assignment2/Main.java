package assignment1.assignment2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Notification smsNotification = new SMSNotification();
        Notification emailNotification = new EmailNotification();
        Notification pushNotification = new PushNotification();

        smsNotification.send("s", "s");
        NotificationManager smsManager = new NotificationManager(smsNotification);
        NotificationManager emailManager = new NotificationManager(emailNotification);
        NotificationManager pushManager = new NotificationManager(pushNotification);

        // Send individual notifications
        smsManager.sendNotification("Your SMS code is 123456", "123-456-7890");
        emailManager.sendNotification("Welcome to our service!", "user@example.com");
        pushManager.sendNotification("You have a new message!", "PushUser123");

        // Send bulk notifications
        List<String> smsRecipients = List.of("123-456-7890", "987-654-3210");
        smsManager.sendBulkNotification("Bulk SMS: This is a notification!", smsRecipients);

        List<String> emailRecipients = List.of("user1@example.com", "user2@example.com");
        emailManager.sendBulkNotification("Bulk Email: This is a notification!", emailRecipients);

        List<String> pushRecipients = List.of("PushUser123", "PushUser456");
        pushManager.sendBulkNotification("Bulk Push: This is a notification!", pushRecipients);
    }
}
