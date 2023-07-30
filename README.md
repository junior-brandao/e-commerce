## Sistema E-Comerce
 Projeto de estudo de criação de api, onde uso as seguinte tecnologias:
   #### Linguagens :
        Java jdk 17 
   #### Gerenciamento de projetos :
        Maven
   #### Frameworks :
        Spring 
   #### DB:
        Em ambiente de testes utilizo o banco de dados H2(em memória),
        e o Postgres em ambiente de desenvolvimento e produção.
   ### Configurações para inicialização:

       Execute o comando: mvn install para instalar as dependências do maven.
       Após baixar as dependências, execute a aplicação e a api estará rodando em http://localhost:8080.
       Acesso ao banco de dados: http://localhost:8080/h2-console.
   ### Documentação:
       A documentação da api foi gerada através do Swagger e pode ser acessada em http://localhost:8080/swagger-ui.html#

### repositório: https://github.com/junior-brandao/e-commerce 



### 1- Visão geral do sistema
   O sistema deve manter um cadastro de usuário, produtos e suas categorias. Cada
   usuário possui nome, email, telefone, data de nascimento e uma senha de acesso. Os
   dados dos produtos são: nome, descrição, preço e imagem. O sistema deve apresentar
   um catálogo de produtos, os quais podem ser filtrados pelo nome do produto. A partir
   desse catálogo, o usuário pode selecionar um produto para ver seus detalhes e para
   decidir se o adiciona a um carrinho de compras. O usuário pode incluir e remover itens
   do carrinho de compra, bem como alterar as quantidades de cada item. Uma vez que o
   usuário decida encerrar o pedido, o pedido deve então ser salvo no sistema com o status
   de "aguardando pagamento". Os dados de um pedido são: instante em que ele foi salvo,
   status, e uma lista de itens, onde cada item se refere a um produto e sua quantidade no
   pedido. O status de um pedido pode ser: aguardando pagamento, pago, enviado,
   entregue e cancelado. Quando o usuário paga por um pedido, o instante do pagamento
   deve ser registrado. Os usuários do sistema podem ser clientes ou administradores,
   sendo que todo usuário cadastrado por padrão é cliente. Usuários não identificados
   podem se cadastrar no sistema, navegar no catálogo de produtos e no carrinho de
   compras. Clientes podem atualizar seu cadastro no sistema, registrar pedidos e visualizar
   seus próprios pedidos. Usuários administradores tem acesso à área administrativa onde
   pode acessar os cadastros de usuários, produtos e categorias.

## 2 - Protótipos de tela: 
   //fazer projeto

## 3 - Modelo Conceitual: 
   //fazer projeto

## 5- Casos de uso (visão geral) 
   //fazer projeto

## 6 - Casos de uso (detalhamento) 
   //fazer projeto