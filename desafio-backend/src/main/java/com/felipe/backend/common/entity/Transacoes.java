package com.felipe.backend.common.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_TRANSACOES")
@Slf4j
public class Transacoes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer transacaoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoParaTransacao", nullable = false)
    private TipoTransacao tipoTransacao;

    private Long dataOcorrencia;
    private BigDecimal valorMovimentacao;
    private BigDecimal cpfBeneficiario;
    private BigDecimal cartao;
    private Long horaOcorrencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lojaParaTransacao", nullable = false)
    private Loja loja;

}