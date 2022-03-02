public class LoanShark {

    private int Debt;
    //InterestRate is per day. default is 5%
    private int InterestRate;

    public LoanShark() {
        this.Debt = 0;
        this.InterestRate = 5;
    }

    public LoanShark(int InterestRate) {
        this.Debt = 0;
        this.InterestRate = InterestRate;
    }

    public void updateDebt() {
        this.Debt *= (1 + InterestRate/100);
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
