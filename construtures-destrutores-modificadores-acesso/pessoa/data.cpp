#include <iostream>
#include "data.h"

Data::Data(int dia, int mes, int ano)
{
    this->dia = dia;
    this->mes = mes;
    this->ano = ano;
}

void Data::print(void)
{
    std::cout << "Data(" << this->dia << ", " << this->mes << ", " << this->ano << ")";
}