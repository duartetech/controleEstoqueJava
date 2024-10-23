# Sistema de Controle de Estoque

Este projeto é um sistema de controle de estoque desenvolvido em Java, utilizando Swing para a interface gráfica e JDBC para a interação com um banco de dados. O objetivo principal é permitir a movimentação de ferramentas no estoque, com funcionalidades para adicionar, remover e deletar itens.

## Funcionalidades
- **Cadastrar Ferramentas:** Permite que o usuário cadastre uma ferramenta no banco de dados do estoque da aplicação.
- **Adicionar Ferramentas:** Permite que o usuário adicione uma nova quantidade de ferramentas ao estoque.
- **Remover Ferramentas:** Possibilita a remoção de uma quantidade específica de ferramentas do estoque.
- **Deletar Ferramentas:** Remove uma ferramenta do estoque completamente.
- **Validação de Entrada:** O sistema valida as entradas do usuário, garantindo que a quantidade informada seja um número positivo e que as operações sejam realizadas apenas se as condições forem atendidas.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal do projeto.
- **Swing:** Biblioteca para criação da interface gráfica.
- **JDBC:** API para interação com o banco de dados.
- **Banco de Dados:** Utilização de um banco de dados relacional para armazenar informações sobre as ferramentas.

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/duartetech/controleEstoqueJava.git
   ```

2. Abra o projeto no NetBeans (ou outro IDE de sua escolha).

3. Execute o script **MetalurgiaDB.sql** no MySql

4. Configure a conexão com o banco de dados no arquivo `Conexao.java`.

5. Execute a classe **Main** para iniciar o sistema.

## Como Usar

1. Inicie o aplicativo.
2. Faça o login usando as credenciais de administrador (login e senha).
3. Acesse a tela de **Cadastrar Ferramenta** para adicionar novas ferramentas ao estoque.
4. Vá para a tela de **Movimentar Estoque** para adicionar, remover ou deletar ferramentas.
5. Também é possível visualizar o estoque atual na tela de **Visualizar Estoque**.
