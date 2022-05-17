package com.felipe.backend.service.contaloja;

import com.felipe.backend.common.entity.ContaLoja;
import com.felipe.backend.common.entity.Loja;

public interface IContaLojaService {
    Iterable<ContaLoja> getListaContaLoja();
    ContaLoja getContaLoja(Loja loja);
    ContaLoja insertContaLoja(ContaLoja contaLoja);
}
