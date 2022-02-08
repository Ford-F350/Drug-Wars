import java.lang.Math;

public class Market {

    private int price;
    private double lean;

    public Market() {
        this.price = 1;
        this.lean = 0;
    }

    public Market(int price, double lean) {
        if (price <= 0) {
            this.price = 1;
        } else {
            this.price = price;
        }
        this.lean = lean;
    }

    public void updateMarket() {
        price += (Math.random() + lean - .5) * price;
        if (price == 0) {
            price += 5;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getLean() {
        return lean;
    }

    public void setLean(double lean) {
        this.lean = lean;
    }
}
