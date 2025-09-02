package me.dio.restaurante.domain.model.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddProdutotoPedidoRequest {
    @NotNull(message = "pedido_id é obrigatório")
    private Long pedido_id;
    @NotNull(message = "produto_id é obrigatório")
    private Long produto_id;
    @Min(value = 1)
    private int quantidade;
}
