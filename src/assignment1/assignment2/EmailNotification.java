package assignment1.assignment2;

public class EmailNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}
