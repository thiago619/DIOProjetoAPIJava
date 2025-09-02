package me.dio.restaurante.domain.model.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreatePedidoRequest {
    @NotNull(message="mesa_id é obrigatório")
    private Long mesa_id;
    @NotNull(message="cliente_id é obrigatório")
    private Long cliente_id;
}
