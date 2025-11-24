#include <cstdio>
#include <cstdlib>

class Eleicao
{
private:
    int numCandidatos;
    int *votos;

public:
    Eleicao(int numCandidatos)
    {
        this->numCandidatos = numCandidatos;
        this->votos = (int *)malloc(numCandidatos * sizeof(int));
        for (int i = 0; i < numCandidatos; i++)
        {
            this->votos[i] = 0;
        }
    }

    ~Eleicao()
    {
        free(this->votos);
    }

    void votar(int candidato, int quantidade)
    {
        this->votos[candidato] += quantidade;
    }

    int vencedor()
    {
        int vencedor = 0;
        int maxVotos = 0;

        for (int i = 0; i < this->numCandidatos; i++)
        {
            if (this->votos[i] > maxVotos)
            {
                maxVotos = this->votos[i];
                vencedor = i;
            }
        }

        return vencedor;
    }

    int totalVotos()
    {
        int totalVotos = 0;

        for (int i = 0; i < this->numCandidatos; i++)
        {
            totalVotos += this->votos[i];
        }

        return totalVotos;
    }
};

int main()
{
    int numCandidatos;
    scanf("%d", &numCandidatos);

    Eleicao eleicao(numCandidatos);

    int nVotos;
    scanf("%d", &nVotos);

    int candidato, quantidade;
    for (int i = 0; i < nVotos; i++)
    {
        scanf("%d %d", &candidato, &quantidade);
        eleicao.votar(candidato, quantidade);
    }

    printf("%d\n%d\n", eleicao.vencedor(), eleicao.totalVotos());

    return 0;
}