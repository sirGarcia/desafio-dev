package com.felipe.backend.common.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_CONTA_LOJA")
@Data
public class ContaLoja {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ContaLojaId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loja_id")
    private Loja loja;

    private BigDecimal saldo;
}
