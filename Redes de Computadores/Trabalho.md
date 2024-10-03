# TRABALHO REDES

- Grupo 1: Yuri Alexander, Eduardo Cerreta e Meani 
- Grupo 2: Pedro, Miguel e Machado

## Passo a passo
1. Planejar as redes
   - Definir a topologia de rede, incluindo dispositivos e conexões.
   - _LAN:_   192.168.1.0/24
   - _WAN:_   200.10.10.0/24
2. Utilizar o Linux
   - Utilizar todas ferramentas no Linux

3. Instalar o SSH no Linux
   - Para instalação seguir as orientações abaixo, abrindo o terminal.
     ```bash
     sudo apt-get update
     sudo apt-get upgrade
     sudo apt-get install openssh-client
     ```
     - Criar usuário utilizando o terminal
     ```bash
     adduser "username"
     ```
     - Adicionar usuário na lista do SUDO
     ```bash
     # usermod -aG sudo username
     ```
4. Instalar o Apache 2 no Linux
   - Para instalação seguir as orientações abaixo,  abrindo o terminal.
     ```bash
     sudo apt update
     sudo apt install apache2
     ```




### Sudo

Instalção Sudo SSH


Adiciona usuário a lista de Sudo


### Linux

Cria usuário no Linux




---

### Ferramentas utilizadas
- **APACHE 2:** Servidor web para hospedagem de sites e aplicações.
- **Sub-interface:** Utilização de interfaces virtuais para segmentação da rede e melhor gerenciamento de tráfego.
- **Rotas:** Configuração de rotas estáticas e dinâmicas para comunicação entre diferentes sub-redes.
- **Proxy (NAT):**
  - **SQUID:** Proxy caching para melhorar o desempenho de acesso à internet.
  - **IP TABLES:** Ferramenta de filtragem de pacotes para configurar regras de firewall e NAT.

### Informações gerais
Endereços que começam com 172 são endereços inválidos que não navegam pela internet.
Linux: quando criar sub-interface não deixa 

- **Endereço IPv4:** 172.25.2.205
- **Máscara de Sub-rede:** 255.255.255.192
- **Gateway Padrão:** 172.25.2.193

---

<h2 align="center">Redes</h2>
<p align="center">
    <img src="redes.png" alt="redes">
</p>

<h2 align="center">Quadro</h2>
<p align="center">
    <img src="quadro.jpeg" alt="quadro">
</p>

---

### Sites
- [Dontpad](https://dontpad.com/grupodosfalhosprogramadores)
- [Pedroca](http://pedr0xh.free.nf)
