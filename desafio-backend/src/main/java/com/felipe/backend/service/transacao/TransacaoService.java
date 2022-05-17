package com.felipe.backend.service.transacao;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransacaoService implements ITransacaoService{
    @Autowired
    TransacoesRepository transacoesRepo;

    @Override
    public Iterable<Transacoes> getAllTransacoes() {
        return transacoesRepo.findAll();
    }

    @Override
    public List<Transacoes> getTransacaoPorLoja(Loja loja) {
        return transacoesRepo.findByLoja(loja);
    }

    @Override
    public List<Transacoes> insertTransacoes(List<Transacoes> transacoes) {
        return (List<Transacoes>) transacoesRepo.saveAll(transacoes);
    }
}
