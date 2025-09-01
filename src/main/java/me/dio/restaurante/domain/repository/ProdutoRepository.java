package me.dio.restaurante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.restaurante.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
