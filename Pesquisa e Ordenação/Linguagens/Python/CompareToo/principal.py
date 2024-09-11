from aluno import Aluno
from ordenacao import bolha

def main():
    alunos = [
        Aluno("Tei", 19),
        Aluno("Gabriel", 23),
        Aluno("Dudu", 20),
        Aluno("Alex", 22),
        Aluno("Brunim levanti", 20),
        Aluno("Brunim nao levanti", 20)
    ]

    # Solução tradicional: usa o método __lt__ na classe Aluno
    alunos.sort()

    # Solução moderna: usa sorted com lambda para ordenar pela combinação de nome e idade
    alunos.sort(key=lambda aluno: (aluno.nome, aluno.idade))

    # Ordenação usando o método bolha
    bolha(alunos)

    for aluno in alunos:
        print(aluno)

if __name__ == "__main__":
    main()
