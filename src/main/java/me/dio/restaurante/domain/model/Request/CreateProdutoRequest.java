package me.dio.restaurante.domain.model.Request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dio.restaurante.domain.model.Produto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProdutoRequest {
    @NotNull(message="descrição é obrigatória")
    private String descricao;
    @NotNull(message="preço é obrigatório")
    @Min(value=1)
    private BigDecimal preco;

    public Produto toModel(){
        Produto produto = new Produto();
        produto.setPreco(this.preco);
        produto.setDescricao(this.descricao);
        return produto;
    }
}
