package com.felipe.backend.common.entity;

import com.felipe.backend.common.enums.NaturezaOperacao;
import com.felipe.backend.common.enums.OperadorOperacao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_TIPO_TRANSACAO")
@Data
@Slf4j
public class TipoTransacao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer tipoTransacaoId;
    private long tipo;
    private String descricao;
    @Enumerated(EnumType.ORDINAL)
    private NaturezaOperacao natureza;
    @Enumerated(EnumType.ORDINAL)
    private OperadorOperacao operacao;

    @OneToMany(mappedBy = "tipoTransacao")
    private Set<Transacoes> transacoes;
}
