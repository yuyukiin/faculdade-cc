class Aluno:
    def __init__(self, matricula, nome):
        self.matricula = matricula
        self.nome = nome

    def __str__(self):
        return f"Aluno [matricula={self.matricula}, nome={self.nome}]"

    def __eq__(self, other):
        if not isinstance(other, Aluno):
            return False
        return self.matricula == other.matricula

    def __hash__(self):
        return hash(self.matricula)

if __name__ == "__main__":
    HashAluno = set()
    HashAluno.add(Aluno(1, "pedro"))

    for item in HashAluno:
        print(item)

    obj = Aluno(1, "carla")

    if obj in HashAluno:
        print("Encontrado")
    else:
        print("Não encontrado")
