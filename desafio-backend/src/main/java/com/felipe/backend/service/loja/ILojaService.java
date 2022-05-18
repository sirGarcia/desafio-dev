package com.felipe.backend.service.loja;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.exception.BusinessExceptionBadRequest;
import com.felipe.backend.common.exception.BusinessExceptionServer;

public interface ILojaService {
    Iterable<Loja> getListaLoja() throws BusinessExceptionServer;
    Loja insertLoja(Loja loja) throws BusinessExceptionBadRequest;
    Loja getLojaById(String id)throws BusinessExceptionBadRequest;
}
