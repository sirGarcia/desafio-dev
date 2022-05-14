package com.felipe.backend.common.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_CONTA_LOJA")
@Slf4j
public class ContaLoja {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ContaLojaId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lojaPrarConta", referencedColumnName = "lojaId")
    private Loja loja;

    private BigDecimal saldo;
}
