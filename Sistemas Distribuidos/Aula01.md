# 📅 Aula: 28/07

## Sistemas Distribuídos

### Sistemas fracamente acoplados – Grid Computacional
- Geograficamente distribuídos  
- Máquinas com hardware e sistemas operacionais diferentes  
- Comunicação baseada no modelo **TCP/IP**

### Arquitetura de Sistemas

#### Cliente-Servidor
- ✅ **Vantagem**: Manutenção facilitada e boa escalabilidade  
- ❌ **Desvantagem**: Estabilidade do servidor (ponto único de falha)

#### Ponto a Ponto (P2P)
- ✅ **Vantagem**: Distribuição de carga, maior disponibilidade  
- ❌ **Desvantagem**: Manutenção mais complexa

### Comunicação
- **Troca de dados**:
  - Strings → Mensagens  
  - Objetos → Serialização  

### Sincronismo
- **Sincronização de processos**:
  - Relógio  
  - Monitor ou Semáforo  
  - (Outros, ex: algoritmos de eleição, barreiras, etc.)

### Tolerância a Falhas
- Garantia de continuidade do serviço mesmo diante de falhas parciais.

---

## Threads

- Pequenos processos (**mini-processos**)

### Gestão de Threads
- `stop` → Encerra a thread  
- `pause` → Pausa temporariamente (diferente de stop)  
- `sleep` → Adormece por um tempo  
- **Sincronizar** → Fundamental para evitar conflitos em dados compartilhados

### Thread Simples
- Sem dependência de dados compartilhados  

### Memória Compartilhada
- Dados acessados por várias threads precisam de **sincronização** para evitar **condições de corrida**

---

## 🚫 Parte não abordada (conteúdo da professora Ana)

## Sistemas Paralelos

### Sistemas fortemente acoplados – Cluster Computacional
- Localizados na mesma área geográfica  
- Máquinas com **hardware idêntico**  
- Comunicação via **fibra óptica**  
- Sistema **nobreak robusto**  
- Sistema de **backup eficiente**  
- Programação paralela
