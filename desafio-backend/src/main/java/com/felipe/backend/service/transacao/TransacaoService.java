package com.felipe.backend.service.transacao;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.exception.BusinessExceptionBadRequest;
import com.felipe.backend.common.exception.BusinessExceptionServer;
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
    public Iterable<Transacoes> getAllTransacoes() throws BusinessExceptionServer {
        return transacoesRepo.findAll();
    }

    @Override
    public List<Transacoes> getTransacaoPorLoja(Loja loja)throws BusinessExceptionBadRequest {
        return transacoesRepo.findByLoja(loja);
    }

}
