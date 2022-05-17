package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TransacoesRepository extends CrudRepository<Transacoes, Integer> {
    List<Transacoes> findByLoja(Loja loja);

    @Override
    default <S extends Transacoes> Iterable<S> saveAll(Iterable<S> entities){
        List<Loja> lojas = new ArrayList<>();
        for(Transacoes t : entities){
            if(lojas.stream().noneMatch(x -> x.getNomeLoja().equals(t.getLoja().getNomeLoja())
                    && x.getRepresentante().equals(t.getLoja().getRepresentante()))){
                lojas.add(t.getLoja());
            }
            else {
                t.setLoja(lojas.stream().filter(x -> x.getNomeLoja().equals(t.getLoja().getNomeLoja())
                        && x.getRepresentante().equals(t.getLoja().getRepresentante())).findFirst().get());
            }
            save(t);
        }
        return entities;
    }
}
