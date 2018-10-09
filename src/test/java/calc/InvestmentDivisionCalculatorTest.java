package calc;

import data.InvestmentFundsTestData;
import org.junit.Test;
import style.BalancedInvestmentStyle;
import style.RiskyInvestmentStyle;
import style.SafeInvestmentStyle;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvestmentDivisionCalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfProvidedAmountIsNegative() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new SafeInvestmentStyle(),
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                -2
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfProvidedInvestmentListDoesNotContainAllRequiredData() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new SafeInvestmentStyle(),
                InvestmentFundsTestData.THIRD_INVESTMENTS,
                3
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();
    }

    @Test
    public void testSafeStyle() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new SafeInvestmentStyle(),
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                10001
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();

        assertResults(
                Arrays.asList(1000, 1000, 2500, 2500, 2500, 500),
                Arrays.asList(10.0, 10.0, 25.0, 25.0, 25.0, 5.0),
                1,
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                result
        );
    }

    @Test
    public void testRiskyStyle() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new RiskyInvestmentStyle(),
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                10004
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();

        assertResults(
                Arrays.asList(2000, 2000, 668, 666, 666, 4000),
                Arrays.asList(20.0, 20.0, 6.68, 6.66, 6.66, 40.0),
                4,
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                result
        );
    }

    @Test
    public void testBalancedStyle() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new BalancedInvestmentStyle(),
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                10099
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();

        assertResults(
                Arrays.asList(1514, 1513, 2018, 2018, 2018, 1009),
                Arrays.asList(15.0, 15.0, 20.0, 20.0, 20.0, 10.0),
                9,
                InvestmentFundsTestData.FIRST_INVESTMENTS,
                result
        );
    }

    @Test
    public void testSafeStyleWithNotDivisibleAmountForFundType() {
        InvestmentDivisionCalculator calculator = new InvestmentDivisionCalculator(
                new SafeInvestmentStyle(),
                InvestmentFundsTestData.SECOND_INVESTMENTS,
                10000
        );

        InvestmentsResultDivision result = calculator.calculateMoneyAllocation();

        assertResults(
                Arrays.asList(668, 666, 666, 3750, 3750, 500),
                Arrays.asList(6.68, 6.66, 6.66, 37.5, 37.5, 5.0),
                0,
                InvestmentFundsTestData.SECOND_INVESTMENTS,
                result
        );
    }

    private void assertResults(List<Integer> expectedAmounts, List<Double> expectedPercanteges, int expectedRemaining,
                               InvestmentsList investmentsList, InvestmentsResultDivision result) {
        int i = 0;
        for(Integer expectedResult : expectedAmounts) {
            assertEquals(expectedResult, result.getAmountsAssignedToFunds().get(investmentsList.investmentFunds.get(i)));
            i++;
        }

        i = 0;
        for(Double expectedPercantage : expectedPercanteges) {
            assertEquals(expectedPercantage, result.getPercantageOfAmountsAssignedToFunds().get(investmentsList.investmentFunds.get(i)), 0.009);
            i++;
        }

        assertEquals(expectedRemaining, result.getNotDividedAmount());
    }
}
