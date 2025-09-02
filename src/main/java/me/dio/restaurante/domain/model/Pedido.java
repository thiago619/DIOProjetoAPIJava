package me.dio.restaurante.domain.model;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pedido")
    private Set<PedidoProduto> pedidoProduto = new HashSet<>();
    private ZonedDateTime abertoEm;
    private ZonedDateTime fechadoEm;
    @ManyToOne
    @JoinColumn(name="cupom_id")
    private CupomFiscal cupomFiscal;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="mesa_id")
    private Mesa mesa;
}
