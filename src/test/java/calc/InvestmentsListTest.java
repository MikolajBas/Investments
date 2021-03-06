package calc;

import data.InvestmentFundsTestData;
import fund.FundType;
import fund.InvestmentFund;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvestmentsListTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfProvidedListIsEmpty() {
        InvestmentsList investmentsList = new InvestmentsList(null);
    }

    @Test
    public void checkQuantityCalculation() {
        int polishQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.POLISH);
        int foreignQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.FOREIGN);
        int moneyQuantity = InvestmentFundsTestData.FIRST_INVESTMENTS.countFundQuantityForType(FundType.MONEY);

        assertEquals(2, polishQuantity);
        assertEquals(3, foreignQuantity);
        assertEquals(1, moneyQuantity);
    }

    @Test
    public void checkGettingInvestmentsByType() {
        List<InvestmentFund> polishInvestments
                = InvestmentFundsTestData.FIRST_INVESTMENTS.getInvestmentFundsByFundType(FundType.POLISH);

        assertEquals(2, polishInvestments.size());
        assertEquals(InvestmentFundsTestData.FIRST_SET_POLISH1, polishInvestments.get(0));
        assertEquals(InvestmentFundsTestData.FIRST_SET_POLISH2, polishInvestments.get(1));
    }
}
