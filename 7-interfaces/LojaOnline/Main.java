import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNext()) {
            sc.close();
            return;
        }

        // Leitura do Cliente
        String nome = sc.next();
        String email = sc.next();
        String telefone = sc.next();
        double distancia = sc.nextDouble();

        Cliente cliente = new Cliente(nome, email, telefone, distancia);

        // Leitura do Carrinho
        int qtdItens = sc.nextInt();
        Carrinho carrinho = new Carrinho();

        for (int i = 0; i < qtdItens; i++) {
            String nomeProd = sc.next();
            double precoProd = sc.nextDouble();
            carrinho.add(new Produto(nomeProd, precoProd));
        }

        // Configuração da Compra
        Compra compra = new Compra(cliente, carrinho);

        // Configuração da Entrega
        String tipoEntrega = sc.next();
        switch (tipoEntrega) {
            case "PAC":
                compra.setEntrega(new Pac());
                break;
            case "SEDEX":
                compra.setEntrega(new Sedex());
                break;
            case "SEDEX10":
                compra.setEntrega(new Sedex10());
                break;
        }

        // Configuração do Pagamento
        String tipoPagamento = sc.next();
        switch (tipoPagamento) {
            case "PIX":
                compra.setPagamento(new Pix());
                break;
            case "CARTAO":
                compra.setPagamento(new Cartao());
                break;
            case "CARNE":
                compra.setPagamento(new Carne());
                break;
        }

        // Adiciona Notificadores
        compra.addNotificador(new Email());
        compra.addNotificador(new PopUp());
        compra.addNotificador(new SMS());

        // Finaliza
        compra.finalizar();

        sc.close();
    }
}