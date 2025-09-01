package me.dio.restaurante.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Produto;
import me.dio.restaurante.domain.repository.ProdutoRepository;
import me.dio.restaurante.domain.service.ProdutoService;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{
    private final ProdutoRepository produtoRepository;

    @Override
    public List<Produto> all() {
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto byId(Long id) {
        Produto produto = this.produtoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return produto;
    }

    @Override
    public Produto create(Produto produto) {
        var produtoCriado = this.produtoRepository.save(produto);
        return produtoCriado;
    }

}
