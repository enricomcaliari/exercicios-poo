#include <stdio.h>
#include <string.h>

class Pessoa
{
public:
    char nome[32];
    int anoNascimento;

    int idade(int anoAtual)
    {
        if (anoAtual <= 0 || anoAtual < this->anoNascimento)
        {
            printf("VALOR INVALIDO\n");
            return -1;
        }

        return anoAtual - this->anoNascimento;
    }
};

int main()
{
    Pessoa p;
    int anoAtual;

    scanf("%s %d", p.nome, &p.anoNascimento);
    scanf("%d", &anoAtual);

    printf("%d\n", p.idade(anoAtual));

    return 0;
}