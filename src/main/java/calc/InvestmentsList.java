package calc;

import fund.FundType;
import fund.InvestmentFund;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvestmentsList {

    public List<InvestmentFund> investmentFunds;

    public InvestmentsList(List<InvestmentFund> investmentFunds) {
        this.investmentFunds = investmentFunds;
    }

    public Map<FundType, Integer> countQuantityByType() {
        Map<FundType, Integer> quantityByType = new HashMap<>();
        for(FundType fundType: FundType.values()) {
            quantityByType.put(fundType, countQuantity(fundType));
        }
        return Collections.unmodifiableMap(quantityByType);
    }

    public List<InvestmentFund> getInvestmentFundsByFundType(FundType fundType) {
        return investmentFunds.stream()
                .filter(el -> el.getFundType().equals(fundType))
                .collect(Collectors.toList());
    }

    public Integer countQuantity(FundType fundType) {
        return (int)(investmentFunds.stream()
                .map(el -> el.getFundType())
                .filter(type -> type.equals(fundType))
                .count());
    }
}
