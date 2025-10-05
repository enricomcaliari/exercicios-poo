#include <iostream>
#include "pessoa.h"

int Pessoa::validar_cpf(std::string cpf)
{
    for (char c : cpf)
    {
        if (!(c >= '0' && c <= '9'))
        {
            return 0;
        }
    }
    return 1;
}

int Pessoa::validar_email(std::string email)
{
    int arroba = email.find("@") != std::string::npos;
    int pontocom = email.find(".com") != std::string::npos;

    return arroba && pontocom;
}

Pessoa::Pessoa(std::string nome, std::string cpf, std::string email, Endereco endereco, Data data)
    : nome(nome),
      cpf(validar_cpf(cpf) ? cpf : "N/A"),
      email(validar_email(email) ? email : "N/A"),
      endereco(endereco),
      data(data) {}

void Pessoa::set_cpf(std::string cpf)
{
    if (validar_cpf(cpf))
    {
        this->cpf = cpf;
    }
    else
    {
        std::cout << "CPF INVALIDO" << std::endl;
    }
}

void Pessoa::set_email(std::string email)
{
    if (validar_email(email))
    {
        this->email = email;
    }
    else
    {
        std::cout << "EMAIL INVALIDO" << std::endl;
    }
}

void Pessoa::print(void)
{
    std::cout << "Pessoa(" << this->nome << ", " << this->cpf << ", " << this->email << ", ";
    this->endereco.print();
    std::cout << ", ";
    this->data.print();
    std::cout << ")" << std::endl;
}