#include <iostream>
#include <vector>
#include <string>
#include <cmath>    // Para a função pow()
#include <cstdio>   // Para a função printf()

using namespace std;

class Investimento {
protected:
    string nome;
    double investimentoInicial;

public:
    Investimento(string n, double invInicial) : nome(n), investimentoInicial(invInicial) {}

    virtual ~Investimento() {}

    string getNome() const {
        return nome;
    }

    virtual double retorno() = 0;
};

class Acoes : public Investimento {
private:
    double taxaVariacao;

public:
    Acoes(string n, double invInicial, double taxa) 
        : Investimento(n, invInicial), taxaVariacao(taxa) {}

    double retorno() override {
        return investimentoInicial * taxaVariacao;
    }
};

class RendaFixa : public Investimento {
private:
    int tempoMeses;
    double taxaMensal;

public:
    RendaFixa(string n, double invInicial, int tempo, double taxa) 
        : Investimento(n, invInicial), tempoMeses(tempo), taxaMensal(taxa) {}

    double retorno() override {
        return investimentoInicial * pow(1 + taxaMensal, tempoMeses);
    }
};

class Imovel : public Investimento {
private:
    double area;
    double taxaValorizacao;
    double aluguelMensal;
    int tempoMeses;

public:
    Imovel(string n, double invInicial, double a, double taxaVal, double aluguel, int tempo)
        : Investimento(n, invInicial), area(a), taxaValorizacao(taxaVal), aluguelMensal(aluguel), tempoMeses(tempo) {}

    double retorno() override {
        double valorFinalImovel = investimentoInicial * pow(1 + taxaValorizacao, tempoMeses);
        
        double totalAlugueis = aluguelMensal * tempoMeses;

        return (valorFinalImovel + totalAlugueis) - investimentoInicial;
    }
};

int main() {
    int n;
    if (!(cin >> n)) return 0;

    vector<Investimento*> carteira;

    for (int i = 0; i < n; i++) {
        string tipo;
        string nome;
        double valorInicial;

        cin >> tipo >> nome >> valorInicial;

        if (tipo == "Acoes") {
            double taxa;
            cin >> taxa;
            carteira.push_back(new Acoes(nome, valorInicial, taxa));
        }
        else if (tipo == "RendaFixa") {
            int tempo;
            double taxa;
            cin >> tempo >> taxa;
            carteira.push_back(new RendaFixa(nome, valorInicial, tempo, taxa));
        }
        else if (tipo == "Imovel") {
            double area, taxa, aluguel;
            int tempo;
            cin >> area >> taxa >> aluguel >> tempo;
            carteira.push_back(new Imovel(nome, valorInicial, area, taxa, aluguel, tempo));
        }
    }

    double somaTotal = 0.0;
    string nomeMaior = "";
    double maiorRetorno = -1000000000.0; 

    for (size_t i = 0; i < carteira.size(); i++) {
        double ret = carteira[i]->retorno();
        
        printf("%s %.2f\n", carteira[i]->getNome().c_str(), ret);

        somaTotal += ret;

        if (ret > maiorRetorno) {
            maiorRetorno = ret;
            nomeMaior = carteira[i]->getNome();
        }
    }

    printf("%.2f\n", somaTotal);
    
    printf("%s\n", nomeMaior.c_str());

    for (size_t i = 0; i < carteira.size(); i++) {
        delete carteira[i];
    }
    carteira.clear();

    return 0;
}