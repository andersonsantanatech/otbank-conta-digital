Criamos um controller com um método para receber o Put com os dados da Conta a ser creditada.
O argumento do método do Controller é uma classe do tipo DTO para receber os dados da conta. Ali também usamos a anotação
@Valid e @RequestBody para indicar a necessidade de validação e que os dados veem no corpo da requisição.

Na classe CreditarRequest temos os atributos que representam o id do cliente, o valor a ser creditado e o
número da conta.
Adicionamos as annotations de validação em cima de cada atributo. Em especial criamos a anotação @ExistsConta
para verificar se existe a conta informada, fazemos isso atráves do método existsByNumeroConta da interface que criamos
para ser um repositório de Contas.
Esse método verifica se existe no banco de dados a conta informada, se sim, ele retorna true, caso contrário lança a exceção
ContaNotFoundException com a mensagem "Conta Não Existe". Para que a comparação seja feita corretamente, criamos o equals
e o hashCode na entidade Conta, com o atributo numeroConta.

Dentro do método do Controller chamamos o método findByNumeroConta da interface ContaRepository que foi injetada nesse controller.
Esse método busca no banco o número da conta que foi passado atráves da classe de entrada e retorna um Optional da entidade Conta.

Na entidade Conta adicionamos os atributos que representam o número da conta, o id do cliente, o saldo da conta, além do id que será
gerado automaticamente pelo banco. Adicionamos as anotação do Hibernate, além de um construtor com os atributos obrigatórios e um vazio
para atender as especificaçõs do Hibernate. Criamos também o método creditar que recebe um valor a ser creditado na Conta. O saldo da Conta só será alterado se o valor for maior que zero.

Dentro do Controller chamamos o método creditar da conta passando o valor recebido da classe de entrada.
Se estiver tudo correto retornamos o status 200 e no corpo da resposta a classe CreditarResponse do tipo DTO de saída com o saldo da conta.
Se a Conta não for encontrada retornamos o staus 404(Not Found).

Adicionamos testes automatizados ao projeto, utilizando o banco em memória H2.
Criamos testes de integração para a classe Controller.
O primeiro teste é para verificar se credita um valor na conta. Utilizamos o método perform do MockMvc para simular a chamada a API. Se todos os dados da requisição
estiverem corretos, o retorno esperado será o status 2xx de sucesso.
Criamos também o teste para verificar se é retornado o status not found quando a conta não existir no banco de dados.
Adicionamos testes unitários para o método creditar da classe Conta. Um teste para verificar se o saldo é creditado quando informado uma valor positivo, outros dois para
verificarem se o saldo não foi alterado caso tenha sido informado um valor negativo ou igual a zero.