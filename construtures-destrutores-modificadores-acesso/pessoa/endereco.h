#ifndef _ENDERECO_H
#define _ENDERECO_H

#include <string>

class Endereco
{
private:
    std::string rua;
    std::string numero;
    std::string bairro;
    std::string cidade;
    std::string pais;

public:
    Endereco(std::string rua, std::string numero, std::string bairro, std::string cidade, std::string pais);
    void print(void);
};

#endif