import java.util.Locale;

public class Email implements Notificador {
    @Override
    public void notificar(Cliente cliente, double valorFinal, int prazoDias) {
        System.out.printf(Locale.US,
                "Notificacao e-mail para %s: Compra realizada por %s no valor de %.2f e entrega em até %d dias.%n",
                cliente.getEmail(), cliente.getNome(), valorFinal, prazoDias);
    }
}