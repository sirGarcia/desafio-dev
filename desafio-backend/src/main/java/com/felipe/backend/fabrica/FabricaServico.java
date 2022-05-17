package com.felipe.backend.fabrica;

import com.felipe.backend.service.arquivo.IArquivoCNABService;
import com.felipe.backend.service.conteudoArquivo.IConteudoArquivoService;
import com.felipe.backend.service.loja.ILojaService;
import com.felipe.backend.service.transacao.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaServico {
    @Autowired
    IArquivoCNABService arquivoCNABService;

    @Autowired
    IConteudoArquivoService conteudoService;

    @Autowired
    ITransacaoService transacaoService;

    @Autowired
    ILojaService lojaService;

    public IArquivoCNABService getArquivoCNABService() {
        return arquivoCNABService;
    }

    public IConteudoArquivoService getConteudoService() {
        return conteudoService;
    }

    public ITransacaoService getTransacaoService() {
        return transacaoService;
    }
    public ILojaService getLojaService() {
        return lojaService;
    }
}
