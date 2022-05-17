package com.felipe.backend.common.repositories;

import com.felipe.backend.common.entity.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface LojaRepository extends CrudRepository<Loja, String> {
    Loja findByNomeLoja(String nomeLoja);

}
