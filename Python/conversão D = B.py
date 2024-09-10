numero = float(input("Digite um numero decimal: "))

if numero < 0:
    sinal = '-'
    numero = abs(numero)
else:
    sinal = ''

parte_inteira = int(numero)
parte_fracionaria = numero - parte_inteira

binario_inteiro = bin(parte_inteira).replace("0b", "")
binario_fracionario = ""

for _ in range(8):  
    parte_fracionaria *= 2
    bit = int(parte_fracionaria)
    binario_fracionario += str(bit)
    parte_fracionaria -= bit

resultado = f"{sinal}{binario_inteiro}.{binario_fracionario}"

print(f"Numero binario:: {resultado}")
