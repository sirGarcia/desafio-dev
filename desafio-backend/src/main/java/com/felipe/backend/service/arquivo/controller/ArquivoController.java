package com.felipe.backend.service.arquivo.controller;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import com.felipe.backend.fabrica.FabricaServico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@Slf4j

@RequestMapping(path="/oldApi")
public class ArquivoController {
    @Autowired
    private FabricaServico fabrica;

    @GetMapping("/listarArquivos")
    public @ResponseBody Iterable<ArquivoCNAB> listarArquivos() {
        return fabrica.getArquivoCNABService().getListArquivoCNAB();
    }

    @RequestMapping(value = "/inserirArquivo", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public List<ConteudoArquivoCNAB> newArquivo(@RequestPart("file") MultipartFile file) throws Exception {
        ArquivoCNAB arquivoEntity = fabrica.getArquivoCNABService().insertArquivo(file);
        return fabrica.getConteudoService().insertConteudo(arquivoEntity, file);
    }
}
