#ifndef _MYSTRING_H_
#define _MYSTRING_H_

#include <cstring> // Para strlen, strcpy, strcat
#include <cstdio>  // Para printf (usado no main)

class String {
private:
    char* _data;
    int _tam;

public:
    /**
     * Construtor default: inicializa _data como uma string vazia e _tam com 0.
     */
    String() {
        _tam = 0;
        _data = new char[1]; // Aloca espaço para o caractere nulo
        _data[0] = '\0';
    }

    /**
     * Construtor parametrizado: recebe um argumento do tipo const char* * e armazena uma cópia em _data.
     */
    String(const char* s) {
        if (s) {
            _tam = strlen(s);
            _data = new char[_tam + 1]; // +1 para o caractere nulo
            strcpy(_data, s);
        } else {
            // Se s for nulo, trata como o construtor padrão
            _tam = 0;
            _data = new char[1];
            _data[0] = '\0';
        }
    }

    /**
     * Construtor de cópia: cria uma nova cópia (deep copy) do objeto.
     */
    String(const String& other) {
        _tam = other._tam;
        _data = new char[_tam + 1];
        strcpy(_data, other._data);
    }

    /**
     * Destrutor: libera a memória alocada dinamicamente por _data.
     * Essencial para evitar vazamento de memória.
     */
    ~String() {
        delete[] _data;
    }

    /**
     * operator= (Atribuição): substitui o conteúdo atual pelo de 'other'.
     */
    String& operator=(const String& other) {
        // 1. Verifica se há auto-atribuição (ex: s = s)
        if (this == &other) {
            return *this;
        }

        // 2. Desaloca a memória antiga
        delete[] _data;

        // 3. Aloca nova memória e copia o conteúdo (como o construtor de cópia)
        _tam = other._tam;
        _data = new char[_tam + 1];
        strcpy(_data, other._data);

        // 4. Retorna *this para permitir atribuições em cadeia (ex: x = y = z)
        return *this;
    }

    /**
     * operator+ (Concatenação): cria um novo objeto String 
     * que é a concatenação de this + other.
     */
    String operator+(const String& other) {
        // Cria um novo objeto String (o construtor padrão aloca '\0')
        String newString;
        
        // Libera a memória alocada pelo construtor padrão
        delete[] newString._data; 

        // Calcula o novo tamanho e aloca a memória necessária
        newString._tam = this->_tam + other._tam;
        newString._data = new char[newString._tam + 1];

        // Copia a primeira string
        strcpy(newString._data, this->_data);
        
        // Concatena a segunda string
        strcat(newString._data, other._data);

        return newString;
    }

    /**
     * c_str(): retorna o ponteiro _data (string estilo C).
     * É 'const' para que possa ser chamado em objetos constantes.
     */
    const char* c_str() const {
        return _data;
    }
};

#endif // _MYSTRING_H_