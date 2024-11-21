# Configuração do Roteador

```bash
Router> enable
Router# config t
Enter configuration commands, one per line. End with CNTL/Z.

Router(config)# int f0/0
Router(config-if)# ip add 192.168.0.33 255.255.255.224
Router(config-if)# no shut
Router(config-if)# exit

Router(config)# int f0/1
Router(config-if)# ip add 192.168.0.1 255.255.255.248
Router(config-if)# no shut
Router(config-if)# exit

Router(config)# exit
Router# write memory

Router> enable
Router# conf t
Enter configuration commands, one per line. End with CNTL/Z.

Router(config)# ip route 0.0.0.0 0.0.0.0 [GATEWAY_IP]

Router(config)# exit
Router# write memory

Router(config)# int s0/1
Router(config-if)# ip add 200.10.2.1 255.255.255.0
Router(config-if)# clock rate 250000
Router(config-if)# encap ppp
Router(config-if)# clock rate 250000
Router(config-if)# no shut
Router(config-if)# exit

Router(config)# exit
Router# wr

Router> enable
Router# config t
Enter configuration commands, one per line. End with CNTL/Z.

Router(config)# route rip
Router(config-router)# network 192.168.1.0
Router(config-router)# network 200.10.0.0
Router(config-router)# network 200.10.1.0
Router(config-router)# exit
Router(config)# exit

Router(config)# int s0/0
Router(config-if)# ip add 200.10.3.1 255.255.255.0
Router(config-if)# encap ppp
Router(config-if)# no shut
```

