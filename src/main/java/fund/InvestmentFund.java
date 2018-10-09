package fund;

public final class InvestmentFund {

    private Long id;

    private String name;

    private FundType fundType;

    private InvestmentFund(Long id, String name, FundType fundType) {
        this.id = id;
        this.name = name;
        this.fundType = fundType;
    }

    public static InvestmentFund createFund(Long id, String name, FundType fundType) {
        return new InvestmentFund(id, name, fundType);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FundType getFundType() {
        return fundType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestmentFund that = (InvestmentFund) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
