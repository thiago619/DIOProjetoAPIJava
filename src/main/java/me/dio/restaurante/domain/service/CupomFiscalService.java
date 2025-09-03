package me.dio.restaurante.domain.service;

import java.math.BigDecimal;

import me.dio.restaurante.domain.model.CupomFiscal;

public interface CupomFiscalService {
    public CupomFiscal byId(Long id);
    public CupomFiscal create(BigDecimal value);
}
