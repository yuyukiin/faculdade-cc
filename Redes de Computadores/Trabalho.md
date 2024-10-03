# TRABALHO

Nome: Yuri Alexander, Pedro Daroda e Eduardo Cerreta

### Passo a passo
1. **Planejar as redes**
   - Definir a topologia de rede, incluindo dispositivos e conexões.
2. **Instalar o Linux**
   - Escolher a distribuição adequada (ex: Ubuntu, CentOS).
   - Configurar a instalação e definir partições.

   - **LAN:** 192.168.1.0/24
   - **WAN:** 200.10.10.0/24

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

- **Endereço IPv4:** 172.25.2.205
- **Máscara de Sub-rede:** 255.255.255.192
- **Gateway Padrão:** 172.25.2.193

<p align="center">
    <img src="humor.jpg" alt="Falhos Programadores">
</p>


