package com.felipe.backend.negocio.persist;

import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import com.felipe.backend.common.helper.NegocioGeral;
import com.felipe.backend.common.helper.PersistConteudoDTO;
import com.felipe.backend.common.repositories.ArquivoCNABRepository;
import com.felipe.backend.common.repositories.ConteudoArquivoCNABRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersistConteudoArquivo extends NegocioGeral<PersistConteudoDTO, List<ConteudoArquivoCNAB>, List<ConteudoArquivoCNAB>> {
    @Autowired
    ConteudoArquivoCNABRepository conteudoRepo;

    @Override
    protected void checkInputConfig(PersistConteudoDTO input) throws Exception {
        if(input.getFile() == null || input.getFile().isEmpty()) throw new Exception("File is null or empty");
        if(input.getArquivo() == null || input.getArquivo().getNome().isEmpty())throw new Exception("Missing persisted ArquivoCNABEntity");
    }

    @Override
    protected List<ConteudoArquivoCNAB> execOperation(PersistConteudoDTO input) throws Exception {
        List<ConteudoArquivoCNAB> inseridos = new ArrayList<>();
        String content = new String(input.getFile().getBytes(), StandardCharsets.UTF_8);
        for(String line : content.split("\\n")){
            ConteudoArquivoCNAB conteudo = new ConteudoArquivoCNAB();
            conteudo.setArquivoCNAB(input.getArquivo());
            conteudo.setConteudoLinha(line);
            conteudoRepo.save(conteudo);
            inseridos.add(conteudo);
        }
        return inseridos;
    }

    @Override
    protected void checkBusiness(List<ConteudoArquivoCNAB> output) throws Exception {

    }

    @Override
    protected List<ConteudoArquivoCNAB> convertOutput(List<ConteudoArquivoCNAB> output) throws Exception {
        return output;
    }
}
