import os


from util import inscricao, conexao_base, listagem, entrar, sair

lista_inscritos = [] #guardar a matrícula
lista_entrada = [] #guardar a entrada
lista_saida = [] #guardar a saida
conexao_base(lista_inscritos)

while (True):
    os.system('cls')
    print('MENU')
    print('1 - Fazer inscrições')
    print('2 - Listar inscritos')
    print('3 - Registrar entrada')
    print('4 - Registrar saída')
    print('5 - Finalizar')
    op = input('Opções: ')

    if op == '1':
        print('Inscrições')
        #chamar o metodo de inscricao
        inscricao(lista_inscritos)
    elif op == '2':
        print('Listagem de inscritos')
        #chamar o metodo de listagem
        listagem()
    elif op == '3':
        print('Entrada')
        matricula_selecionada = input('Digite a matricula para entrar no evento: ')
        leitor = open('inscricoes.dat')

        for linha in leitor:
            matricula = linha.split(';')[0]
            
            if matricula == matricula_selecionada:
                # chamar o metodo de entrada no evento
                entrar(lista_entrada, linha)
                print('\n Lista Entrada: \n', lista_entrada)
                
        leitor.close()
       
    elif op == '4':
        print('Saída')
        matricula_selecionada = input('Digite a matricula para sair do evento: ')
        leitor = open('inscricoes.dat')

        for linha in leitor:
            matricula = linha.split(';')[0]

            if matricula == matricula_selecionada:
                #chamar o metodo de saida do evento
                sair(lista_entrada, linha)
                print('\n Lista Saida: \n', lista_entrada)

        leitor.close()

    elif op == '5':
        print('Obrigado por usar o sistema')
        break
    else:
        print('Opção inválida!')

    os.system('pause')
