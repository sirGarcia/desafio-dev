package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.ArquivoCNAB;
import org.springframework.data.repository.CrudRepository;

public interface ArquivoCNABRepository extends CrudRepository<ArquivoCNAB, Integer> {
    Iterable<ArquivoCNAB> findByNome (String nome);
}
