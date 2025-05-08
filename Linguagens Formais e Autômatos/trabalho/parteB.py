def afd_exatamente_tres_uns(palavra):
    estado = 'q0'
    for simbolo in palavra:
        if estado == 'q0':
            if simbolo == '1':
                estado = 'q1'
            elif simbolo == '0':
                estado = 'q0'
            else:
                return False  
        elif estado == 'q1':
            if simbolo == '1':
                estado = 'q2'
            elif simbolo == '0':
                estado = 'q1'
            else:
                return False
        elif estado == 'q2':
            if simbolo == '1':
                estado = 'q3'
            elif simbolo == '0':
                estado = 'q2'
            else:
                return False
        elif estado == 'q3':
            if simbolo == '1':
                return False  
            elif simbolo == '0':
                estado = 'q3'
            else:
                return False
    return estado == 'q3'


print("Digite uma palavra (apenas com 0 e 1) que tenha EXATAMENTE três '1' (em qualquer posição):")
entrada = input().strip()

if afd_exatamente_tres_uns(entrada):
    print(f"A palavra '{entrada}' foi ACEITA (tem exatamente três uns).")
else:
    print(f"A palavra '{entrada}' foi REJEITADA (não tem exatamente três uns).")
