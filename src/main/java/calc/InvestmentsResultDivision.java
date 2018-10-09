package calc;

import fund.InvestmentFund;

import java.util.Map;
import java.util.stream.Collectors;

public class InvestmentsResultDivision {

    private int notDividedAmount;

    private Map<InvestmentFund, Integer> amountsAssignedToFunds;

    private Map<InvestmentFund, Double> percantageOfAmountsAssignedToFunds;

    public InvestmentsResultDivision(Map<InvestmentFund, Integer> amountsAssignedToFunds, int divisibleAmount, int notDividedAmount) {
        this.notDividedAmount = notDividedAmount;
        this.amountsAssignedToFunds = amountsAssignedToFunds;
        this.percantageOfAmountsAssignedToFunds = amountsAssignedToFunds.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> ((entry.getValue() * 100) / (double)divisibleAmount) ));
    }

    public int getNotDividedAmount() {
        return notDividedAmount;
    }

    public Map<InvestmentFund, Integer> getAmountsAssignedToFunds() {
        return amountsAssignedToFunds;
    }

    public Map<InvestmentFund, Double> getPercantageOfAmountsAssignedToFunds() {
        return percantageOfAmountsAssignedToFunds;
    }
}
