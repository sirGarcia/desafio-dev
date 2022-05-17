package com.felipe.backend.controller;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.fabrica.FabricaNegocio;
import com.felipe.backend.fabrica.FabricaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path="/api/parsefile")
public class FileController {
    @Autowired
    FabricaNegocio fabricaNegocio;

    @Autowired
    FabricaServico fabricaServico;

    @RequestMapping(value = "/inserirArquivo", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public List<Transacoes> parseFile(@RequestPart("file") MultipartFile file) throws Exception{
        return fabricaServico.getArquivoCNABService().parseFile(file);
    }

    @RequestMapping(value = "/persistFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public List<Transacoes> parseAndPersistFile(@RequestPart("file") MultipartFile file) throws Exception{
        return fabricaServico.getArquivoCNABService().parseFile(file);
    }

}
