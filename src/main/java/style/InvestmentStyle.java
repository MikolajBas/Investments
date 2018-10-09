package style;

import fund.FundType;

import java.util.Map;

public interface InvestmentStyle {

    Map<FundType, Double> getDivisionRatios();
}
