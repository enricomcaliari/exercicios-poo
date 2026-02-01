public class NotifierPopUp implements Notifier {
    public NotifierPopUp() {
    };

    public void notify(User user, String message) {
        System.out.printf("enviando pop-up para %s: '%s'.\n", user.getPhone(), message);
    }
}
