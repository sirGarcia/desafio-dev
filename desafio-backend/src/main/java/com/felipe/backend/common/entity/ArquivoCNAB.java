package com.felipe.backend.common.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_ARQUIVO_CNAB")
@Slf4j
public class ArquivoCNAB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer arquivoId;
    private String nome;
    private LocalDateTime dataInclusao;

    @OneToMany(mappedBy = "arquivoCNAB")
    private Set<ConteudoArquivoCNAB> conteudoArquivoCNABS;
}
