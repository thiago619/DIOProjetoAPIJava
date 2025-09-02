package me.dio.restaurante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.restaurante.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{

}
