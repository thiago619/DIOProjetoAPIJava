package me.dio.restaurante.domain.service;

import java.util.List;

import me.dio.restaurante.domain.model.Mesa;

public interface MesaService {
    public List<Mesa> all();
    public Mesa byId(Long id);
    public Mesa create(Mesa mesa);
}
