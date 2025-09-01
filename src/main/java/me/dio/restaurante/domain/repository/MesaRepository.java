package me.dio.restaurante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.restaurante.domain.model.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long>{

}
