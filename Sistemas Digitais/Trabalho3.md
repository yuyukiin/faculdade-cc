<div align="center">

# Projeto 3: Semáforo com Botão de Pedestre

</div>

## 3. Semáforo com Botão de Pedestre

Implemente uma FSM Moore que controla um semáforo de 3 luzes (verde, amarelo, vermelho) com um botão de pedestre (btn). Sem o botão, o ciclo segue normalmente (Verde → Amarelo → Vermelho → Verde). Se btn=1, deve completar o verde atual, seguir para Amarelo → Vermelho, manter o vermelho por 2 tempos e então voltar para Verde.

#### Diagrama de Estados (Texto Simples)
```
(S_VERDE) --fim do timer--> (S_AMARELO)
  * Se btn='1', registra o pedido do pedestre.

(S_AMARELO) --fim do timer E pedido='0'--> (S_VERMELHO)
(S_AMARELO) --fim do timer E pedido='1'--> (S_VERMELHO_PED)

(S_VERMELHO) --fim do timer--> (S_VERDE)

(S_VERMELHO_PED) --fim do timer estendido--> (S_VERDE)
  * Zera o pedido do pedestre.
```

#### Tabela de Transições

| Estado Atual     | Condição                     | Próximo Estado   | Ação a ser Registrada     |
| :--------------- | :--------------------------- | :--------------- | :------------------------ |
| `S_VERDE`        | Fim do timer                 | `S_AMARELO`      | Se `btn='1'`, `ped_request<='1'` |
| `S_AMARELO`      | Fim do timer E `ped_request='0'` | `S_VERMELHO`     | -                         |
| `S_AMARELO`      | Fim do timer E `ped_request='1'` | `S_VERMELHO_PED` | -                         |
| `S_VERMELHO`     | Fim do timer                 | `S_VERDE`        | -                         |
| `S_VERMELHO_PED` | Fim do timer estendido       | `S_VERDE`        | `ped_request<='0'`           |


#### Resultados da Simulação
![Simulação do Semáforo com Pedestre](semaforo_2.png)
*Figura 3: Simulação mostrando o ciclo normal e o ciclo modificado após o acionamento do botão de pedestre (`btn`).*

#### Código Fonte

**Design (semaforos.vhd):**

```vhdl
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity semaforos is
    Port (
        clk      : in  STD_LOGIC;
        reset    : in  STD_LOGIC;
        btn      : in  STD_LOGIC;
        verde    : out STD_LOGIC;
        amarelo  : out STD_LOGIC;
        vermelho : out STD_LOGIC
    );
end semaforos;

architecture Behavioral of semaforos is

    constant CLK_FREQ           : integer := 50_000_000;
    constant TEMPO_VERDE        : integer := 5;
    constant TEMPO_AMARELO      : integer := 2;
    constant TEMPO_VERMELHO     : integer := 5;
    constant TEMPO_VERMELHO_PED : integer := TEMPO_VERMELHO * 2;

    type state_type is (S_VERDE, S_AMARELO, S_VERMELHO, S_VERMELHO_PED);
    
    signal current_state : state_type;
    signal timer_count   : integer range 0 to CLK_FREQ * TEMPO_VERMELHO_PED;
    signal ped_request   : std_logic := '0';

begin

    process(clk, reset)
    begin
        if reset = '1' then
            current_state <= S_VERDE;
            timer_count   <= 0;
            ped_request   <= '0';
        elsif rising_edge(clk) then
            case current_state is
                when S_VERDE =>
                    if btn = '1' then
                        ped_request <= '1';
                    end if;
                    if timer_count = (CLK_FREQ * TEMPO_VERDE) - 1 then
                        current_state <= S_AMARELO;
                        timer_count   <= 0;
                    else
                        timer_count <= timer_count + 1;
                    end if;

                when S_AMARELO =>
                    if timer_count = (CLK_FREQ * TEMPO_AMARELO) - 1 then
                        if ped_request = '1' then
                            current_state <= S_VERMELHO_PED;
                        else
                            current_state <= S_VERMELHO;
                        end if;
                        timer_count <= 0;
                    else
                        timer_count <= timer_count + 1;
                    end if;

                when S_VERMELHO =>
                    if timer_count = (CLK_FREQ * TEMPO_VERMELHO) - 1 then
                        current_state <= S_VERDE;
                        timer_count   <= 0;
                    else
                        timer_count <= timer_count + 1;
                    end if;

                when S_VERMELHO_PED =>
                    if timer_count = (CLK_FREQ * TEMPO_VERMELHO_PED) - 1 then
                        current_state <= S_VERDE;
                        timer_count   <= 0;
                        ped_request   <= '0';
                    else
                        timer_count <= timer_count + 1;
                    end if;
            end case;
        end if;
    end process;

    process(current_state)
    begin
        case current_state is
            when S_VERDE =>
                verde    <= '1';
                amarelo  <= '0';
                vermelho <= '0';
            when S_AMARELO =>
                verde    <= '0';
                amarelo  <= '1';
                vermelho <= '0';
            when S_VERMELHO | S_VERMELHO_PED =>
                verde    <= '0';
                amarelo  <= '0';
                vermelho <= '1';
        end case;
    end process;

end Behavioral;
```

**TestBench (tb_semaforo.vhd):**

```vhdl
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity tb_semaforo is
end tb_semaforo;

architecture Behavioral of tb_semaforo is

    component semaforos
        Port (
            clk      : in  STD_LOGIC;
            reset    : in  STD_LOGIC;
            btn      : in  STD_LOGIC;
            verde    : out STD_LOGIC;
            amarelo  : out STD_LOGIC;
            vermelho : out STD_LOGIC
        );
    end component;

    signal clk      : STD_LOGIC := '0';
    signal reset    : STD_LOGIC;
    signal btn      : STD_LOGIC;
    signal verde    : STD_LOGIC;
    signal amarelo  : STD_LOGIC;
    signal vermelho : STD_LOGIC;
    
    constant CLK_PERIOD : time := 20 ns;

begin

    uut: semaforos
        port map (
            clk      => clk,
            reset    => reset,
            btn      => btn,
            verde    => verde,
            amarelo  => amarelo,
            vermelho => vermelho
        );

    clk_process : process
    begin
        clk <= '0'; wait for CLK_PERIOD / 2;
        clk <= '1'; wait for CLK_PERIOD / 2;
    end process;

    stimulus_process : process
    begin
        reset <= '1';
        btn   <= '0';
        wait for 100 ns;
        reset <= '0';
        wait for CLK_PERIOD;

        wait for 15 sec;

        wait for 2 sec;
        
        btn <= '1';
        wait for CLK_PERIOD;
        btn <= '0';

        wait for 20 sec;

        wait;
    end process;

end Behavioral;
```eof

```
