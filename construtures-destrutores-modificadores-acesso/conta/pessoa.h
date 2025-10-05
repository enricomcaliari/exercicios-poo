#ifndef _PESSOA_H
#define _PESSOA_H

#include <string>

class Pessoa
{
public:
    std::string nome;
    std::string cpf;

    Pessoa(std::string nome, std::string cpf);
    void print(void);
};

#endif