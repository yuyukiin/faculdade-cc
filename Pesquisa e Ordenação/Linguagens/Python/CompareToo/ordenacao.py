def pente(lista):
    distancia = len(lista)
    houve_troca = True
    while distancia > 1 and houve_troca:
        distancia = max(1, int(distancia / 1.3))
        houve_troca = False
        for i in range(len(lista) - distancia):
            if lista[i] > lista[i + distancia]:
                lista[i], lista[i + distancia] = lista[i + distancia], lista[i]
                houve_troca = True

def bolha(lista):
    houve_troca = True
    while houve_troca:
        houve_troca = False
        for i in range(len(lista) - 1):
            if lista[i] > lista[i + 1]:
                lista[i], lista[i + 1] = lista[i + 1], lista[i]
                houve_troca = True
