package com.felipe.backend.controller;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.exception.BusinessExceptionBadRequest;
import com.felipe.backend.fabrica.FabricaNegocio;
import com.felipe.backend.fabrica.FabricaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path="/api/consulta")
public class ConsultaController {

    @Autowired
    FabricaServico fabricaServico;

    @GetMapping(value = "/transacao-por-loja")
    public List<Transacoes> getTransacoesbyLoja(
            @RequestParam String lojaId) throws BusinessExceptionBadRequest {
        Loja l = fabricaServico.getLojaService().getLojaById(lojaId);
        return fabricaServico.getTransacaoService().getTransacaoPorLoja(l);
    }

    @RequestMapping(value = "/lojas", method = RequestMethod.GET)
    public Iterable<Loja> getLojas(){
        return fabricaServico.getLojaService().getListaLoja();
    }
}
