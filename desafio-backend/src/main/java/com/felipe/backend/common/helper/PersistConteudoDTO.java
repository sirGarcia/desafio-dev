package com.felipe.backend.common.helper;

import com.felipe.backend.common.entity.ArquivoCNAB;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PersistConteudoDTO {
    MultipartFile file;
    ArquivoCNAB arquivo;

    public PersistConteudoDTO(MultipartFile file, ArquivoCNAB arquvio){
        this.file = file;
        this.arquivo = arquvio;
    }
}
