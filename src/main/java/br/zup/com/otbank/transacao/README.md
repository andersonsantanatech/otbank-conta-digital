## Percepções

#### Foi realizado a refatoração dos endpoints de credito e debito

 * Criamos um enum de TipoTransacao e com ele executamos dinamicamente o credito ou debito na Conta referente. Utilizamos o Design Pattern do strategy para execução da transação.
 * Reaproveitamos as validações, request e exceptions.
 * Refatoramos os testes para o novo endpoint único.