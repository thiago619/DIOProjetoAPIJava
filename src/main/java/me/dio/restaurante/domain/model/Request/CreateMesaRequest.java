package me.dio.restaurante.domain.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dio.restaurante.domain.model.Mesa;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMesaRequest {
    private Integer mesa;

    public Mesa toModel(){
        Mesa mesa = new Mesa();
        mesa.setMesa(this.mesa);
        return mesa;
    }
}
