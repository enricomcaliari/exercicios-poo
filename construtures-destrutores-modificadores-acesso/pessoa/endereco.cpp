#include <iostream>
#include "endereco.h"

Endereco::Endereco(std::string rua, std::string numero, std::string bairro, std::string cidade, std::string pais)
{
    this->rua = rua;
    this->numero = numero;
    this->bairro = bairro;
    this->cidade = cidade;
    this->pais = pais;
}

void Endereco::print(void)
{
    std::cout << "Endereco(" << this->rua << ", " << this->numero << ", " << this->bairro << ", " << this->cidade << ", " << this->pais << ")";
}