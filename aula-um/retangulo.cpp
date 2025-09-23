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

    printf("Digite a largura em cm: ");
    scanf("%f", &r.largura);
    printf("Digite a altura em cm: ");
    scanf("%f", &r.altura);

    printf("Area: %.2f cm quadrados\n", r.area());
    printf("Perimetro: %.2f cm\n", r.perimetro());

    return 0;
}