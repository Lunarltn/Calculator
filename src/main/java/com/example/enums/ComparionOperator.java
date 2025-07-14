package com.example.enums;

/**
 * 비교연산에 사용되는 연산자 타입을 정의한 열거형
 *
 * <p>각 연산자는 해당 연산을 나타내는 기호 문자('>', '>=', '<', '<=', '==', '!=')와 함께 정의된다.</p>
 */
public enum ComparionOperator {
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    EQUAL("=="),
    NOT_EQUAL("!=");

    private final String symbol;

    ComparionOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * 비교 연산 기호를 {@code String}으로 받아 {@link ComparionOperator} 타입으로 반환한다.
     *
     * @param symbol 비교 연산자('>', '>=', '<', '<=', '==', '!=')
     * @return 입력받은 비교 연산자 {@code symbol}에 맞는 {@link ComparionOperator}로 반환
     * @throws IllegalArgumentException {@code symbol}에 맞는 연산자가 없는 경우
     */
    public static ComparionOperator fromSymbol(String symbol) throws IllegalArgumentException {
        for (ComparionOperator operator : ComparionOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("[Error] 올바른 비교연산 기호를 입력해 주세요.: " + symbol);
    }

    /**
     * 주어진 두 숫자 {@code n}과 {@code m}에 대해 현재 비교 연산자를 적용하여 {@code boolean}값을 반환한다.
     *
     * @param n 첫 번째 피연산자({@link Number})
     * @param m 두 번째 피연산자({@link Number})
     * @return 두 연산자를 비교해 {@code boolean}으로 반환
     */
    public boolean apply(Number n, Number m) {
        double dn = n.doubleValue();
        double dm = m.doubleValue();
        return switch (this) {
            case GREATER_THAN -> dn > dm;
            case GREATER_THAN_OR_EQUAL -> dn >= dm;
            case LESS_THAN -> dn < dm;
            case LESS_THAN_OR_EQUAL -> dn <= dm;
            case EQUAL -> dn == dm;
            case NOT_EQUAL -> dn != dm;
        };
    }
}
