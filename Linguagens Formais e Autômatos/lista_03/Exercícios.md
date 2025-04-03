# Linguagens Formais e Autômatos

1. **Expressões Regulares**

L1 = {w | w possui aaa como subpalavra}  
Expressão regular:  
(a + b)*aaa(a + b)*

L2 = {w | o sufixo de w é bb}  
Expressão regular:  
(a + b)*bb

L3 = {w | bb é subpalavra de w e aaaa é sufixo}  
Expressão regular:  
(a + b)*bb(a + b)*aaaa

L4 = {w | w possui sufixo aaa ou prefixo bb ou w = ε}  
Expressão regular:  
(a + b)*aaa + bb(a + b)* + ε

L5 = {w | w possui sufixo ba e prefixo ab}  
Expressão regular:  
ab(a + b)*ba

2. **Autômatos Finitos**

i. Expressão Regular: (b + ab)*  
![ex1](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex1.jpeg)

ii. Expressão Regular: (a + ε)(b + ba)  
![ex2](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex2.jpeg)

iii. Expressão Regular: (ab + ba)*(aa + bb)  
![ex3](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex3.jpeg)

iv. Expressão Regular: ab(abb* + baa*)*ba  
![ex4](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex4.jpeg)

v. Expressão Regular: (aa + b)*(a + bb)  
![ex5](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex5.jpeg)

vi. Expressão Regular: a*(aa + bb)  
![ex6](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex6.jpeg)

vii. Expressão Regular: b*ab*ab*  
![ex7](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex7.jpeg)

viii. Expressão Regular: (b + ab)*(ε + a)  
![ex8](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex8.jpeg)

ix. Expressão Regular: (aa + bb)*(ab)*  
![ex9](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex9.jpeg)

x. Expressão Regular: (ab + ba)*(aa + bb)*  
![ex10](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex10.jpeg)

xi. Expressão Regular: (0 + 1)*(00 + 01 + 10 + 11)(0 + 1)*  
![ex11](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex11.jpeg)

3. **Identificação das Linguagens Denotadas pelas Expressões Regulares**

i. (aa + b)*(a + aa)  
Denota: Repete várias vezes "aa" e "b", e termina com "a" ou "aa".

ii. (b + ab)*(ε + a)  
Denota: Repete várias vezes "b" e "ab", e termina com vazio ou "a".

iii. (ab + ba)(b + a)* ba  
Denota: "ab" ou "ba" como prefixos, seguidos por zero ou mais ocorrências de "b" ou "a", terminando com "ba".

iv. (0 + 1)* 111 (0 + 1)* 111  
Denota: A sequência "111" aparece como subpalavra duas vezes dentro de qualquer string binária.

v. (0 + 1)* (10 + 01) 10 ou 01 como sufixo  
Denota: Uma string binária que termina com "10" ou "01" como sufixo.
