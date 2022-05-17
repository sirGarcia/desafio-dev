package com.felipe.backend.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipe.backend.common.enums.TipoTransacaoConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_TRANSACOES")
@Data
@Slf4j
public class Transacoes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer transacaoId;

    @Enumerated(EnumType.ORDINAL)
    private TipoTransacaoConfig tipoTransacao;

    private Long dataOcorrencia;
    private Double valorMovimentacao;
    private Long cpfBeneficiario;
    private String cartao;
    private Long horaOcorrencia;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "transacaoToLoja", nullable = false)
    private Loja loja;

}