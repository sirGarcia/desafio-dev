package com.felipe.backend.common.fabrica;

import com.felipe.backend.arquivo.IArquivoCNABService;
import com.felipe.backend.conteudoArquivo.IConteudoArquivoService;
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
