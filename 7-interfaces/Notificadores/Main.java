import java.util.*;

public class Main {
    public static void main(String[] args) {
        NotifierSMS notiSms = new NotifierSMS();
        NotifierEmail notiEmail = new NotifierEmail();
        NotifierPopUp notiPopup = new NotifierPopUp();
        NotifierAplicativo notiApp = new NotifierAplicativo();

        ArrayList<Notifier> notifiers = new ArrayList<>();
        notifiers.add(notiSms);
        notifiers.add(notiEmail);
        notifiers.add(notiPopup);
        notifiers.add(notiApp);

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String email = sc.nextLine();
        String phone = sc.nextLine();
        String message = sc.nextLine();

        User user = new User(name, email, phone);

        for (Notifier n : notifiers) {
            n.notify(user, message);
        }

        sc.close();
    }
}
