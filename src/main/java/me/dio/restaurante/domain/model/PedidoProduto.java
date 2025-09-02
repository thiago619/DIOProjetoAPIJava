package me.dio.restaurante.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoProduto {
    @EmbeddedId
    private PedidoProdutoId id;

    @ManyToOne
    @MapsId("produto_id")
    private Produto produto;

    @ManyToOne
    @MapsId("pedido_id")
    private Pedido pedido;

    private Integer quantidade;
}
