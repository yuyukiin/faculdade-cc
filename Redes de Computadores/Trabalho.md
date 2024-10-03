# TRABALHO

- Grupo 1: Yuri Alexander, Eduardo Cerreta e Meani 
- Grupo 2: Pedro, Miguel e Machado

## Passo a passo
1. **Planejar as redes**
   - Definir a topologia de rede, incluindo dispositivos e conexões.
2. **Instalar o Linux**
   - Escolher a distribuição adequada (ex: Ubuntu, CentOS).
   - Configurar a instalação e definir partições.
3. Instalar o SSH no Linux
   - Acessar o Windows com o Linux para permitir gerenciamento remeto.

- _LAN:_   192.168.1.0/24
- _WAN:_   200.10.10.0/24

## Comandos



### Sudo

Update no Sudo
```bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install openssh-client
```

Adiciona usuário a lista de Sudo
```bash
# usermod -aG sudo username
```

### Linux

Cria usuário no Linux
```bash
adduser "username"
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
