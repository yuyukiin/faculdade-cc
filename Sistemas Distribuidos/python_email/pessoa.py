import pickle

class Pessoa:
    def __init__(self, nome, email):
        self.nome = nome
        self.email = email

    def __str__(self):
        return f"Pessoa{{nome={self.nome}, email={self.email}}}"

    def __eq__(self, other):
        if not isinstance(other, Pessoa):
            return NotImplemented
        return self.nome == other.nome and self.email == other.email

def serializa_pessoa(pessoa):
    """Serializa um objeto Pessoa para bytes."""
    return pickle.dumps(pessoa)

def deserializa_pessoa(dados):
    """Deserializa bytes para um objeto Pessoa."""
    return pickle.loads(dados)
