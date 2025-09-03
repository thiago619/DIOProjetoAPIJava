package me.dio.restaurante.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.exception.ClienteNotFoundException;
import me.dio.restaurante.domain.model.Cliente;
import me.dio.restaurante.domain.repository.ClienteRepository;
import me.dio.restaurante.domain.service.ClienteService;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente cliente) {
        var clienteCriado = this.clienteRepository.save(cliente);
        return clienteCriado;
    }

    @Override
    public List<Cliente> all() {
        var clientes = this.clienteRepository.findAll();
        return clientes;
    }

    @Override
    public Cliente byId(Long id) {
        var cliente = this.clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
        return cliente;
    }

}
