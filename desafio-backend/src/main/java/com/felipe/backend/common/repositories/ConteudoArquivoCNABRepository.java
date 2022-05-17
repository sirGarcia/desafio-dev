package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.ArquivoCNAB;
import com.felipe.backend.common.entity.ConteudoArquivoCNAB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConteudoArquivoCNABRepository extends CrudRepository<ConteudoArquivoCNAB, Integer> {
    List<ConteudoArquivoCNAB> findByArquivoCNAB(ArquivoCNAB arquivoCNAB);
}
