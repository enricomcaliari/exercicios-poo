import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        String nome;
        double custo;

        // --- 1. Cadastro de Medicações ---
        n = sc.nextInt();
        List<Medicacao> medicacoes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nome = sc.next();
            custo = sc.nextDouble();
            medicacoes.add(new Medicacao(nome, custo));
        }

        // --- 2. Cadastro de Exames ---
        n = sc.nextInt();
        List<Exame> exames = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nome = sc.next();
            custo = sc.nextDouble();
            exames.add(new Exame(nome, custo));
        }

        // --- 3. Cadastro de Médicos ---
        n = sc.nextInt();
        List<Medico> medicos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nome = sc.next();
            int cpf = sc.nextInt();
            int consultorio = sc.nextInt();
            medicos.add(new Medico(nome, cpf, consultorio));
        }
        int nMedicos = medicos.size();

        // --- 4. Cadastro de Pacientes ---
        n = sc.nextInt();
        List<Paciente> pacientes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nome = sc.next();
            int cpf = sc.nextInt();
            int senha = i + 1;
            pacientes.add(new Paciente(nome, cpf, senha));
        }
        int nPacientes = pacientes.size();

        // --- 5. Realização dos Atendimentos ---
        List<Atendimento> atendimentos = new ArrayList<>();
        int medicoAtendimento = 0;

        for (int i = 0; i < nPacientes; i++) {
            String sintomas = sc.next();

            // Leitura dos Exames
            int qtdExames = sc.nextInt();
            List<Exame> examesAtendimento = new ArrayList<>();

            for (int j = 0; j < qtdExames; j++) {
                String nomeExame = sc.next();
                for (Exame ex : exames) {
                    if (ex.getNome().equals(nomeExame)) {
                        examesAtendimento.add(ex);
                        break;
                    }
                }
            }

            String cid = sc.next();

            // Leitura das Medicações
            int qtdMedicacoes = sc.nextInt();
            List<Prescricao> prescricoes = new ArrayList<>();

            for (int j = 0; j < qtdMedicacoes; j++) {
                String nomeMedicacao = sc.next();
                int doses = sc.nextInt();
                for (Medicacao m : medicacoes) {
                    if (m.getNome().equals(nomeMedicacao)) {
                        prescricoes.add(new Prescricao(m, doses));
                        break;
                    }
                }
            }

            Medico medicoResponsavel = medicos.get(medicoAtendimento);
            medicoAtendimento++;
            if (medicoAtendimento == nMedicos) {
                medicoAtendimento = 0;
            }

            Atendimento a = new Atendimento(medicoResponsavel, pacientes.get(i), sintomas,
                    examesAtendimento, cid, prescricoes);
            atendimentos.add(a);
        }

        Hospital hospital = new Hospital();

        // --- 6. Saída: Auditoria e Cálculo de Custos ---

        for (Atendimento a : atendimentos) {
            a.getMedico().atualizaPagamento(100);
            hospital.atualizaCustoTotal(100);

            // Linha do Médico
            System.out.println(a.getPaciente().getNome() + " foi atendido por " + a.getMedico().getNome()
                    + " no consultorio " + a.getMedico().getConsultorio());

            // Linhas dos Exames
            for (Exame e : a.getExames()) {
                System.out.println(a.getPaciente().getNome() + " realizou " + e.getNome());
                hospital.atualizaCustoTotal(e.getCusto());
            }

            // Linha do Diagnóstico
            System.out.println("Diagnostico: " + a.getCid());

            // Linhas das Medicações
            for (Prescricao p : a.getPrescricoes()) {
                System.out.println(a.getPaciente().getNome() + " recebeu " + p.getDoses() + " doses de "
                        + p.getMedicacao().getNome());
                double custoRemedio = p.getMedicacao().getCusto() * p.getDoses();
                hospital.atualizaCustoTotal(custoRemedio);
            }

            // Linha de Alta
            System.out.println(a.getPaciente().getNome() + " recebeu alta");
        }

        // --- 7. Saída: Relatório Financeiro ---

        for (Medico m : medicos) {
            // Usando printf para manter 2 casas decimais padrão (depende do sistema sem
            // Locale)
            System.out.printf("%s: %.2f%n", m.getNome(), m.getPagamento());
        }

        System.out.printf("CUSTO TOTAL: %.2f%n", hospital.getCustoTotal());

        sc.close();
    }
}