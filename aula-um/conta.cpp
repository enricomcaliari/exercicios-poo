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
    int valor;

    printf("Conta %s\n", c.id);
    for (int i = 0; i > -1; i++)
    {
        printf("\nEscolha uma opcao abaixo:\n");
        printf("Deposito - D\n");
        printf("Saque - S\n");
        printf("Encerrar programa - E\n");

        scanf(" %c", &menu);

        if (menu == 'D' || menu == 'd')
        {
            printf("\nDigite o valor: ");
            scanf("%d", &valor);

            if (valor < 0)
            {
                printf("\nO valor deve ser positivo\n");
            }
            else
            {
                c.deposito(valor);
            }
        }

        else if (menu == 'S' || menu == 's')
        {
            printf("\nDigite o valor: ");
            scanf("%d", &valor);

            if (valor < 0)
            {
                printf("\nO valor deve ser positivo\n");
            }
            else if (valor > c.saldo)
            {
                printf("\nSaldo insuficiente\n");
            }
            else
            {
                c.saque(valor);
            }
        }

        else
        {
            break;
        }

        printf("\nSaldo: R$ %.2f\n", c.saldo);
    }

    return 0;
}