1. Dadas as Linguagens Regulares sobre o alfabeto {a,b}, construa as Expressões Regulares
correspondentes:

L1 = {w| w possui aaa como subpalavra}
(a+b)*aaa(a+b)*

L2 = {w| o sufixo de w é bb}
(a+b)*bb

L3 = {w| bb é subpalavra de w e aaaa é sufixo}
(a+b)*bb(a+b)*aaaa

L4 = {w| w possui sufixo aaa ou prefixo bb ou w = ε}
(a+b)* aaa + bb (a+b)* + ε

L5 = {w| w possui sufixo ba e prefixo ab}
ab (a+b)* ba

2. Construa os Autômatos Finitos que reconheçam as linguagens geradas pelas Expressões Regulares:

i. (b+ab)*

![ex1](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex1.jpeg)

ii. (a+ )(b+ba)
![ex2](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex2.jpeg)

iii. (ab+ba)*(aa+bb)
![ex3](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex3.jpeg)

iv. ab(abb*+baa*)*ba
![ex4](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex4.jpeg)

v. (aa+b)*(a+bb)
![ex5](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex5.jpeg)

vi. a*(aa+bb)
![ex6](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex6.jpeg)

vii. b*ab*ab*
![ex7](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex7.jpeg)

viii. (b+ab)*( +a)
![ex8](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex8.jpeg)

ix. (aa+bb)*(ab)*
![ex9](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex9.jpeg)

x. (ab+ba)*(aa+bb)*
![ex10](https://github.com/yuyukiin/faculdade-cc/blob/main/Linguagens%20Formais%20e%20Aut%C3%B4matos/lista_03/Imagens/ex10.jpeg)

xi. (0+1)* (00+01+10+11) (0+1)*
![ex11]()

3. Dadas as Expressões Regulares sobre ∑={a, b}, identifique quais linguagens são denotadas:
i. (aa+b)*(a+aa)

ii. (b+ab)*( +a)

iii. (ab+ba) (b+a)*

iv. (0+1)* 111 (0+1)*

v. (0+1)* (10+01)

