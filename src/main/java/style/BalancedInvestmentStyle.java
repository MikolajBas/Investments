package style;

import fund.FundType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BalancedInvestmentStyle implements InvestmentStyle {

    private Map<FundType, Double> divisionRatios;

    public BalancedInvestmentStyle() {
        Map<FundType, Double> temp = new EnumMap(FundType.class);
        temp.put(FundType.POLISH, 0.3);
        temp.put(FundType.FOREIGN, 0.6);
        temp.put(FundType.MONEY, 0.1);
        this.divisionRatios = Collections.unmodifiableMap(temp);
    }

    public Map<FundType, Double> getDivisionRatios() {
        return divisionRatios;
    }
}
