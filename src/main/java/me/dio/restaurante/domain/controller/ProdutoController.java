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
import me.dio.restaurante.domain.model.Produto;
import me.dio.restaurante.domain.model.Request.CreateProdutoRequest;
import me.dio.restaurante.domain.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
@Tag(name = "Produto", description = "APIs para gerenciar produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping("/")
    @Operation(summary = "Retorna todos os produtos cadastrados", description = "Retorna todos os produtos cadastrados")
    public ResponseEntity<List<Produto>> all(){
        var produtos = this.produtoService.all();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um produto pelo id", description = "Retorna um produto pelo id")
    public ResponseEntity<Produto> byId(@PathVariable Long id){
        var produto = produtoService.byId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastra um produto", description = "Cadastra um produto")
    public ResponseEntity<Produto> create(@RequestBody CreateProdutoRequest produto){
        var produtoCriado = this.produtoService.create(produto.toModel());
        return ResponseEntity.ok(produtoCriado);
    }
}
