package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.Transacoes;
import org.springframework.data.repository.CrudRepository;

public interface TransacoesRepository extends CrudRepository<Transacoes, Integer> {
}
