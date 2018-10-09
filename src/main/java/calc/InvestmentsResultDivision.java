package calc;

import fund.InvestmentFund;

import java.util.Map;
import java.util.stream.Collectors;

public class InvestmentsResultDivision {

    private int notDividedAmount;

    private Map<InvestmentFund, Integer> amountsAssignedToFunds;

    private Map<InvestmentFund, Integer> percantageOfAmountsAssignedToFunds;

    public InvestmentsResultDivision(Map<InvestmentFund, Integer> amountsAssignedToFunds, int amount, int notDividedAmount) {
        this.notDividedAmount = notDividedAmount;
        this.amountsAssignedToFunds = amountsAssignedToFunds;
        this.percantageOfAmountsAssignedToFunds = amountsAssignedToFunds.entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> (entry.getValue() / amount) * 100));
    }

    public int getNotDividedAmount() {
        return notDividedAmount;
    }

    public Map<InvestmentFund, Integer> getAmountsAssignedToFunds() {
        return amountsAssignedToFunds;
    }

    public Map<InvestmentFund, Integer> getPercantageOfAmountsAssignedToFunds() {
        return percantageOfAmountsAssignedToFunds;
    }
}
