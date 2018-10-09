package data;

import calc.InvestmentsList;
import fund.FundType;
import fund.InvestmentFund;

import java.util.Arrays;

public class InvestmentFundsTestData {

    /**
     * first data set
     */
    public static final InvestmentFund FIRST_SET_POLISH1 = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);

    public static final InvestmentFund FIRST_SET_POLISH2 = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);

    public static final InvestmentFund FIRST_SET_FOREIGN1 = InvestmentFund.createFund(3l, "Fundusz Zagraniczny 1", FundType.FOREIGN);

    public static final InvestmentFund FIRST_SET_FOREIGN2 = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 2", FundType.FOREIGN);

    public static final InvestmentFund FIRST_SET_FOREIGN3 = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 3", FundType.FOREIGN);

    public static final InvestmentFund FIRST_SET_MONEY1 = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);

    public static final InvestmentsList FIRST_INVESTMENTS = new InvestmentsList(
            Arrays.asList(
                FIRST_SET_POLISH1,
                FIRST_SET_POLISH2,
                FIRST_SET_FOREIGN1,
                FIRST_SET_FOREIGN2,
                FIRST_SET_FOREIGN3,
                FIRST_SET_MONEY1
            ));

    /**
     * second data set
     */
    public static final InvestmentFund SECOND_SET_POLISH1 = InvestmentFund.createFund(1l, "Fundusz Polski 1", FundType.POLISH);

    public static final InvestmentFund SECOND_SET_POLISH2 = InvestmentFund.createFund(2l, "Fundusz Polski 2", FundType.POLISH);

    public static final InvestmentFund SECOND_SET_POLISH3 = InvestmentFund.createFund(3l, "Fundusz Polski 3", FundType.POLISH);

    public static final InvestmentFund SECOND_SET_FOREIGN1 = InvestmentFund.createFund(4l, "Fundusz Zagraniczny 1", FundType.FOREIGN);

    public static final InvestmentFund SECOND_SET_FOREIGN2 = InvestmentFund.createFund(5l, "Fundusz Zagraniczny 2", FundType.FOREIGN);

    public static final InvestmentFund SECOND_SET_MONEY1 = InvestmentFund.createFund(6l, "Fundusz Pieniężny 1", FundType.MONEY);

    public static final InvestmentsList SECOND_INVESTMENTS = new InvestmentsList(
            Arrays.asList(
                    SECOND_SET_POLISH1,
                    SECOND_SET_POLISH2,
                    SECOND_SET_POLISH3,
                    SECOND_SET_FOREIGN1,
                    SECOND_SET_FOREIGN2,
                    SECOND_SET_MONEY1
            ));

    private InvestmentFundsTestData() {}

}
