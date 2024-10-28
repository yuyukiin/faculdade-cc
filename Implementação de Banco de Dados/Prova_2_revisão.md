<h2 align="center">Revisão Prova 2</h2>
<p align="center">

### Transações ACID
As transações em sistemas de bancos de dados seguem o princípio ACID, que garante a integridade e a confiabilidade das operações. Cada letra representa uma propriedade essencial:

- **Atomicidade**: Garante que todas as operações dentro de uma transação sejam executadas completamente ou não sejam executadas. Se uma parte da transação falhar, nenhuma mudança é aplicada.
  
- **Consistência**: Assegura que a transação leva o banco de dados de um estado válido a outro estado válido. Isso significa que todas as regras de integridade devem ser respeitadas.

- **Isolamento**: Permite que transações concorrentes sejam executadas de maneira isolada, como se fossem as únicas a acessar os dados. Isso evita problemas como leituras sujas.

- **Durabilidade**: Após uma transação ser confirmada (committed), suas mudanças permanecem no sistema, mesmo em caso de falha do sistema ou do banco de dados.

### Rollback e Commit
Durante o gerenciamento de transações, duas operações fundamentais são:

- **Commit**: Esta operação confirma todas as mudanças realizadas durante a transação. Quando um commit é executado, todas as alterações se tornam permanentes no banco de dados. Isso garante que os dados sejam salvos de forma durável.

- **Rollback**: Esta operação reverte todas as mudanças realizadas desde o último commit. É utilizada em casos de erro ou se a transação não puder ser concluída com sucesso. O rollback assegura que o banco de dados retorne a um estado consistente, como se a transação nunca tivesse ocorrido.

### Trigger (Gatilho)
Triggers são procedimentos automáticos que são executados em resposta a certos eventos no banco de dados. Eles podem ser definidos para ocorrer em três momentos:

- **Insert**: Executa a ação após uma nova linha ser inserida na tabela.
  
- **Update**: Executa a ação após uma linha existente ser modificada.

- **Delete**: Executa a ação após uma linha ser removida.

Triggers podem ser configurados para serem executados:

- **After**: Após a execução da operação de DML (Data Manipulation Language).
  
- **Instead of**: No lugar da operação de DML, útil para views.

### Restrições de Integridade
As restrições de integridade garantem a validade e a precisão dos dados no banco. Existem dois tipos principais:

- **Procedural**: Restrições implementadas através de procedimentos armazenados ou funções. Podem incluir lógica de validação mais complexa.

- **Declarativas**: Restrições definidas diretamente no esquema do banco de dados. Exemplos incluem:
- **Comandos DDL*:
  - Create, Alter, Drop.   
  - **Cascade**: Usada em operações de exclusão ou atualização para propagar mudanças para registros relacionados.
  - **Check**: Restrições que garantem que os valores em uma coluna atendam a uma condição específica.

### View
Uma view é uma tabela "virtual" que resulta de uma consulta armazenada. As views permitem:

- **Abstração**: Ocultar complexidades do esquema do banco de dados, apresentando dados de uma maneira mais compreensível.
  
- **Segurança**: Restringir o acesso a determinadas colunas ou linhas da tabela original.

- **Reuso de Consultas**: Facilitar a reutilização de consultas complexas, simplificando o acesso aos dados.

As views não armazenam dados fisicamente, mas sim uma definição que é executada quando a view é acessada.

---

