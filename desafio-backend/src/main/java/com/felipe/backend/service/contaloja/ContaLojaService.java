package com.felipe.backend.service.contaloja;

import com.felipe.backend.common.entity.ContaLoja;
import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.repositories.ContaLojaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContaLojaService implements IContaLojaService{
    @Autowired
    ContaLojaRepository contaLojaRepo;

    @Override
    public Iterable<ContaLoja> getListaContaLoja() {
        return contaLojaRepo.findAll();
    }

    @Override
    public ContaLoja getContaLoja(Loja loja) {
        return contaLojaRepo.findByLoja(loja);
    }

    @Override
    public ContaLoja insertContaLoja(ContaLoja contaLoja) {
        return contaLojaRepo.save(contaLoja);
    }
}
