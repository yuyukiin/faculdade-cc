import math

print("Digite os valores do vetor principal:")
x = float(input("x: "))
y = float(input("y: "))
z = float(input("z: "))

while True:
    print("\n--- MENU ---")
    print("a) Calcular o tamanho do vetor")
    print("b) Normalizar o vetor")
    print("c) Adicionar outro vetor")
    print("d) Subtrair outro vetor")
    print("e) Multiplicar por escalar")
    print("f) Dividir por escalar")
    print("g) Calcular produto escalar")
    print("h) Sair")

    opcao = input("Escolha uma opção: ").lower()

    if opcao == 'a':
        tamanho = math.sqrt(x**2 + y**2 + z**2)
        print(f"Tamanho do vetor: {tamanho:.2f}")

    elif opcao == 'b':
        tamanho = math.sqrt(x**2 + y**2 + z**2)
        if tamanho == 0:
            print("Vetor nulo não pode ser normalizado.")
        else:
            nx = x / tamanho
            ny = y / tamanho
            nz = z / tamanho
            print(f"Vetor normalizado: ({nx:.2f}, {ny:.2f}, {nz:.2f})")

    elif opcao == 'c':
        print("Digite o vetor para somar:")
        x2 = float(input("x: "))
        y2 = float(input("y: "))
        z2 = float(input("z: "))
        print(f"Vetor resultante: ({x+x2:.2f}, {y+y2:.2f}, {z+z2:.2f})")

    elif opcao == 'd':
        print("Digite o vetor para subtrair:")
        x2 = float(input("x: "))
        y2 = float(input("y: "))
        z2 = float(input("z: "))
        print(f"Vetor resultante: ({x-x2:.2f}, {y-y2:.2f}, {z-z2:.2f})")

    elif opcao == 'e':
        escalar = float(input("Digite o escalar: "))
        print(f"Vetor resultante: ({x*escalar:.2f}, {y*escalar:.2f}, {z*escalar:.2f})")

    elif opcao == 'f':
        escalar = float(input("Digite o escalar: "))
        if escalar == 0:
            print("Erro: Divisão por zero.")
        else:
            print(f"Vetor resultante: ({x/escalar:.2f}, {y/escalar:.2f}, {z/escalar:.2f})")

    elif opcao == 'g':
        print("Digite o segundo vetor:")
        x2 = float(input("x: "))
        y2 = float(input("y: "))
        z2 = float(input("z: "))
        produto_escalar = (x * x2) + (y * y2) + (z * z2)
        print(f"Produto Escalar: {produto_escalar:.2f}")

    elif opcao == 'h':
        break

    else:
        print("Opção inválida.")