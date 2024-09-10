def validarPlaca(placa):
  if len(placa) != 8:
    return False
  if placa in placas:
    return False
  return True

def cadastrarPlaca():
  placa = input("Digite a placa a ser cadastrada: ")
  if validarPlaca(placa):
    placas.append(placa)
    print("Placa cadastrada com sucesso!")
  else:
    print("Placa inválida ou já cadastrada.")

def mostrarPlacas():
    placasOrdenadas = sorted(placas)
    if placasOrdenadas:
        print("Placas cadastradas:")
        for placa in placasOrdenadas:
            print(placa)
    else:
        print("Nenhuma placa cadastrada.")

def removerPlaca():
    placa = input("Digite a placa a ser removida: ")
    if placa in placas:
        placas.remove(placa)
        print("Placa removida com sucesso!")
    else:
        print("Placa não encontrada.")

placas = []

while True:
  print("Menu /n")
  print("1. Cadastrar placa na lista.")
  print("2. Mostrar placas.")
  print("3. Remover placa")
  print("4. Sair")

  opcao = input("Digite a opcao desejada: ")

  if opcao == "1":
    cadastrarPlaca()
  elif opcao == "2":
    mostrarPlacas()
  elif opcao == "3":
    removerPlaca()
  elif opcao == "4":
    break
  else:
    print("Opcão invalida")
