import math

print("Digite os valores do vetor principal:")
x = float(input("x: "))
y = float(input("y: "))
z = float(input("z: "))

while True:
    print("\n--- MENU ---")
    print("a) Matriz")
    print("b) Multiplicação de duas matrizes A e B")
    print("c) Verificação se a matriz é diagonal")
    print("d) Verificação se a matri é identidade")
    print('e) Matriz transposta')
    print("f) Sair")

    opcao = input("Escolha uma opção: ").lower()

    if opcao == 'a':
        linhas_A = float(input("linhas A: "))
        colunas_B = float(input('Colunas B: '))
        # Multiplica as matrizes A e B manualmente com loops aninhados
        for i in range(linhas_A): # Percorre as linhas de A
            for j in range(colunas_B): # Percorre as colunas de B
                soma = 0 # armazenar a soma dos produtos
                for k in range(colunas_A): #Percorre os elementos da linha de A e coluna de B
                    soma += A[i][k] * B[k][j] # Multiplica e acumula o resultado
                resultado[i][j] = soma # Atribui o resultado final para a posição correta

            elif opcao == 'h':
        break

    else:
        print("Opção inválida.")