package com.felipe.backend.negocio.persist;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import com.felipe.backend.common.helper.NegocioGeral;
import com.felipe.backend.common.repositories.ArquivoCNABRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PersistArquivo extends NegocioGeral<MultipartFile, ArquivoCNAB, ArquivoCNAB> {
    @Autowired
    ArquivoCNABRepository arquivoRepo;


    @Override
    protected void checkInputConfig(MultipartFile input) throws Exception {
        if(input == null || input.isEmpty()) throw new Exception("File is null");
    }

    @Override
    protected ArquivoCNAB execOperation(MultipartFile input) throws Exception {
        ArquivoCNAB arquivoEntity = new ArquivoCNAB();
        arquivoEntity.setDataInclusao(LocalDateTime.now());
        arquivoEntity.setNome(input.getOriginalFilename());
        return arquivoRepo.save(arquivoEntity);
    }

    @Override
    protected void checkBusiness(ArquivoCNAB output) throws Exception {

    }

    @Override
    protected ArquivoCNAB convertOutput(ArquivoCNAB output) throws Exception {
        return output;
    }
}
