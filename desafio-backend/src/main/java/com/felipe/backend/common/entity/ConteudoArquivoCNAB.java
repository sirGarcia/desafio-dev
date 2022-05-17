package com.felipe.backend.common.entity;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_CONTEUDO_ARQUIVO_CNAB")
@Data
public class ConteudoArquivoCNAB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer conteudoId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "idArquivo", nullable = false)
    @JsonManagedReference
    private ArquivoCNAB arquivoCNAB;

    private String conteudoLinha;
}
