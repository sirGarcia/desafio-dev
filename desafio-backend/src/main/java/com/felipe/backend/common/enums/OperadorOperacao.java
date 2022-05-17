package com.felipe.backend.common.enums;

import java.util.function.DoubleBinaryOperator;

public enum OperadorOperacao implements DoubleBinaryOperator {
    PLUS("+", (l, r) -> l + r),
    MINUS("-", (l, r) -> l - r);

    private final String operador;
    private final DoubleBinaryOperator doubleBinaryOperator;

    OperadorOperacao(String operador, DoubleBinaryOperator doubleBinaryOperator){
        this.operador = operador;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    public String getOperador() {
        return operador;
    }

    @Override
    public double applyAsDouble(final double left, final double right) {
        return doubleBinaryOperator.applyAsDouble(left, right);
    }
}
