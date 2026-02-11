import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
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

        // --- 3. Cadastro de Funcionarios ---
        String tipoFuncionario;
        n = sc.nextInt();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        List<Farmaceutico> farmaceuticos = new ArrayList<>();
        List<TecnicoAdmnistrativo> tecnicos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tipoFuncionario = sc.next();
            nome = sc.next();
            int cpf = sc.nextInt();

            if (tipoFuncionario.equals("MEDICO")) {
                int consultorio = sc.nextInt();
                String formacao = sc.next();
                Medico m = new Medico(nome, cpf, consultorio, formacao);
                funcionarios.add(m);
                medicos.add(m);
            } else if (tipoFuncionario.equals("ENFERMEIRO")) {
                Enfermeiro e = new Enfermeiro(nome, cpf);
                funcionarios.add(e);
                enfermeiros.add(e);
            } else if (tipoFuncionario.equals("FARMACEUTICO")) {
                int tempoCasa = sc.nextInt();
                Farmaceutico f = new Farmaceutico(nome, cpf, tempoCasa);
                funcionarios.add(f);
                farmaceuticos.add(f);
            } else {
                int tempoCasa = sc.nextInt();
                TecnicoAdmnistrativo t = new TecnicoAdmnistrativo(nome, cpf, tempoCasa);
                funcionarios.add(t);
                tecnicos.add(t);
            }
        }
        int nMedicos = medicos.size();

        // --- 4. Cadastro de Pacientes ---
        n = sc.nextInt();
        List<Paciente> pacientes = new ArrayList<>();

        int contSus = 0;
        int contParticipativo = 0;

        for (int i = 0; i < n; i++) {
            nome = sc.next();
            int cpf = sc.nextInt();

            String tipoProvedor = sc.next();
            String enfermeiroResponsavel = sc.next();
            String gravidade = sc.next();
            String tipoPagamento = sc.next();

            int autorizado = 1;

            if (tipoProvedor.equals("SUS")) {
                contSus++;
                if (contSus > 3 && !gravidade.equals("GRAVE")) {
                    autorizado = 0;
                }
            } else if (tipoProvedor.equals("PARTICIPATIVO")) {
                contParticipativo++;
                if (contParticipativo % 2 == 0) {
                    autorizado = 0;
                }
            } else if (tipoProvedor.equals("PREMIUM")) {
                autorizado = 1;
            }

            if (autorizado == 0) {
                System.out.println("Autorizacao negada para " + nome);
                continue;
            }

            ProvedorDeSaude provedor = null;
            if (tipoProvedor.equals("SUS")) {
                provedor = new SUS();
            } else if (tipoProvedor.equals("PARTICIPATIVO"))
                provedor = new PlanoParticipativo();
            else if (tipoProvedor.equals("PREMIUM"))
                provedor = new PlanoPremium();

            Enfermeiro enfermeiroPaciente = null;
            for (Enfermeiro e : enfermeiros) {
                if (e.getNome().equals(enfermeiroResponsavel)) {
                    enfermeiroPaciente = e;
                    break;
                }
            }
            if (enfermeiroPaciente != null) {
                enfermeiroPaciente.atualizaPagamento();
            }

            MetodoPagamento metodoPagamento = null;
            if (tipoPagamento.equals("CREDITO")) {
                metodoPagamento = new Credito();
            } else if (tipoPagamento.equals("PIX")) {
                metodoPagamento = new Pix();
            } else if (tipoPagamento.equals("DEBITO")) {
                metodoPagamento = new Debito();
            } else {
                metodoPagamento = new Carne();
            }

            int senha = pacientes.size() + 1;
            pacientes.add(new Paciente(nome, cpf, senha, provedor, enfermeiroPaciente, gravidade, metodoPagamento));
        }
        int nPacientes = pacientes.size();

        // --- 5. Realização dos Atendimentos ---
        List<Atendimento> atendimentos = new ArrayList<>();
        int medicoAtendimento = 0;

        for (int i = 0; i < nPacientes; i++) {
            Medico medicoResponsavel = medicos.get(medicoAtendimento);
            medicoAtendimento++;
            if (medicoAtendimento == nMedicos)
                medicoAtendimento = 0;

            medicoResponsavel.atualizaPagamento();

            String sintomas = sc.next();

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

            String nomeFarmaceutico = sc.next();
            Farmaceutico farmaceuticoResponsavel = null;
            for (Farmaceutico f : farmaceuticos) {
                if (f.getNome().equals(nomeFarmaceutico)) {
                    farmaceuticoResponsavel = f;
                    break;
                }
            }
            if (farmaceuticoResponsavel != null) {
                farmaceuticoResponsavel.atualizaPagamento();
            }

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

            Atendimento a = new Atendimento(medicoResponsavel, farmaceuticoResponsavel,
                    pacientes.get(i).getEnfermeiroResponsavel(), pacientes.get(i), sintomas,
                    examesAtendimento, cid, prescricoes);
            atendimentos.add(a);
        }

        // --- 6. Auditoria e Cálculo Financeiro ---

        double totalRecebidoHospital = 0;
        double totalGastoHospital = 0;

        for (Atendimento a : atendimentos) {
            double custoBaseProntuario = a.getMedico().getValorConsulta() + 20;

            for (Exame e : a.getExames()) {
                custoBaseProntuario += e.getCusto();
                totalGastoHospital += e.getCusto();
            }

            for (Prescricao p : a.getPrescricoes()) {
                double custoRemedio = p.getMedicacao().getCusto() * p.getDoses();
                custoBaseProntuario += custoRemedio;
                totalGastoHospital += custoRemedio;
            }

            double valorHospitalRecebe = a.getPaciente().getProvedor().calculaPagamentoHospital(custoBaseProntuario);
            double valorPacientePaga = a.getPaciente().getProvedor().calculaPagamentoPaciente(custoBaseProntuario,
                    a.getPaciente().getMetodoPagamento());

            totalRecebidoHospital += valorHospitalRecebe;

            // --- Impressão Auditoria ---
            System.out.println(a.getPaciente().getNome() + " fez triagem com " + a.getEnfermeiro().getNome());
            System.out.println(a.getPaciente().getNome() + " foi atendido por " + a.getMedico().getNome()
                    + " no consultorio " + a.getMedico().getConsultorio());

            for (Exame e : a.getExames()) {
                System.out.println(a.getPaciente().getNome() + " realizou " + e.getNome());
            }

            System.out.println("Diagnostico: " + a.getCid());

            for (Prescricao p : a.getPrescricoes()) {
                System.out.println(a.getFarmaceutico().getNome() + " liberou " + p.getDoses() + " doses de "
                        + p.getMedicacao().getNome());
                System.out.println(a.getEnfermeiro().getNome() + " aplicou " + p.getDoses() + " doses de "
                        + p.getMedicacao().getNome() + " em " + a.getPaciente().getNome());
            }

            System.out.printf("%s pagou %.2f%n", a.getPaciente().getNome(), valorPacientePaga);
            System.out.printf("Hospital recebeu %.2f%n", valorHospitalRecebe);
            System.out.println(a.getPaciente().getNome() + " recebeu alta");
        }

        for (Funcionario f : funcionarios) {
            totalGastoHospital += f.getPagamento();
            System.out.printf("%s: %.2f%n", f.getNome(), f.getPagamento());
        }

        System.out.printf("VALORES RECEBIDOS: %.2f%n", totalRecebidoHospital);
        System.out.printf("VALORES GASTOS: %.2f%n", totalGastoHospital);

        sc.close();
    }
}