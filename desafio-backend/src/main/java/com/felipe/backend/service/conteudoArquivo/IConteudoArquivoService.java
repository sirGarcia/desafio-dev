package com.felipe.backend.service.conteudoArquivo;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IConteudoArquivoService {
    List<ConteudoArquivoCNAB> getConteudoByArquivo(ArquivoCNAB arquivoCNAB);
}
