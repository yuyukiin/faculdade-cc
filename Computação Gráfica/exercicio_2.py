import numpy as np

A = None

while True:
    print("\n--- MENU ---")
    print("a) Definir Matriz A")
    print("b) Multiplicação de duas matrizes A e B")
    print("c) Verificação se a matriz A é diagonal")
    print("d) Verificação se a matriz A é identidade")
    print("e) Matriz transposta de A")
    print("f) Sair")

    opcao = input("Escolha uma opção: ").lower()

    if opcao == 'a':
        try:
            linhas = int(input("Digite o número de linhas de A: "))
            colunas = int(input("Digite o número de colunas de A: "))
            dados = []
            for i in range(linhas):
                linha = []
                for j in range(colunas):
                    valor = float(input(f"Elemento A[{i}][{j}]: "))
                    linha.append(valor)
                dados.append(linha)
            A = np.array(dados)
            print("\nMatriz A definida:")
            print(A)
        except ValueError:
            print("Erro: Digite apenas números.")

    elif opcao == 'b':
        if A is None:
            print("Por favor, defina a Matriz A primeiro (Opção a).")
        else:
            try:
                print("\nDefinindo Matriz B:")
                linhas_b = int(input("Digite o número de linhas de B: "))
                colunas_b = int(input("Digite o número de colunas de B: "))

                if A.shape[1] != linhas_b:
                    print(f"Erro: Colunas de A ({A.shape[1]}) devem ser iguais às Linhas de B ({linhas_b}).")
                else:
                    dados_b = []
                    for i in range(linhas_b):
                        linha = []
                        for j in range(colunas_b):
                            valor = float(input(f"Elemento B[{i}][{j}]: "))
                            linha.append(valor)
                        dados_b.append(linha)
                    B = np.array(dados_b)

                    C = np.zeros((A.shape[0], B.shape[1]))
                    
                    for i in range(A.shape[0]):
                        for j in range(B.shape[1]):
                            soma = 0
                            for k in range(A.shape[1]):
                                soma += A[i][k] * B[k][j]
                            C[i][j] = soma
                    
                    print("\nResultado da multiplicação A * B:")
                    print(C)
            except ValueError:
                print("Erro: Digite apenas números.")

    elif opcao == 'c':
        if A is None:
            print("Defina a Matriz A primeiro.")
        else:
            if A.shape[0] != A.shape[1]:
                print("A matriz não é quadrada, portanto não pode ser diagonal.")
            else:
                eh_diagonal = True
                for i in range(A.shape[0]):
                    for j in range(A.shape[1]):
                        if i != j and A[i][j] != 0:
                            eh_diagonal = False
                            break
                    if not eh_diagonal:
                        break
                if eh_diagonal:
                    print("A matriz é diagonal.")
                else:
                    print("A matriz NÃO é diagonal.")

    elif opcao == 'd':
        if A is None:
            print("Defina a Matriz A primeiro.")
        else:
            if A.shape[0] != A.shape[1]:
                print("A matriz não é quadrada, portanto não pode ser identidade.")
            else:
                eh_identidade = True
                for i in range(A.shape[0]):
                    for j in range(A.shape[1]):
                        if i == j and A[i][j] != 1:
                            eh_identidade = False
                            break
                        elif i != j and A[i][j] != 0:
                            eh_identidade = False
                            break
                    if not eh_identidade:
                        break
                if eh_identidade:
                    print("A matriz é identidade.")
                else:
                    print("A matriz NÃO é identidade.")

    elif opcao == 'e':
        if A is None:
            print("Defina a Matriz A primeiro.")
        else:
            print("\nMatriz Transposta de A:")
            print(A.T)

    elif opcao == 'f':
        break

    else:
        print("Opção inválida.")