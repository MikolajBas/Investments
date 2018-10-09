package fund;

public enum FundType {
    POLISH("Polish"),
    FOREIGN("Foreign"),
    MONEY("Money");

    private final String value;

    FundType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
