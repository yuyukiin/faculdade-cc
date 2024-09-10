import os
lista = []

while (True):
  print("Menu Funcionarios")
  print("1 - Cadastrar")
  print("2 - Listar")
  print("3 - Excluir")
  print("4 - Sair")
  opcao = input("Opcao: ")

  if (opcao == "1"):
    print("Cadastro de funcionario")
    
    #receber e validar um nome completo
    while(True):
      nome_completo = input("Informe seu nome completo: ")
      vetor_nomes = nome_completo.split(" ")
      if (len(vetor_nomes) <= 1):
        print("Digite seu nome completo!")
      else:
        break

    #montar o gmail e partir do primeiro e ultimo sobrenome
    email = vetor_nomes[0]+"."+vetor_nomes[-1]+"@ufn"
    email = email.lower()
  
    #verificar se o gmail ja cadastrado na lista, se não, cadastra-lo
    if (lista.__contains__(email)):
      print("Funcionario do gmail ja cadastrado")
    else:
      lista.append(email)

    #manter ordenada lista
    lista.sort()
      
  elif (opcao == "2"):
    print("Listagem de funcionarios")
    if(len( lista) == 0):
      print("Lista vazia")
      for i in lista:
        print(i)
  elif (opcao == "3"):
    print("Exclusao de funcionario")
    if(len(lista) == 0):
      print("lista vazia")
    else:
      email = input("Digite email a ser excluido: ")
      if (email in lista):
        lista.remove(gmail)
      else:
        print("Gmail nao localizado")

  
  elif (opcao == "4"):
    print("Obrigado por usar o programa")
    break
  else:
    print("Opcao invalidade!")
    
  
