# adm-azs-shipping : Gestão de frete
A aplicação spring foi construida na versão do Java 17. Todos os endpoints no desafio foram construidos. GET para consulta dos dados paginados ou sem paginação e busca por ID, POST para cadastro de frete, PUT para atualização do frete e DELETE para deletar o frete.

A aplicação está com suporte ao Swagger UI como documentação, então você pode acessar o link: http://localhost:8080/swagger-ui/index.html#/ após a inicialização da aplicação, se você estiver rodando em outra porta diferente da 8080 basta alterar a url.

O banco de dados utilizado para o desafio, foi o banco de dados H2 com o objetivo de facilitar a desmonstração do projeto, o banco de dados H2 é um banco de dados em memória que é gerenciado pela aplicação através do Maven, ou seja, você não precisará instalar nenhum banco de dados para fazer a aplicação rodar, ele já está inclusa no projeto, a desvantagem é que os dados são perdidos todas vez que o projeto é encerrado. Porém é possível utilizar qualquer outro banco de sua preferência, basta colocar a dependencia do banco escolhido no pom.xml e configurar as credenciais no application.properties de acordo com o banco escolhido.

A aplicação pode ser rodada em Docker, o Dockerfile para o build da imagem está na raiz do projeto.
