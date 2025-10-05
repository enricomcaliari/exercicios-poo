#ifndef _CONTA_H
#define _CONTA_H

#include <string>
#include "pessoa.h"

class Conta
{
private:
    std::string numero;
    Pessoa titular;
    float saldo;

public:
    Conta(std::string numero, Pessoa titular);
    void deposito(float valor);
    void saque(float valor);
    float getSaldo(void);
    void print(void);
};

#endif