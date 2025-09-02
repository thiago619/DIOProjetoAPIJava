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
import me.dio.restaurante.domain.model.Produto;
import me.dio.restaurante.domain.model.Request.CreateProdutoRequest;
import me.dio.restaurante.domain.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping("/")
    public ResponseEntity<List<Produto>> all(){
        var produtos = this.produtoService.all();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> byId(@PathVariable Long id){
        var produto = produtoService.byId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/")
    public ResponseEntity<Produto> create(@RequestBody CreateProdutoRequest produto){
        var produtoCriado = this.produtoService.create(produto.toModel());
        return ResponseEntity.ok(produtoCriado);
    }
}
