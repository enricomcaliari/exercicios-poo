#include <iostream>
#include <vector>
#include <string>
#include <cstdio>

using namespace std;

class Funcionario {
protected:
    string nome;

public:
    Funcionario(string n) : nome(n) {}
    
    virtual ~Funcionario() {}

    string getNome() const {
        return nome;
    }

    virtual double salario() = 0;
};

class Freelancer : public Funcionario {
private:
    double horasTrabalhadas;
    double valorPorHora;

public:
    Freelancer(string n, double horas, double valor) 
        : Funcionario(n), horasTrabalhadas(horas), valorPorHora(valor) {}

    double salario() override {
        return horasTrabalhadas * valorPorHora;
    }
};

class FuncionarioContratado : public Funcionario {
protected:
    double salarioBase;

    virtual double descontos() = 0;
    virtual double bonus() = 0;

public:
    FuncionarioContratado(string n, double base) 
        : Funcionario(n), salarioBase(base) {}

    double salario() override {
        return salarioBase + bonus() - descontos();
    }
};

class CLT : public FuncionarioContratado {
private:
    double ticketAlimentacao;
    double percDescontoFGTS;
    double percDescontoIRRF;

public:
    CLT(string n, double base, double ticket, double fgts, double irrf)
        : FuncionarioContratado(n, base), ticketAlimentacao(ticket), percDescontoFGTS(fgts), percDescontoIRRF(irrf) {}

protected:
    double descontos() override {
        return salarioBase * (percDescontoFGTS + percDescontoIRRF);
    }

    double bonus() override {
        return ticketAlimentacao;
    }
};

class Estagiario : public FuncionarioContratado {
private:
    double auxilioTransporte;

public:
    Estagiario(string n, double base, double auxilio)
        : FuncionarioContratado(n, base), auxilioTransporte(auxilio) {}

protected:
    double descontos() override {
        return 0.0;
    }

    double bonus() override {
        return auxilioTransporte;
    }
};

class Vendedor : public FuncionarioContratado {
private:
    double comissao;
    bool bateuMeta;

public:
    Vendedor(string n, double base, double comissao, bool meta)
        : FuncionarioContratado(n, base), comissao(comissao), bateuMeta(meta) {}

protected:
    double descontos() override {
        if (!bateuMeta) {
            return salarioBase * 0.10;
        }
        return 0.0;
    }

    double bonus() override {
        if (bateuMeta) {
            return comissao + (salarioBase * 0.25);
        }
        return 0.0;
    }
};

int main() {
    int n;
    if (!(cin >> n)) return 0;

    vector<Funcionario*> listaFuncionarios;

    for (int i = 0; i < n; i++) {
        string tipo;
        string nome;
        cin >> tipo >> nome;

        if (tipo == "Freelancer") {
            double horas, valor;
            cin >> horas >> valor;
            listaFuncionarios.push_back(new Freelancer(nome, horas, valor));
        }
        else if (tipo == "CLT") {
            double base, ticket, fgts, irrf;
            cin >> base >> ticket >> fgts >> irrf;
            listaFuncionarios.push_back(new CLT(nome, base, ticket, fgts, irrf));
        }
        else if (tipo == "Estagiario") {
            double base, auxilio;
            cin >> base >> auxilio;
            listaFuncionarios.push_back(new Estagiario(nome, base, auxilio));
        }
        else if (tipo == "Vendedor") {
            double base, comissao;
            int metaInt;
            cin >> base >> comissao >> metaInt;
            listaFuncionarios.push_back(new Vendedor(nome, base, comissao, (metaInt != 0)));
        }
    }

    double maiorSalario = -1.0;
    double menorSalario = 1000000000.0;
    double totalGasto = 0.0;
    
    Funcionario* funcMaior = nullptr;
    Funcionario* funcMenor = nullptr;

    for (size_t i = 0; i < listaFuncionarios.size(); i++) {
        Funcionario* f = listaFuncionarios[i];
        double sal = f->salario();
        
        printf("%s %.2f\n", f->getNome().c_str(), sal);

        totalGasto += sal;

        if (sal > maiorSalario) {
            maiorSalario = sal;
            funcMaior = f;
        }
        
        if (sal < menorSalario) {
            menorSalario = sal;
            funcMenor = f;
        }
    }

    if (funcMaior != nullptr) {
        printf("%s %.2f\n", funcMaior->getNome().c_str(), maiorSalario);
    }

    if (funcMenor != nullptr) {
        printf("%s %.2f\n", funcMenor->getNome().c_str(), menorSalario);
    }

    printf("%.2f\n", totalGasto);

    for (size_t i = 0; i < listaFuncionarios.size(); i++) {
        delete listaFuncionarios[i];
    }
    listaFuncionarios.clear();

    return 0;
}