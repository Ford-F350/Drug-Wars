public class TrenchCoat {

    private int weedAmount;
    private int money;

    public TrenchCoat() {
        this.weedAmount = 0;
        this.money = 0;
    }

    public TrenchCoat(int weedAmount, int money) {
        this.weedAmount = Math.max(weedAmount, 0);
        this.money = money;
    }

    public int getWeedAmount() {
        return weedAmount;
    }

    public void setWeedAmount(int weedAmount) {
        this.weedAmount = weedAmount;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
