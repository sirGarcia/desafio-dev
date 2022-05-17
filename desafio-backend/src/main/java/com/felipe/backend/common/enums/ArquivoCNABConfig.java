package com.felipe.backend.common.enums;

public enum ArquivoCNABConfig {
    TIPO("Tipo", 1, 1, 1),
    DATA("Data", 2, 8, 9),
    VALOR("Valor", 10, 10, 19),
    CPF("CPF", 20, 11, 30),
    CARTAO("Cartão", 31, 12, 42),
    HORA("Hora", 43, 6, 48),
    REPRESENTANTE("Representante", 49, 14, 62),
    NOMELOJA("Nome da Loja", 63, 19, 81);


    private final String descricao;
    private final int inicio;
    private final int tamanho;
    private final int fim;

    ArquivoCNABConfig(String descricao, int inicio, int tamanho, int fim){
        this.descricao = descricao;
        this.inicio = inicio;
        this.tamanho = tamanho;
        this.fim = fim;
    }

    public int getIndexFim() {
        return fim - 1;
    }
    public int getValueFim() {
        return fim;
    }

    public int getIndexInicio() {
        return inicio -1 ;
    }

    public int getValueInicio() {
        return inicio -1 ;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTamanho() {
        return tamanho;
    }
}
