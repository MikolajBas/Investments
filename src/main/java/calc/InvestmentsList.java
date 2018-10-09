package calc;

import fund.FundType;
import fund.InvestmentFund;

import java.util.List;
import java.util.stream.Collectors;

public class InvestmentsList {

    public List<InvestmentFund> investmentFunds;

    public InvestmentsList(List<InvestmentFund> investmentFunds) {
        this.investmentFunds = investmentFunds;
    }

    public List<InvestmentFund> getInvestmentFundsByFundType(FundType fundType) {
        return investmentFunds.stream()
                .filter(el -> el.getFundType().equals(fundType))
                .collect(Collectors.toList());
    }

    public Integer countFundQuantityForType(FundType fundType) {
        return (int)(investmentFunds.stream()
                .map(el -> el.getFundType())
                .filter(type -> type.equals(fundType))
                .count());
    }
}
