package me.dio.restaurante.domain.model;


import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private Integer mesa;
    @Formula("(SELECT EXISTS(SELECT * FROM pedido WHERE pedido.mesa_id=id AND pedido.fechado_em IS NULL))")
    private Boolean aberta;
}
