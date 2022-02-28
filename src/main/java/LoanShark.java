public class LoanShark {

    protected int Debt;
    //InterestRate is per day. default is 5%
    protected int InterestRate;

    public LoanShark() {
        this.Debt = 0;
        this.InterestRate = 5;
    }

    public LoanShark(int InterestRate) {
        this.Debt = 0;
        this.InterestRate = InterestRate;
    }

    public int getDebt() {
        return Debt;
    }

    private void setDebt(int debt) {
        Debt = debt;
    }

    public int getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(int interestRate) {
        InterestRate = interestRate;
    }
}