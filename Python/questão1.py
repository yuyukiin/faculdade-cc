
glicemia_do_momento = float(input("Digite a glicemia: "))
meta_pre_refeicao = float(input("Digite sua meta de refeicao: "))
fator_sensibilidade = int(input("Digite sua sensibilidade: "))

if 20 <= fator_sensibilidade <= 50:
  quantidade_insulina = (glicemia_do_momento - meta_pre_refeicao) / fator_sensibilidade

print("A sua quantidade de insulina: ", quantidade_insulina)
