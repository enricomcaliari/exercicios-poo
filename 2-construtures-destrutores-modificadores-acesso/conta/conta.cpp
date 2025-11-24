#include <iostream>
#include <iomanip>
#include "conta.h"

Conta::Conta(std::string numero, Pessoa titular) : numero(numero), titular(titular), saldo(0) {}

void Conta::deposito(float valor)
{
    if (valor <= 0)
    {
        std::cout << "VALOR INVALIDO" << std::endl;
    }
    else
    {
        this->saldo += valor;
    }
}

void Conta::saque(float valor)
{
    if (valor <= 0)
    {
        std::cout << "VALOR INVALIDO" << std::endl;
        return;
    }
    
    if (valor > this->saldo)
    {
        std::cout << "SALDO INSUFICIENTE" << std::endl;
    }
    else
    {
        this->saldo -= valor;
    }
}

float Conta::getSaldo(void)
{
    return this->saldo;
}

void Conta::print(void)
{
    std::cout << "Conta(" << this->numero << ", ";
    std::cout << std::fixed << std::setprecision(2) << this->saldo;
    std::cout << ", ";
    this->titular.print();
    std::cout << ")" << std::endl;
}