public class NotifierAplicativo implements Notifier {
    public NotifierAplicativo() {
    };

    public void notify(User user, String message) {
        System.out.printf("enviando notificação no aplicativo instalado em %s: '%s'.\n", user.getPhone(), message);
    }
}
