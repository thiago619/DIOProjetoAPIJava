package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Cliente;
import me.dio.restaurante.domain.model.Request.CreateClienteRequest;
import me.dio.restaurante.domain.service.ClienteService;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> all(){
        var clientes = this.clienteService.all();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> byId(@PathVariable Long id){
        var cliente = this.clienteService.byId(id);
        return ResponseEntity.ok(cliente);

    }

    @PostMapping("/")
    public ResponseEntity<Cliente> create(@RequestBody CreateClienteRequest cliente){
        var clienteCriado = this.clienteService.create(cliente.toModel());
        return ResponseEntity.ok(clienteCriado);
    }

}
