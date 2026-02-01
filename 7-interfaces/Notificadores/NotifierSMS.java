public class NotifierSMS implements Notifier {
    public void notify(User user, String message) {
        System.out.printf("enviando SMS para %s: '%s'.\n", user.getPhone(), message);
    }
}
