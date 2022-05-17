package com.felipe.backend.service.arquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.repositories.ArquivoCNABRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Service
public class ArquivoCNABService implements IArquivoCNABService {
    @Autowired
    ArquivoCNABRepository arquivoRepo;

    public Iterable<ArquivoCNAB> getListArquivoCNAB(){
        return arquivoRepo.findAll();
    }

    public Iterable<ArquivoCNAB> getArquivoByNome(String nome){return arquivoRepo.findByNome(nome);}

    public ArquivoCNAB insertArquivo(MultipartFile file) throws Exception{
        ArquivoCNAB arquivoEntity = new ArquivoCNAB();
        arquivoEntity.setDataInclusao(LocalDateTime.now());
        arquivoEntity.setNome(file.getOriginalFilename());
        return arquivoRepo.save(arquivoEntity);
    }
}
