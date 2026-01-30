import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Investimento> carteira = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String tipo = sc.next();
            String nome = sc.next();
            double valorInicial = sc.nextDouble();

            switch (tipo) {
                case "Acoes":
                    double taxaAcoes = sc.nextDouble();
                    carteira.add(new Acoes(nome, valorInicial, taxaAcoes));
                    break;

                case "RendaFixa":
                    int tempoRF = sc.nextInt();
                    double taxaRF = sc.nextDouble();
                    carteira.add(new RendaFixa(nome, valorInicial, tempoRF, taxaRF));
                    break;

                case "Imovel":
                    double area = sc.nextDouble();
                    double taxaImovel = sc.nextDouble();
                    double aluguel = sc.nextDouble();
                    int tempoImovel = sc.nextInt();
                    carteira.add(new Imovel(nome, valorInicial, area, taxaImovel, aluguel, tempoImovel));
                    break;
            }
        }

        double somaTotal = 0;
        String nomeMaiorRetorno = "";
        double maiorRetornoValor = -999999999;

        for (Investimento inv : carteira) {
            double ret = inv.retorno();
            
            System.out.printf("%s %.2f%n", inv.getNome(), ret);

            somaTotal += ret;

            if (ret > maiorRetornoValor) {
                maiorRetornoValor = ret;
                nomeMaiorRetorno = inv.getNome();
            }
        }

        System.out.printf("%.2f%n", somaTotal);

        System.out.println(nomeMaiorRetorno);

        sc.close();
    }
}