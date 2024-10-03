# TRABALHO REDES

### Sumário
1. [Integrantes do Grupo](#integrantes-do-grupo)
2. [Passo a passo](#passo-a-passo)
   - [Planejar as redes](#planejar-as-redes)
   - [Utilizar o Linux](#utilizar-o-linux)
   - [Instalar o SSH no Linux](#instalar-o-ssh-no-linux)
   - [Instalar o Apache 2 no Linux](#instalar-o-apache-2-no-linux)
   - [Criar Sub-interfaces no Linux](#criar-sub-interfaces-no-linux)
   - [Configurar Rotas](#configurar-rotas)
3. [FAZER](#fazer)
4. [Ferramentas utilizadas](#ferramentas-utilizadas)
5. [Informações gerais](#informações-gerais)
6. [Redes](#redes)
7. [Quadro](#quadro)
8. [Sites Relevantes](#sites-relevantes)

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
     sudo adduser username
     ```

   - Adicionar usuário na lista do SUDO:
     ```bash
     sudo usermod -aG sudo username
     ```

   - Entra como super usuário:
     ```bash
     sudo su
     ```

   - Logar usuário / Mudar usuário:
     ```bash
     sudo su username
     ```

4. **Instalar o Apache 2 no Linux**
   - Para instalação, siga as orientações abaixo:
     ```bash
     sudo apt update
     sudo apt install apache2
     ```

   - Inicie o serviço:
     ```bash
     sudo systemctl start apache2
     ```

   - Criando a página:
     ```bash
     sudo nano /var/www/html/grupo1.html
     ```

   - A página:
     ```html
     <!DOCTYPE html>
     <html lang="pt-BR">
     <head>
         <meta charset="UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <title>Página do Grupo 1</title>
     </head>
     <body>
         <h1>Bem-vindo à nossa página, professor!</h1>
         <p>Esta é uma página criada com Apache2.</p>
     </body>
     </html>
     ```

   - Para salvar e sair da "criação html":
     ```bash
     Ctrl + X
     ou
     Y + Enter
     ```

   - Configurando permissões:
     ```bash
     sudo chown -R www-data:www-data /var/www/html/
     sudo chmod -R 755 /var/www/html/
     ```

   - (Opcional) Habilitar no firewall:
     ```bash
     sudo ufw allow 'Apache'
     ```

   - Abrir Site criado: http://172.25.2.204/grupo1.html

5. **Criar Sub-interfaces no Linux**
   - Primeiramente tem que instalar o net-tools
     ```bash
     sudo apt install net-tools
     ```

   - Mostra roteador
     ```bash
     sudo ifconfig
     ```

   - Adiciona a sub-interface (O IP será diferente conforme o grupo)
     ```bash
     sudo ifconfig enp0s31f6:0 192.168.1.9 netmask 255.255.255.248
     ```

7. **Configurar Rotas**
   - Exibir rotas
     ```bash
     sudo route
     ```

---

### Andamento
| Nome          | Concluído                                               | Para que serve                          |
|---------------|--------------------------------------------------------|-----------------------------------------|
| LINUX         | ✅ Utilização de ferramentas necessárias                | Ambiente para execução das tarefas      |
| SSH           | ✅ Instalação e configuração de usuário                 | Acesso remoto e seguro ao servidor      |
| APACHE 2      | ✅ Instalação e criação de página web                   | Servidor web para hospedar páginas      |
| SUB-INTERFACE | ✅ Instalação do net-tools e criação de sub-interface   | Segmentação de rede para diferentes serviços |
| ROTAS         | ❌ Configuração e exibição de rotas pendentes          | Direcionamento de tráfego na rede       |
| Proxy         | ❌ Bloquear sites                                        | Intermediário para requisições externas |
| - SQUID       | ❌ No meu servidor Linux                                 | Servidor proxy para controle de acesso  |
| - IP TABLES   | ❌ Servidor laboratório                                  | Gerenciamento de regras de firewall      |

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
| **Bloquear** | [pedr0xh.free.nf](http://172.25.2.204/grupo1.html)                         |
| **Grupo 1** | [http://172.25.2.204/grupo1.html](http://172.25.2.204/grupo1.html) |

</div>
