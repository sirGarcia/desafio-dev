package com.felipe.backend.common.entity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_CONTEUDO_ARQUIVO_CNAB")
@Slf4j
public class ConteudoArquivoCNAB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer conteudoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arquivoParaConteudo", nullable = false)
    private ArquivoCNAB arquivoCNAB;

    private String conteudoLinha;
}
