package com.felipe.backend.fabrica;

import com.felipe.backend.service.arquivo.IArquivoCNABService;
import com.felipe.backend.service.conteudoArquivo.IConteudoArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaServico {
    @Autowired
    IArquivoCNABService arquivoCNABService;

    @Autowired
    IConteudoArquivoService conteudoService;

    public IArquivoCNABService getArquivoCNABService() {
        return arquivoCNABService;
    }

    public IConteudoArquivoService getConteudoService() {
        return conteudoService;
    }
}
