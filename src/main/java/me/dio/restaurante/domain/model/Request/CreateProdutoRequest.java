package me.dio.restaurante.domain.model.Request;

import java.math.BigDecimal;

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
    private String descricao;
    private BigDecimal preco;

    public Produto toModel(){
        Produto produto = new Produto();
        produto.setPreco(this.preco);
        produto.setDescricao(this.descricao);
        return produto;
    }
}
