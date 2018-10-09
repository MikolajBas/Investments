package calc;

import fund.FundType;
import fund.InvestmentFund;
import style.InvestmentStyle;

import java.util.*;

public class InvestmentDivisionCalculator {

    private InvestmentStyle investmentStyle;

    public InvestmentDivisionCalculator(InvestmentStyle investmentStyle) {
        this.investmentStyle = investmentStyle;
    }

    public Map calculateMoneyAllocation(InvestmentsList investmentsList, int amount) {
        Map<FundType, Double> divisionRatios = investmentStyle.getDivisionRatios();
        Collection<Double> divisionRatiosValues = divisionRatios.values();
        int divisibleAmount = amount;
        for(int i = 0; i < 100; i++) {
            divisibleAmount = divisibleAmount - i;
            boolean divisible = true;
            for(Double drv : divisionRatiosValues) {
                if(Math.floor((divisibleAmount * drv)) != (divisibleAmount * drv)) {
                    divisible = false;
                    break;
                }
            }
            if(divisible) {
                break;
            }
        }
        int remainingValue = amount - divisibleAmount;
        Map<InvestmentFund, Integer> results = new HashMap<>();
//        Map<FundType, Integer> quantityByType = investmentsList.countQuantityByType();
        for(Map.Entry<FundType, Double> divisionRatio : divisionRatios.entrySet()) {
            Integer quantityByFundType = investmentsList.countQuantity(divisionRatio.getKey());
            List<InvestmentFund> investmentFundsByFundType = investmentsList.getInvestmentFundsByFundType(divisionRatio.getKey());
            int amountByFundType = (int)(divisibleAmount * divisionRatio.getValue());
            int amountForType = amountByFundType / quantityByFundType;
            int value = amountByFundType - (amountForType * quantityByFundType);
            Iterator<InvestmentFund> iterator = investmentFundsByFundType.iterator();
            InvestmentFund first = iterator.next();
            int last = amountForType + value;
            results.put(first, last);
            while (iterator.hasNext()) {
                InvestmentFund next = iterator.next();
                results.put(next, amountForType);
            }
        }
        return results;
    }
}
