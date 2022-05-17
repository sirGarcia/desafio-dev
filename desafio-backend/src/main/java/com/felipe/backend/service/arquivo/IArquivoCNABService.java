package com.felipe.backend.service.arquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.Transacoes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IArquivoCNABService {
    Iterable<ArquivoCNAB> getListArquivoCNAB();
    Iterable<ArquivoCNAB> getArquivoByNome(String nome);
    ArquivoCNAB insertArquivo(MultipartFile file) throws Exception;
    List<Transacoes> parseFile(MultipartFile file) throws Exception;
}
