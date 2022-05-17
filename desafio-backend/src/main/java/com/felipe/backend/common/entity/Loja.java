package com.felipe.backend.common.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "TB_LOJA")
@Data
public class Loja {
    @Id
    private String lojaId;
    private String nomeLoja;
    private String representante;
    private Double saldo;

    @OneToMany(mappedBy="loja")
    @JsonBackReference
    private Set<Transacoes> transacoes;

    public Loja (String nomeLoja, String representante){
        this.nomeLoja = nomeLoja;
        this.representante = representante;
        this.saldo = (double) 0;
        this.lojaId = gerarId();
    }
    public Loja(){

    }
    private String gerarId(){
        String base = this.nomeLoja + this.representante;
        return new String(Base64.encodeBase64(base.getBytes(StandardCharsets.UTF_8)));
    }

}
