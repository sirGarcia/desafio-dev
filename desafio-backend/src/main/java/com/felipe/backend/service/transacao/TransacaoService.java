package com.felipe.backend.service.transacao;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.repositories.TransacoesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

}
