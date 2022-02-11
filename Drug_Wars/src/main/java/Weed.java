public class Weed extends Drugs {

    public Weed() {

    }

    public Weed(int price, double lean, int amount) {
        super(price, lean, amount);
    }

    public void updateWeed() {
        super.updateDrug();
    }

    public int getAmount() {
        return super.getAmount();
    }

    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    public int getPrice() {
        return super.getPrice();
    }

    public double getLean() {
        return super.getLean();
    }

    public void setPrice(int price) {
        super.setPrice(price);
    }

    public void setLean(double lean) {
        super.setLean(lean);
    }

}
