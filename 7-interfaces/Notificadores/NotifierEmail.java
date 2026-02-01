public class NotifierEmail implements Notifier {
    public NotifierEmail() {
    };

    public void notify(User user, String message) {
        System.out.printf("enviando e-mail para %s: '%s'.\n", user.getEmail(), message);
    }
}
