#include <stdio.h>

class Retangulo
{
public:
    float largura, altura;

    float area()
    {
        return this->altura * this->largura;
    }

    float perimetro()
    {
        return (2 * this->largura) + (2 * this->altura);
    }
};

int main()
{
    Retangulo r;

    scanf("%f %f", &r.largura, &r.altura);

    printf("%.0f %.0f\n", r.area(), r.perimetro());

    return 0;
}