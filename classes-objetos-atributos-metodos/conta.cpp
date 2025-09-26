#include <stdio.h>
#include <string.h>

class Conta
{
public:
    char id[12];
    float saldo;

    void deposito(float valor)
    {
        this->saldo += valor;
    }

    void saque(float valor)
    {
        this->saldo -= valor;
    }
};

int main()
{
    Conta c;
    stpcpy(c.id, "123456789");
    c.saldo = 0;

    char menu;
    int numTransacoes, valor;

    scanf("%d", &numTransacoes);

    for (int i = 0; i < numTransacoes; i++)
    {
        scanf(" %c", &menu);

        if (menu == 'D')
        {
            scanf("%d", &valor);

            if (valor <= 0)
            {
                printf("VALOR INVALIDO\n");
            }
            else
            {
                c.deposito(valor);
            }
        }

        else if (menu == 'S')
        {
            scanf("%d", &valor);

            if (valor <= 0)
            {
                printf("VALOR INVALIDO\n");
            }
            else if (valor > c.saldo)
            {
                printf("SALDO INSUFICIENTE\n");
            }
            else
            {
                c.saque(valor);
            }
        }

        printf("%.0f\n", c.saldo);
    }

    return 0;
}