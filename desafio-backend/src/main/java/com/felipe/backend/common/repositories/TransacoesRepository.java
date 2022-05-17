package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacoesRepository extends CrudRepository<Transacoes, Integer> {
    List<Transacoes> findByLoja(Loja loja);
}
