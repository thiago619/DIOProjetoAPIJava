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
        Mesa mesaa = new Mesa();
        mesaa.setMesa(this.mesa);
        return mesaa;
    }
}
