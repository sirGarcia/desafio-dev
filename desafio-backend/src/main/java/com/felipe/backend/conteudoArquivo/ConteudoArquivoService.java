package com.felipe.backend.conteudoArquivo;

import com.felipe.backend.arquivo.IArquivoCNABService;
import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import com.felipe.backend.common.repositories.ConteudoArquivoCNABRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ConteudoArquivoService implements IConteudoArquivoService {
    @Autowired
    ConteudoArquivoCNABRepository conteudoArquivoRepo;

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
}
