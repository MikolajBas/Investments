package calc;

import fund.FundType;
import fund.InvestmentFund;
import style.InvestmentStyle;

import java.util.*;

public class InvestmentDivisionCalculator {

    public static final int MODULO_HUNDRED_LIMIT = 100;

    private InvestmentStyle investmentStyle;

    private InvestmentsList investmentsList;

    private int amount;

    public InvestmentDivisionCalculator(InvestmentStyle investmentStyle, InvestmentsList investmentsList, int amount) {
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
        return new InvestmentsResultDivision(results, amount, remainingValue);
    }

    private Map<InvestmentFund, Integer> calculateAllocationForFundType(int divisibleAmount, FundType fundType, double divisionRatioForFundType) {
        Map<InvestmentFund, Integer> results = new HashMap<>();

        Integer quantityByFundType = investmentsList.countFundQuantityForType(fundType);
        List<InvestmentFund> investmentFundsByFundType = investmentsList.getInvestmentFundsByFundType(fundType);

        int amountForFundType = (int)(divisibleAmount * divisionRatioForFundType);
        int amountForInvestmentsExceptFirst =
                quantityByFundType != 0 ? amountForFundType / quantityByFundType : 0;
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
        while(!divisible || substractVal == MODULO_HUNDRED_LIMIT) {
            divisibleAmount = divisibleAmount - substractVal;
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
