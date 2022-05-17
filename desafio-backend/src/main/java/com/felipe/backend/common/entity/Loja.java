package com.felipe.backend.common.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_LOJA")
@Data
public class Loja {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer lojaId;
    private String nomeLoja;
    private String representante;
    private Double saldo;

    @OneToMany(mappedBy="loja")
    @JsonBackReference
    private Set<Transacoes> transacoes;



}
