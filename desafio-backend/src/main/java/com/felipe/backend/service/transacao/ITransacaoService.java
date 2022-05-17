package com.felipe.backend.service.transacao;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;

import java.util.List;

public interface ITransacaoService {
    Iterable<Transacoes> getAllTransacoes();
    List<Transacoes>getTransacaoPorLoja(Loja loja);
    List<Transacoes>insertTransacoes(List<Transacoes> transacoes);

}
