#include <iostream>
#include "pessoa.h"

int main()
{
    int dia, mes, ano;
    std::cin >> dia >> mes >> ano;

    Data data(dia, mes, ano);

    std::string rua, numero, bairro, cidade, pais, nome, cpf, email;
    std::cin >> rua >> numero >> bairro >> cidade >> pais;
    std::cin >> nome >> cpf >> email;

    Endereco endereco(rua, numero, bairro, cidade, pais);
    Pessoa pessoa(nome, cpf, email, endereco, data);

    int n;
    std::cin >> n;

    std::string menu, valor;
    for (int i = 0; i < n; i++)
    {
        std::cin >> menu;
        std::cin >> valor;

        if (menu == "CPF")
        {
            pessoa.set_cpf(valor);
        }
        else if (menu == "EMAIL")
        {
            pessoa.set_email(valor);
        }
    }

    pessoa.print();

    return 0;
}