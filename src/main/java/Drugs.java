public class Drugs {

    protected Market market;
    protected int price;
    protected double lean;
    protected int amount;
    protected String name;

    // keeps track of its own price, lean, and amount owned
    // every drug has its own market class for price management


    public Drugs() {
        this.market = new Market();
        this.amount = 0;
        this.price = 0;
        this.lean = 0;
        this.name = "NULL";
    }

    public Drugs(int price, double lean, int amount,String name) {
        this.market = new Market(price, lean);
        this.amount = Math.max(amount, 0);
        this.price = price;
        this.lean = lean;
        this.name = name;
    }

    public void updateDrug() {
        market.updateMarket();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return market.getPrice();
    }

    public double getLean() {
        return market.getLean();
    }

    public void setPrice(int price) {
        this.market.setPrice(price);
    }

    public void setLean(double lean) {
        this.market.setLean(lean);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
