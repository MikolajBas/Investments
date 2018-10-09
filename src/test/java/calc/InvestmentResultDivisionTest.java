package calc;

import data.InvestmentFundsTestData;
import fund.InvestmentFund;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InvestmentResultDivisionTest {

    @Test
    public void checkPercentageCalculation() {
        Map<InvestmentFund, Integer> data = new HashMap<>();
        data.put(InvestmentFundsTestData.FIRST_SET_POLISH1, 454);
        data.put(InvestmentFundsTestData.FIRST_SET_MONEY1, 255);
        data.put(InvestmentFundsTestData.FIRST_SET_FOREIGN1, 301);

        InvestmentsResultDivision investmentsResultDivision = new InvestmentsResultDivision(
                data, 1000, 0
        );

        assertEquals(45.4, investmentsResultDivision.getPercantageOfAmountsAssignedToFunds().get(InvestmentFundsTestData.FIRST_SET_POLISH1), 0.01);
        assertEquals(25.5, investmentsResultDivision.getPercantageOfAmountsAssignedToFunds().get(InvestmentFundsTestData.FIRST_SET_MONEY1), 0.01);
        assertEquals(30.1, investmentsResultDivision.getPercantageOfAmountsAssignedToFunds().get(InvestmentFundsTestData.FIRST_SET_FOREIGN1), 0.01);
    }
}
