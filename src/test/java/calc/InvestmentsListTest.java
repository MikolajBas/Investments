package calc;

import data.InvestmentFundsTestData;
import fund.FundType;
import fund.InvestmentFund;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvestmentsListTest {

    @Test
    public void checkQuantityCalculation() {
        int polishQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.POLISH);
        int foreignQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.FOREIGN);
        int moneyQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.MONEY);

        assertEquals(polishQuantity, 2);
        assertEquals(foreignQuantity, 3);
        assertEquals(moneyQuantity, 1);
    }

    @Test
    public void checkGettingInvestmentsByType() {
        List<InvestmentFund> polishInvestments
                = InvestmentFundsTestData.FIRST_INVESTMENTS.getInvestmentFundsByFundType(FundType.POLISH);

        assertEquals(polishInvestments.size(), 2);
        assertEquals(InvestmentFundsTestData.FIRST_SET_POLISH1, polishInvestments.get(0));
        assertEquals(InvestmentFundsTestData.FIRST_SET_POLISH2, polishInvestments.get(1));
    }
}
