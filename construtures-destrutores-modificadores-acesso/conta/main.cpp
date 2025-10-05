#include <iostream>
#include <string>
#include "conta.h"

int main()
{
    std::string nome, cpf, numero_conta;
    int num_operacoes;
    char operacao;
    float valor;

    std::cin >> nome >> cpf >> numero_conta;

    Pessoa titular(nome, cpf);
    Conta conta(numero_conta, titular);

    std::cin >> num_operacoes;

    for (int i = 0; i < num_operacoes; ++i)
    {
        std::cin >> operacao >> valor;
        if (operacao == 'D')
        {
            conta.deposito(valor);
        }
        else if (operacao == 'S')
        {
            conta.saque(valor);
        }
    }

    conta.print();

    return 0;
}