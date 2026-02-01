import java.util.Locale;

public class PopUp implements Notificador {
    @Override
    public void notificar(Cliente cliente, double valorFinal, int prazoDias) {
        System.out.printf(Locale.US,
                "Notificacao pop-up para %s: Compra realizada por %s no valor de %.2f e entrega em até %d dias.%n",
                cliente.getTelefone(), cliente.getNome(), valorFinal, prazoDias);
    }
}