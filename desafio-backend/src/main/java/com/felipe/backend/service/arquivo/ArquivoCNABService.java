package com.felipe.backend.service.arquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.repositories.ArquivoCNABRepository;
import com.felipe.backend.fabrica.FabricaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArquivoCNABService implements IArquivoCNABService {
    @Autowired
    FabricaNegocio fabricaNegocio;

    @Autowired
    ArquivoCNABRepository arquivoRepo;

    public Iterable<ArquivoCNAB> getListArquivoCNAB(){
        return arquivoRepo.findAll();
    }

    public Iterable<ArquivoCNAB> getArquivoByNome(String nome){return arquivoRepo.findByNome(nome);}

    public ArquivoCNAB insertArquivo(MultipartFile file) throws Exception{
        return fabricaNegocio.getPersistArquivo().exec(file);
    }

    public List<Transacoes> parseFile(MultipartFile file) throws Exception{
        List<Transacoes> transacoes = fabricaNegocio.getParseCNABFile().exec(file);
        return fabricaNegocio.getPersistTransacoes().exec(transacoes);
    }
}
