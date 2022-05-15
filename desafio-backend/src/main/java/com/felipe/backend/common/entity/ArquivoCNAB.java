package com.felipe.backend.common.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_ARQUIVO_CNAB")
@Data
public class ArquivoCNAB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer arquivoId;
    private String nome;
    private LocalDateTime dataInclusao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "arquivoCNAB")
    @JsonBackReference
    private Set<ConteudoArquivoCNAB> conteudoArquivoCNABS;
}
