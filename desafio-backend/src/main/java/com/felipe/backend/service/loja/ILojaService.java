package com.felipe.backend.service.loja;

import com.felipe.backend.common.entity.Loja;

public interface ILojaService {
    Iterable<Loja> getListaLoja();
    Loja insertLoja(Loja loja);
    Loja getLojaById(String id);
}
