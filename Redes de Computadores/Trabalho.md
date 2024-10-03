# TRABALHO REDES

### Integrantes do Grupo
- **Grupo 1:** Yuri Alexander, Eduardo Cerreta e Meani 
- **Grupo 2:** Pedro, Miguel e Machado

> **Nota:** Todas as instruções a seguir devem ser executadas no terminal do Linux.

## Passo a passo
1. **Planejar as redes**
   - Definir a topologia de rede, incluindo dispositivos e conexões.
   - **LAN:** 192.168.1.0/24
   - **WAN:** 200.10.10.0/24

2. **Utilizar o Linux**
   - Utilizar todas as ferramentas necessárias no Linux.

3. **Instalar o SSH no Linux**
   - Para instalação, siga as orientações abaixo:
     ```bash
     sudo apt-get update
     sudo apt-get upgrade
     sudo apt-get install openssh-client
     ```
   - Criar usuário:
     ```bash
     adduser miguel
     ```
   - Adicionar usuário na lista do SUDO:
     ```bash
     sudo usermod -aG sudo miguel
     ```
   - Entra como super usuário:
     ```bash
     sudo su
     ```
   - Logar usuário / Mudar usuário:
     ```bash
     sudo su "username"
     ```
4. **Instalar o Apache 2 no Linux**
   - Para instalação, siga as orientações abaixo:
     ```bash
     sudo apt update
     sudo apt install apache2
     ```



---

### Ferramentas utilizadas
- **SSH:** Acesso ao Linux a partir do Windows, permitindo gerenciamento remoto seguro.
- **APACHE 2:** Servidor web para hospedagem de sites e aplicações.
- **Sub-interface:** Utilização de interfaces virtuais para segmentação da rede e melhor gerenciamento de tráfego.
- **Rotas:** Configuração de rotas estáticas e dinâmicas para comunicação entre diferentes sub-redes.
- **Proxy (NAT):**
  - **SQUID:** Proxy caching para melhorar o desempenho de acesso à internet.
  - **IP TABLES:** Ferramenta de filtragem de pacotes para configurar regras de firewall e NAT.

### Informações gerais
Endereços que começam com 172 são endereços inválidos que não navegam pela internet.
Linux: quando criar sub-interface não vai permitir. IPV4 alterar 0 para 1.

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

<h2 align="center">Sites Relevantes</h2>

<div align="center">

| Nome     | Link                                               |
|----------|----------------------------------------------------|
| **Dontpad** | [dontpad.com/grupodosfalhosprogramadores](https://dontpad.com/grupodosfalhosprogramadores) |
| **Pedroca** | [pedr0xh.free.nf](http://pedr0xh.free.nf)                         |

</div>

---
