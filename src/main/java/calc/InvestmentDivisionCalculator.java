package calc;

import fund.FundType;
import fund.InvestmentFund;
import style.InvestmentStyle;

import java.util.*;

public class InvestmentDivisionCalculator {

    private InvestmentStyle investmentStyle;

    private InvestmentsList investmentsList;

    private int amount;

    public InvestmentDivisionCalculator(InvestmentStyle investmentStyle, InvestmentsList investmentsList, int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be positive number");
        }
        this.investmentStyle = investmentStyle;
        this.investmentsList = investmentsList;
        this.amount = amount;
    }

    public InvestmentsResultDivision calculateMoneyAllocation() {
        Map<FundType, Double> divisionRatiosForFundTypes = investmentStyle.getDivisionRatios();

        Collection<Double> divisionRatiosValues = divisionRatiosForFundTypes.values();
        int divisibleAmount = getDivisibleAmount(divisionRatiosValues);

        Map<InvestmentFund, Integer> results = new HashMap<>();
        for(Map.Entry<FundType, Double> divisionRatiosForFundType : divisionRatiosForFundTypes.entrySet()) {
            results.putAll(
                    calculateAllocationForFundType(divisibleAmount, divisionRatiosForFundType.getKey(), divisionRatiosForFundType.getValue())
            );
        }

        int remainingValue = amount - divisibleAmount;
        return new InvestmentsResultDivision(results, divisibleAmount, remainingValue);
    }

    private Map<InvestmentFund, Integer> calculateAllocationForFundType(int divisibleAmount, FundType fundType, double divisionRatioForFundType) {
        Map<InvestmentFund, Integer> results = new HashMap<>();

        Integer quantityByFundType = investmentsList.countFundQuantityForType(fundType);
        if(quantityByFundType == 0) {
            throw new IllegalArgumentException("Investments list must contain all investment types required for investment style");
        }
        List<InvestmentFund> investmentFundsByFundType = investmentsList.getInvestmentFundsByFundType(fundType);

        int amountForFundType = (int)(divisibleAmount * divisionRatioForFundType);
        int amountForInvestmentsExceptFirst = amountForFundType / quantityByFundType;
        int remainingValue = amountForFundType - (amountForInvestmentsExceptFirst * quantityByFundType);
        int amountForFirstInvestment = amountForInvestmentsExceptFirst + remainingValue;

        Iterator<InvestmentFund> iterator = investmentFundsByFundType.iterator();
        InvestmentFund first = iterator.next();
        results.put(first, amountForFirstInvestment);
        while (iterator.hasNext()) {
            InvestmentFund next = iterator.next();
            results.put(next, amountForInvestmentsExceptFirst);
        }
        return results;
    }

    private int getDivisibleAmount(Collection<Double> divisionRatiosValues) {
        int divisibleAmount = amount;
        boolean divisible = false;
        int substractVal = 0;

        //simplest solution, the worst scenario is that we need to substract 99 from start amount to get divisible amount
        //more efficient is to utilize GCD, but that requires much more code
        while(!divisible) {
            divisibleAmount = amount - substractVal;
            divisible = true;

            for(Double divisionRatioValue : divisionRatiosValues) {
                divisible = isDivisible(divisibleAmount, divisionRatioValue);
                if(!divisible) {
                    break;
                }
            }
            substractVal++;
        }

        return divisibleAmount;
    }

    private boolean isDivisible(int divisibleAmount, Double divisionRatioValue) {
        return Math.floor((divisibleAmount * divisionRatioValue)) == (divisibleAmount * divisionRatioValue);
    }
}
