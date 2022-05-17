package com.felipe.backend.fabrica;

import com.felipe.backend.negocio.parsearquivo.ParseCNABFile;
import com.felipe.backend.negocio.persist.PersistArquivo;
import com.felipe.backend.negocio.persist.PersistTransacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaNegocio {

    @Autowired
    ParseCNABFile parseCNABFile;
    @Autowired
    PersistArquivo persistArquivo;
    @Autowired
    PersistTransacoes persistTransacoes;

    public ParseCNABFile getParseCNABFile() { return parseCNABFile; }

    public PersistArquivo getPersistArquivo() {
        return persistArquivo;
    }
    public PersistTransacoes getPersistTransacoes() {
        return persistTransacoes;
    }
}
