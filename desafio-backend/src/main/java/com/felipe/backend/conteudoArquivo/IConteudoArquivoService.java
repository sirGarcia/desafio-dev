package com.felipe.backend.conteudoArquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IConteudoArquivoService {
    List<ConteudoArquivoCNAB> insertConteudo(ArquivoCNAB arquivo, MultipartFile file) throws Exception;
}
