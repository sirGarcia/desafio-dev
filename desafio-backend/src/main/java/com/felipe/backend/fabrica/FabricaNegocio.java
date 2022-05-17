package com.felipe.backend.fabrica;

import com.felipe.backend.negocio.parsearquivo.ParseCNABFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaNegocio {

    @Autowired
    ParseCNABFile parseCNABFile;

    public ParseCNABFile getParseCNABFile() { return parseCNABFile; }
}
