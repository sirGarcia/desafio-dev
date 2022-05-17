package com.felipe.backend.negocio.persist;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.helper.NegocioGeral;
import com.felipe.backend.common.repositories.LojaRepository;
import com.felipe.backend.common.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PersistTransacoes extends NegocioGeral<List<Transacoes>, List<Transacoes>, List<Transacoes>> {
    @Autowired
    LojaRepository lojaRepo;

    @Autowired
    TransacoesRepository transacoesRepo;

    @Override
    protected void checkInputConfig(List<Transacoes> input) throws Exception {
        if(input == null || input.isEmpty()) throw new Exception("Missing transactions to persist");
    }

    @Override
    protected List<Transacoes> execOperation(List<Transacoes> input) throws Exception {
        Iterable<Transacoes> transacoes = transacoesRepo.saveAll(getPersistedLoja(input));
        return StreamSupport.stream(transacoes.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    protected void checkBusiness(List<Transacoes> output) throws Exception {

    }

    @Override
    protected List<Transacoes> convertOutput(List<Transacoes> output) throws Exception {
        return output;
    }

    public Iterable<Transacoes> getPersistedLoja(List<Transacoes> input){
        List<Loja> lojas = StreamSupport.stream(lojaRepo.findAll().spliterator(), false).collect(Collectors.toList());
        for(Transacoes t : input){
            Loja loja = t.getLoja();
            if(lojas.stream().noneMatch(x -> x.getLojaId().equals(loja.getLojaId()))){
                t.setLoja(lojaRepo.save(loja));
            }else {
                Loja s = lojaRepo.findById(loja.getLojaId()).get();
                Double saldo = t.getTipoTransacao().getOperadorOperacao().applyAsDouble(s.getSaldo(), t.getValorMovimentacao());
                s.setSaldo(saldo);
                t.setLoja(lojaRepo.save(s));
            }
        }
        return input;
    }
}
