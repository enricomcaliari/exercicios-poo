#include <iostream>
#include "pessoa.h"

Pessoa::Pessoa(std::string nome, std::string cpf) : nome(nome), cpf(cpf) {}

void Pessoa::print(void)
{
    std::cout << "Pessoa(" << this->nome << ", " << this->cpf << ")";
}