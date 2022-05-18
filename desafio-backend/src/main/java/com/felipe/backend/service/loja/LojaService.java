package com.felipe.backend.service.loja;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.exception.BusinessExceptionBadRequest;
import com.felipe.backend.common.exception.BusinessExceptionServer;
import com.felipe.backend.common.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LojaService implements ILojaService{
    @Autowired
    LojaRepository lojaRepo;

    @Override
    public Iterable<Loja> getListaLoja()throws BusinessExceptionServer {
       return lojaRepo.findAll();
    }

    @Override
    public Loja insertLoja(Loja loja) throws BusinessExceptionBadRequest {
        return lojaRepo.save(loja);
    }

    @Override
    public Loja getLojaById(String id) throws BusinessExceptionBadRequest {
        return lojaRepo.findById(id).get();
    }
}
