package me.dio.restaurante.domain.service.impl;


import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.exception.CupomFiscalNotFoundException;
import me.dio.restaurante.domain.model.CupomFiscal;
import me.dio.restaurante.domain.repository.CupomFiscalRepository;
import me.dio.restaurante.domain.service.CupomFiscalService;

@AllArgsConstructor
@Service
public class CupomFiscalServiceImpl implements CupomFiscalService{
    private final CupomFiscalRepository cupomFiscalRepository;

    @Override
    public CupomFiscal byId(Long id) {
        var cupom = this.cupomFiscalRepository.findById(id).orElseThrow(CupomFiscalNotFoundException::new);
        return cupom;
    }

    @Override
    public CupomFiscal create(BigDecimal value) {
        if(value.doubleValue() < 1) throw new RuntimeException("Notas com valor menor que 1 não são emitidas");
        CupomFiscal cupomFiscal = new CupomFiscal();
        cupomFiscal.setDataEmissao(ZonedDateTime.now());
        cupomFiscal.setValor(value);
        cupomFiscal = this.cupomFiscalRepository.save(cupomFiscal);
        return cupomFiscal;
    }

}
