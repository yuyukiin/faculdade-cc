from grafo import Grafo

def main():
    cidades = [
        "Sao Pedro", "Santa Maria", "Agudo", "Santa Cruz", "Itaara",
        "Sao Martinho", "Julio de Castilhos", "Cruz Alta", "Soledade",
        "Lajeado", "Porto Alegre"
    ]

    grafo_rs = Grafo(cidades)

    with open('cidades.csv', 'r') as file:
        linhas = file.readlines()

    for linha in linhas:
        partes = linha.strip().split('@')
        if len(partes) == 2:
            grafo_rs.inserir_aresta_simetrica(partes[0].strip(), partes[1].strip())

    grafo_rs.show()

    cidade = "Itaara"
    print(f"Grau da cidade de {cidade}: {grafo_rs.mostrar_grau(cidade)}")

if __name__ == "__main__":
    main()
