package com.felipe.backend.arquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IArquivoCNABService {
    Iterable<ArquivoCNAB> getListArquivoCNAB();
    Iterable<ArquivoCNAB> getArquivoByNome(String nome);
    ArquivoCNAB insertArquivo(MultipartFile file) throws Exception;
}
