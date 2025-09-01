package me.dio.restaurante.domain.service;

import java.util.List;

import me.dio.restaurante.domain.model.Cliente;

public interface ClienteService {
    public Cliente create(Cliente cliente);
    public List<Cliente> all();
    public Cliente byId(Long id);
}
