package com.felipe.backend.service.arquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import org.springframework.web.multipart.MultipartFile;


public interface IArquivoCNABService {
    Iterable<ArquivoCNAB> getListArquivoCNAB();
    Iterable<ArquivoCNAB> getArquivoByNome(String nome);
    ArquivoCNAB insertArquivo(MultipartFile file) throws Exception;
}
