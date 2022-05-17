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
    public List<ConteudoArquivoCNAB> getConteudoByArquivo(ArquivoCNAB arquivoCNAB){
        return conteudoArquivoRepo.findByArquivoCNAB(arquivoCNAB);
    }
}
