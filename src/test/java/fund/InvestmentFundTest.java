package fund;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class InvestmentFundTest {

    private final InvestmentFund FIRST_FUND = InvestmentFund.createFund(1l, "name1", FundType.POLISH);

    private final InvestmentFund SECOND_FUND = InvestmentFund.createFund(1l, "name2", FundType.FOREIGN);

    private final InvestmentFund THIRD_FUND = InvestmentFund.createFund(2l, "name1", FundType.POLISH);

    @Test
    public void checkEquals() {
        assertTrue(FIRST_FUND.equals(SECOND_FUND));
        assertFalse(FIRST_FUND.equals(THIRD_FUND));
    }

}
