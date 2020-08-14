## Workshop Rest na Prática

Para executarmos o momento da prática de forma rápida e eficaz, participantes devem fazer o Fork desse repositório para suas contas, clonem e testem os 2 projetos que estão aqui.

- pedido-quarkus
- pedido-spring

Será necessário realizar um teste simples em cada projeto para valida-los.

**pedidos-quarkus**

> $ cd pedido-quarkus
>
> $ ./mvnw quarkus:dev

Esse comando deve levar essa aplicação inicial.

Para validarmos devemos acessar no browser a seguinte URL.

> http://localhost:8080/order

Deve retornar um json mais ou menos assim:

```json
[
 {
  "id":"5f346cb5ef47a34fc1df94df",
  "amount":1,
  "client":"nicolas",
  "dateCreation":"2020-08-12",
  "pending":true,
  "product":"canudo",
  "value":10.00
 }
]
```

**pedidos-spring**

> $ cd pedido-quarkus
>
> $ ./mvnw spring-boot:run

Esse comando deve levar essa aplicação inicial.

Para validarmos devemos acessar no browser a seguinte URL.

> http://localhost:8080/order

Deve retornar um texto mais ou menos assim:

```
is runnig
```



