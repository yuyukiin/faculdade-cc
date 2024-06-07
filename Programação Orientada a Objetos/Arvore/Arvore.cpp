#include <iostream> // Para usar cout e endl
#include <cstdlib>  // Para usar malloc

using namespace std;

typedef struct no {
    int dado;
    struct no *esq;
    struct no *dir;
} Arvore;

Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor == raiz->dado) {
            return raiz;
        }
        if (valor < raiz->dado) {
            raiz->esq = inserir(valor, raiz->esq);
        } else {
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    } else {
        Arvore *novo = (Arvore *)malloc(sizeof(Arvore));
        novo->dado = valor;
        novo->esq = NULL; // Use nullptr em vez de NULL
        novo->dir = NULL; // Use nullptr em vez de NULL
        return novo;
    }
}

void exibirRED(Arvore *raiz) {
    if (raiz) {
        cout << raiz->dado << endl; // Exibe o nó
        exibirRED(raiz->esq);       // Exibe a subárvore esquerda
        exibirRED(raiz->dir);       // Exibe a subárvore direita
    }
}

void exibirERD(Arvore *raiz) {
    if (raiz) {
        exibirERD(raiz->esq);       // Exibe a subárvore esquerda
        cout << raiz->dado << endl; // Exibe o nó
        exibirERD(raiz->dir);       // Exibe a subárvore direita
    }
}

void exibirEDR(Arvore *raiz) {
    if (raiz) {
        exibirEDR(raiz->dir);       // Exibe a subárvore direita
        exibirEDR(raiz->esq);       // Exibe a subárvore esquerda
        cout << raiz->dado << endl; // Exibe o nó
    }
}

int main() {
    Arvore *raiz = NULL; // Use nullptr em vez de NULL
    raiz = inserir(10, raiz);
    raiz = inserir(5, raiz);
    raiz = inserir(15, raiz);
    raiz = inserir(3, raiz);
    raiz = inserir(7, raiz);
    raiz = inserir(12, raiz);
    raiz = inserir(20, raiz);

    cout << "Exibição em RED (Raiz, Esquerda, Direita):" << endl;
    exibirRED(raiz);
    cout << "Exibição em ERD (Esquerda, Raiz, Direita):" << endl;
    exibirERD(raiz);
    cout << "Exibição em EDR (Esquerda, Direita, Raiz):" << endl;
    exibirEDR(raiz);
    return 0;
}
