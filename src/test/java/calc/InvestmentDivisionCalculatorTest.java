package calc;

import fund.FundType;
import fund.InvestmentFund;
import org.junit.Test;
import style.SafeInvestmentStyle;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InvestmentDivisionCalculatorTest {

    @Test
    public void firstTest() {
        InvestmentFund first = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);
        InvestmentFund second = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);
        InvestmentFund third = InvestmentFund.createFund(3l, "Fundusz Zagraniczny 1", FundType.FOREIGN);
        InvestmentFund fourth = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 2", FundType.FOREIGN);
        InvestmentFund fifth = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 3", FundType.FOREIGN);
        InvestmentFund sixth = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(new SafeInvestmentStyle(),
                new InvestmentsList(
                        Arrays.asList(
                                first,
                                second,
                                third,
                                fourth,
                                fifth,
                                sixth
                        )),
                10001
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();
        assertEquals(1000, (int)result.getAmountsAssignedToFunds().get(first));
        assertEquals(1000, (int)result.getAmountsAssignedToFunds().get(second));
        assertEquals(2500, (int)result.getAmountsAssignedToFunds().get(third));
        assertEquals(2500, (int)result.getAmountsAssignedToFunds().get(fourth));
        assertEquals(2500, (int)result.getAmountsAssignedToFunds().get(fifth));
        assertEquals(500, (int)result.getAmountsAssignedToFunds().get(sixth));
    }

    @Test
    public void secondTest() {
        InvestmentFund first = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);
        InvestmentFund second = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);
        InvestmentFund third = InvestmentFund.createFund(3l, "Fundusz Polski 3", FundType.POLISH);
        InvestmentFund fourth = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 1", FundType.FOREIGN);
        InvestmentFund fifth = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 2", FundType.FOREIGN);
        InvestmentFund sixth = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);

        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(new SafeInvestmentStyle(),
                new InvestmentsList(
                    Arrays.asList(
                            first,
                            second,
                            third,
                            fourth,
                            fifth,
                            sixth
                    )),
                10001
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();
        assertEquals(668, (int)result.getAmountsAssignedToFunds().get(first));
        assertEquals(666, (int)result.getAmountsAssignedToFunds().get(second));
        assertEquals(666, (int)result.getAmountsAssignedToFunds().get(third));
        assertEquals(3750, (int)result.getAmountsAssignedToFunds().get(fourth));
        assertEquals(3750, (int)result.getAmountsAssignedToFunds().get(fifth));
        assertEquals(500, (int)result.getAmountsAssignedToFunds().get(sixth));
    }

}
