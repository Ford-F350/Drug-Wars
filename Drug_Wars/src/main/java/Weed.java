public class Weed {

    private Market weedMarket;
    private int amount;

    public Weed() {
        this.weedMarket = new Market();
        this.amount = 0;
    }

    public Weed(int price, double lean, int amount) {
        this.weedMarket = new Market(price, lean);
        if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }

    public void updateWeed() {
        weedMarket.updateMarket();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return weedMarket.getPrice();
    }

    public double getLean() {
        return weedMarket.getLean();
    }

    public void setPrice(int price) {
        this.weedMarket.setPrice(price);
    }

    public void setLean(double lean) {
        this.weedMarket.setLean(lean);
    }

}
