package me.dio.restaurante.domain.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dio.restaurante.domain.model.Cliente;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateClienteRequest {
    private String nome;
    private String cpf;

    public Cliente toModel(){
        Cliente cliente = new Cliente();
        cliente.setCpf(this.cpf);
        cliente.setNome(this.nome);
        return cliente;
    }
}
