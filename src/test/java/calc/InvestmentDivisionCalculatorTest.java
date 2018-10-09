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
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(new SafeInvestmentStyle());
        InvestmentFund first = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);
        InvestmentFund second = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);
        InvestmentFund third = InvestmentFund.createFund(3l, "Fundusz Zagraniczny 1", FundType.FOREIGN);
        InvestmentFund fourth = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 2", FundType.FOREIGN);
        InvestmentFund fifth = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 3", FundType.FOREIGN);
        InvestmentFund sixth = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);
        Map results = calculator.calculateMoneyAllocation(new InvestmentsList(
                Arrays.asList(
                        first,
                        second,
                        third,
                        fourth,
                        fifth,
                        sixth
                )), 10001
        );
        assertEquals(1000, results.get(first));
        assertEquals(1000, results.get(second));
        assertEquals(2500, results.get(third));
        assertEquals(2500, results.get(fourth));
        assertEquals(2500, results.get(fifth));
        assertEquals(500, results.get(sixth));
    }

    @Test
    public void secondTest() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(new SafeInvestmentStyle());
        InvestmentFund first = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);
        InvestmentFund second = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);
        InvestmentFund third = InvestmentFund.createFund(3l, "Fundusz Polski 3", FundType.POLISH);
        InvestmentFund fourth = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 1", FundType.FOREIGN);
        InvestmentFund fifth = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 2", FundType.FOREIGN);
        InvestmentFund sixth = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);
        Map results = calculator.calculateMoneyAllocation(new InvestmentsList(
                Arrays.asList(
                        first,
                        second,
                        third,
                        fourth,
                        fifth,
                        sixth
                )), 10001
        );
        assertEquals(668, results.get(first));
        assertEquals(666, results.get(second));
        assertEquals(666, results.get(third));
        assertEquals(3750, results.get(fourth));
        assertEquals(3750, results.get(fifth));
        assertEquals(500, results.get(sixth));
    }

}
