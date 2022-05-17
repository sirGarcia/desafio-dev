package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.Loja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LojaRepository extends CrudRepository<Loja, Integer> {
    Loja findByNomeLoja(String nomeLoja);
}
