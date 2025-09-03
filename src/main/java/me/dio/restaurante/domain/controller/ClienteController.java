package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Cliente;
import me.dio.restaurante.domain.model.Request.CreateClienteRequest;
import me.dio.restaurante.domain.service.ClienteService;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "APIs para gerenciar clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Operation(summary = "Retorna todos os clientes", description = "Retorna todos os clientes")
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> all(){
        var clientes = this.clienteService.all();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Retorna um cliente pelo id", description = "Retorna um cliente pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> byId(@PathVariable Long id){
        var cliente = this.clienteService.byId(id);
        return ResponseEntity.ok(cliente);

    }

    @Operation(summary = "Cadastra um cliente", description = "Cadastra um cliente")
    @PostMapping("/")
    public ResponseEntity<Cliente> create(@RequestBody CreateClienteRequest cliente){
        var clienteCriado = this.clienteService.create(cliente.toModel());
        return ResponseEntity.ok(clienteCriado);
    }

}
