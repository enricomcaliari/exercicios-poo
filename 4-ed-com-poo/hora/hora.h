#ifndef _HORA_H_
#define _HORA_H_

#include <cstdio> // Para usar scanf (em ler) e printf (em print)

class Hora {
private:
    int hora;
    int minutos;
    int segundos;

public:
    /**
     * Construtor parametrizado com valores default.
     * Este construtor também é responsável por "normalizar" o tempo.
     * Por exemplo, Hora(0, 0, 70) será armazenado como 0h 1m 10s.
     */
    Hora(int h = 0, int m = 0, int s = 0) {
        // 1. Converte tudo para o total de segundos
        int total_segundos = h * 3600 + m * 60 + s;

        // 2. Converte de volta para horas, minutos e segundos,
        // garantindo que os valores fiquem nos seus devidos intervalos.
        this->hora = total_segundos / 3600;
        total_segundos = total_segundos % 3600;
        this->minutos = total_segundos / 60;
        this->segundos = total_segundos % 60;
    }

    /**
     * Sobrecarga do operador+ para somar dois objetos Hora.
     */
    Hora operator+(const Hora& other) {
        // Soma os componentes de cada objeto
        int h_novo = this->hora + other.hora;
        int m_novo = this->minutos + other.minutos;
        int s_novo = this->segundos + other.segundos;

        // Retorna um novo objeto Hora. O construtor cuidará da normalização.
        return Hora(h_novo, m_novo, s_novo);
    }

    /**
     * Sobrecarga do operador+ para somar um inteiro (segundos) a um objeto Hora.
     */
    Hora operator+(int s_adicionais) {
        // Soma os segundos ao horário atual
        int h_novo = this->hora;
        int m_novo = this->minutos;
        int s_novo = this->segundos + s_adicionais;

        // Deixa o construtor cuidar da normalização.
        return Hora(h_novo, m_novo, s_novo);
    }

    /**
     * Método de classe (estático) que lê os valores do teclado e
     * retorna um novo objeto Hora.
     */
    static Hora ler() {
        int h, m, s;
        scanf("%d %d %d", &h, &m, &s);
        return Hora(h, m, s);
    }

    /**
     * Imprime a hora no formato "h m s" seguido de uma nova linha.
     */
    void print() {
        printf("%d %d %d\n", this->hora, this->minutos, this->segundos);
    }
};

#endif // _HORA_H_