class Aluno:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

    def __str__(self):
        return f"Aluno{{nome={self.nome}, idade={self.idade}}}"

    def __eq__(self, other):
        if not isinstance(other, Aluno):
            return False
        return self.nome == other.nome and self.idade == other.idade

    def __lt__(self, other):
        if self.nome != other.nome:
            return self.nome < other.nome
        return self.idade < other.idade
