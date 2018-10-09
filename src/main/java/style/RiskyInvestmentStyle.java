package style;

import fund.FundType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class RiskyInvestmentStyle implements InvestmentStyle {

    private Map<FundType, Double> divisionRatios;

    public RiskyInvestmentStyle() {
        Map<FundType, Double> temp = new EnumMap(FundType.class);
        temp.put(FundType.POLISH, 0.4);
        temp.put(FundType.FOREIGN, 0.2);
        temp.put(FundType.MONEY, 0.4);
        this.divisionRatios = Collections.unmodifiableMap(temp);
    }

    public Map<FundType, Double> getDivisionRatios() {
        return divisionRatios;
    }
}
