package com.felipe.backend.service.conteudoArquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import com.felipe.backend.common.repositories.ConteudoArquivoCNABRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ConteudoArquivoService implements IConteudoArquivoService {

    @Autowired
    ConteudoArquivoCNABRepository conteudoArquivoRepo;

    @Override
    public List<ConteudoArquivoCNAB> insertConteudo(ArquivoCNAB arquivo, MultipartFile file) throws Exception{
        List<ConteudoArquivoCNAB> inseridos = new ArrayList<>();
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        for(String line : content.split("\\r?\\n")){
            ConteudoArquivoCNAB conteudo = new ConteudoArquivoCNAB();
            conteudo.setArquivoCNAB(arquivo);
            conteudo.setConteudoLinha(line);
            conteudoArquivoRepo.save(conteudo);
            inseridos.add(conteudo);
        }
        return inseridos;
    }

    @Override
    public List<ConteudoArquivoCNAB> getConteudoByArquivo(ArquivoCNAB arquivoCNAB){
        return conteudoArquivoRepo.findByArquivoCNAB(arquivoCNAB);
    }
}
