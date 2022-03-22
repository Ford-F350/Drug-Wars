import java.lang.Math;
import java.util.ArrayList;

public class Market {

    // simulates a market by randomly using prices relative to there current price
    // lean can sway them to be more likely to go up or down in price

    private int price;
    private double lean;
    private ArrayList<Integer> pricesList;

    public Market() {
        this.price = 1;
        this.lean = 0;
        this.pricesList = new ArrayList<>();
        this.pricesList.add(1);
    }

    public Market(int price, double lean) {
        if (price <= 0) {
            this.price = 1;
        } else {
            this.price = price;
        }
        this.lean = lean;
        this.pricesList = new ArrayList<>();
        this.pricesList.add(this.price);
    }

    // new price = currentPrice + (random number between (-0.5 and 0.5) + lean) * CurrentPrice
    // increases and decreases in price are greater depending on current price
    public void updateMarket() {
        price += (Math.random() + lean - .5) * price;
        if (price == 0) {
            price += 5;
        }
        this.pricesList.add(this.price);
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

    public ArrayList<Integer> getPricesList() {
        return pricesList;
    }
}
