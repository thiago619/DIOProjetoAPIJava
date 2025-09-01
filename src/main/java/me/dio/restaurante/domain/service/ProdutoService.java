package me.dio.restaurante.domain.service;

import java.util.List;

import me.dio.restaurante.domain.model.Produto;

public interface ProdutoService {
    public List<Produto> all();
    public Produto byId(Long id);
    public Produto create(Produto produto);
}
