import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        if (!sc.hasNext()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String tipo = sc.next();
            String nome = sc.next();

            switch (tipo) {
                case "ProdutoEmpacotado":
                    int qC = sc.nextInt();
                    int qV = sc.nextInt();
                    double pC = sc.nextDouble();
                    double pV = sc.nextDouble();
                    listaProdutos.add(new ProdutoEmpacotado(nome, qC, qV, pC, pV));
                    break;

                case "ProdutoPorPeso":
                    double kgC = sc.nextDouble();
                    double kgV = sc.nextDouble();
                    double pkgC = sc.nextDouble();
                    double pkgV = sc.nextDouble();
                    listaProdutos.add(new ProdutoPorPeso(nome, kgC, kgV, pkgC, pkgV));
                    break;

                case "CarneAcougue":
                    double cKgC = sc.nextDouble();
                    double cKgV = sc.nextDouble();
                    double cPkgC = sc.nextDouble();
                    double cPkgV = sc.nextDouble();
                    double custAc = sc.nextDouble();
                    listaProdutos.add(new CarneAcougue(nome, cKgC, cKgV, cPkgC, cPkgV, custAc));
                    break;

                case "ProdutoProcessadoKg":
                    double ppkQtd = sc.nextDouble();
                    double ppkMat = sc.nextDouble();
                    double ppkFunc = sc.nextDouble();
                    double ppkPreco = sc.nextDouble();
                    double ppkVend = sc.nextDouble();
                    listaProdutos.add(new ProdutoProcessadoKg(nome, ppkQtd, ppkMat, ppkFunc, ppkPreco, ppkVend));
                    break;

                case "ProdutoProcessadoUnidade":
                    double ppuQtd = sc.nextDouble();
                    double ppuMat = sc.nextDouble();
                    double ppuFunc = sc.nextDouble();
                    double ppuPreco = sc.nextDouble();
                    int ppuVend = sc.nextInt();
                    listaProdutos.add(new ProdutoProcessadoUnidade(nome, ppuQtd, ppuMat, ppuFunc, ppuPreco, ppuVend));
                    break;
            }
        }

        double totalReceita = 0;
        double totalCusto = 0;
        double totalLucro = 0;

        Produto maiorReceita = null;
        Produto maisCustoso = null;
        Produto maisLucrativo = null;
        Produto menosLucrativo = null;

        for (Produto p : listaProdutos) {
            double rec = p.entrada();
            double cus = p.custo();
            double luc = p.lucro();

            System.out.printf("%s: Receita=%.2f, Custo=%.2f, Lucro=%.2f%n",
                    p.getNome(), rec, cus, luc);

            totalReceita += rec;
            totalCusto += cus;
            totalLucro += luc;

            if (maiorReceita == null || rec > maiorReceita.entrada())
                maiorReceita = p;
            if (maisCustoso == null || cus > maisCustoso.custo())
                maisCustoso = p;
            if (maisLucrativo == null || luc > maisLucrativo.lucro())
                maisLucrativo = p;
            if (menosLucrativo == null || luc < menosLucrativo.lucro())
                menosLucrativo = p;
        }

        System.out.printf("Receita Total: %.2f%n", totalReceita);
        System.out.printf("Custo Total: %.2f%n", totalCusto);
        System.out.printf("Lucro Total: %.2f%n", totalLucro);

        if (maiorReceita != null) {
            System.out.printf("maior receita: %s (%.2f)%n", maiorReceita.getNome(), maiorReceita.entrada());
            System.out.printf("mais custoso: %s (%.2f)%n", maisCustoso.getNome(), maisCustoso.custo());
            System.out.printf("mais lucrativo: %s (%.2f)%n", maisLucrativo.getNome(), maisLucrativo.lucro());
            System.out.printf("menos lucrativo: %s (%.2f)%n", menosLucrativo.getNome(), menosLucrativo.lucro());
        }

        sc.close();
    }
}