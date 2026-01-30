import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Transporte> transportes = new ArrayList<>();

        String tipoTransporte;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tipoTransporte = sc.next();

            if (tipoTransporte.equals("Onibus")) {
                double custoBase = sc.nextDouble();
                double distanciaPercorrida = sc.nextDouble();
                double precoGasolinaPorKm = sc.nextDouble();
                int numeroPassageiros = sc.nextInt();
                double precoPassagem = sc.nextDouble();

                Onibus onibus = new Onibus(custoBase, distanciaPercorrida, precoGasolinaPorKm, numeroPassageiros,
                        precoPassagem);
                transportes.add(onibus);
            }

            else if (tipoTransporte.equals("Metro")) {
                double custoBase = sc.nextDouble();
                int numeroPassageiros = sc.nextInt();
                double receitaPorPassageiro = sc.nextDouble();

                Metro metro = new Metro(custoBase, numeroPassageiros, receitaPorPassageiro);
                transportes.add(metro);
            }

            else if (tipoTransporte.equals("Bicicleta")) {
                double custoBase = sc.nextDouble();
                int horasUtilizadas = sc.nextInt();
                double precoPorHora = sc.nextDouble();
                double custoManutencaoPorHora = sc.nextDouble();

                BicicletaCompartilhada bicicleta = new BicicletaCompartilhada(custoBase, horasUtilizadas, precoPorHora,
                        custoManutencaoPorHora);
                transportes.add(bicicleta);
            }

            else if (tipoTransporte.equals("Carro")) {
                double custoBase = sc.nextDouble();
                double taxaDesvalorizacao = sc.nextDouble();
                double distanciaPercorrida = sc.nextDouble();
                double precoGasolinaPorKm = sc.nextDouble();
                double precoManutencaoPorKm = sc.nextDouble();

                Carro carro = new Carro(custoBase, taxaDesvalorizacao, distanciaPercorrida, precoGasolinaPorKm,
                        precoManutencaoPorKm);
                transportes.add(carro);
            }
        }

        Transporte maisLucrativo = null;
        Transporte menosLucrativo = null;

        for (Transporte t : transportes) {
            double lucroAtual = t.lucratividade();

            System.out.printf("%s %.2f%n", t.nome(), lucroAtual);

            if (maisLucrativo == null || lucroAtual > maisLucrativo.lucratividade()) {
                maisLucrativo = t;
            }

            if (menosLucrativo == null || lucroAtual < menosLucrativo.lucratividade()) {
                menosLucrativo = t;
            }
        }

        if (maisLucrativo != null) {
            System.out.println(maisLucrativo.nome());
        }

        if (menosLucrativo != null) {
            System.out.println(menosLucrativo.nome());
        }

        sc.close();
    }
}
