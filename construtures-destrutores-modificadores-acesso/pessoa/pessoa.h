#ifndef _PESSOA_H
#define _PESSOA_H

#include <string>
#include "endereco.h"
#include "data.h"

class Pessoa
{
private:
    std::string nome;
    std::string cpf;
    std::string email;
    Endereco endereco;
    Data data;

    int validar_cpf(std::string cpf);
    int validar_email(std::string email);

public:
    Pessoa(std::string nome, std::string cpf, std::string email, Endereco endereco, Data data);
    void set_cpf(std::string cpf);
    void set_email(std::string email);
    void print(void);
};

#endif