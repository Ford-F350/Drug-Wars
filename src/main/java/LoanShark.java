public class LoanShark {

    private int debt;
    //InterestRate is per day. default is 5%
    private int interestRate;

    public LoanShark() {
        this.debt = 0;
        this.interestRate = 5;
    }

    public LoanShark(int InterestRate) {
        this.debt = 0;
        this.interestRate = InterestRate;
    }

    public void updateDebt() {
        this.debt *= (1 + interestRate /100);
    }

    public int getDebt() {
        return debt;
    }

    private void setDebt(int debt) {
        this.debt = debt;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }
}
