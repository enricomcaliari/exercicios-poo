import java.util.List;

public class Atendimento {
    private Medico medico;
    private Paciente paciente;
    private String sintomas;
    private List<Exame> exames;
    private String cid;
    private List<Prescricao> prescricoes;

    public Atendimento(Medico medico, Paciente paciente, String sintomas, List<Exame> exames, String cid,
            List<Prescricao> prescricoes) {
        this.medico = medico;
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.exames = exames;
        this.cid = cid;
        this.prescricoes = prescricoes;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public String getCid() {
        return cid;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }
}