# API de restaurante.

Este projeto é uma API genérica de sistema de restaurante. Contempla a marcação, impressão pagamento, emissão do cupom fiscal e fechamento.

## Mapa de entidades

´´´mermaid
classDiagram
    class Cliente {
        +id: int
        +nome: string
        +cpf: string
    }

    class Mesa {
        +id: int
        +numero: int
        +status: string
    }

    class Pedido {
        +id: int
        +dataHora: datetime
        +status: string
    }

    class Produto {
        +id: int
        +nome: string
        +preco: float
    }

    class CupomFiscal {
        +id: int
        +valorTotal: float
        +dataEmissao: datetime
    }

    %% Relações
    Cliente "1" --> "0..*" Pedido : faz
    Mesa "1" --> "0..*" Pedido : recebe
    Pedido "1" --> "1..*" Produto : contém
    Pedido "1" --> "0..1" CupomFiscal : gera
´´´

## Diagrama de estado do Pedido

´´´mermaid
stateDiagram-v2
    [*] --> Aberto : Cliente faz pedido

    Aberto --> Fechado : Cliente pede para fechar conta
    Fechado --> Recebido : Cliente paga a conta

    Aberto : Pedido em andamento
    Fechado : Conta fechada, aguardando pagamento
    Recebido : Conta paga
´´´

## Diagrama de estado da mesa

´´´mermaid
stateDiagram-v2
    [*] --> Livre : Sem pedidos abertos

    Livre --> Ocupada : Cliente faz pedido
    Ocupada --> Livre : Todos os pedidos são fechados/pagos

    Livre : Mesa disponível
    Ocupada : Mesa em uso (pedido aberto)
´´´