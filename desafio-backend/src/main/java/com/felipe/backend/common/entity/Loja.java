package com.felipe.backend.common.entity;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_LOJA")
@Slf4j
public class Loja {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer lojaId;
    private String nomeLoja;
    private String representante;

    @OneToMany(mappedBy="loja")
    private Set<Transacoes> transacoes;

}
