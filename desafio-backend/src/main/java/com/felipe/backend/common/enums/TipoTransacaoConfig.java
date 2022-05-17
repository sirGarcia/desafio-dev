package com.felipe.backend.common.enums;

public enum TipoTransacaoConfig {
    DEBITO(1, "Débito", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    BOLETO(2, "Boleto", NaturezaOperacao.SAIDA, OperadorOperacao.MINUS),
    FINANCIAMENTO(3, "Financiamento", NaturezaOperacao.SAIDA, OperadorOperacao.MINUS),
    CRÉDITO(4, "Crédito", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    EMPRESTIMORECEBIDO(5, "Recebimento de Empréstimo", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    VENDAS(6, "Vendas", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    TEDRECEBIDO(7, "Recebimento TED", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    DOCRECEBIDO(8, "Recebimento DOC", NaturezaOperacao.ENTRADA, OperadorOperacao.PLUS),
    ALUGUEL(9, "Aluguel", NaturezaOperacao.SAIDA, OperadorOperacao.MINUS);

    private final Integer tipo;
    private final String descricao;
    private final NaturezaOperacao naturezaOperacao;
    private final OperadorOperacao operadorOperacao;

    TipoTransacaoConfig(int tipo, String descricao,
                        NaturezaOperacao naturezaOperacao,
                        OperadorOperacao operadorOperacao){
        this.tipo = tipo;
        this.descricao = descricao;
        this.naturezaOperacao = naturezaOperacao;
        this.operadorOperacao = operadorOperacao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public NaturezaOperacao getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public OperadorOperacao getOperadorOperacao() {
        return operadorOperacao;
    }
}
