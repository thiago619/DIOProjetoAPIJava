package me.dio.restaurante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.restaurante.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
