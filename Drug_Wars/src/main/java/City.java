public class City {

    //city class for keeping local prices and market lean

    protected double localLean;
    protected int weedPrice;

    public City() {
        this.localLean = 0;
        this.weedPrice = 0;
    }

    public City(double localLean, int weedPrice) {
        this.localLean = localLean;
        this.weedPrice = weedPrice;
    }

    public double getLocalLean() {
        return localLean;
    }

    public void setLocalLean(double localLean) {
        this.localLean = localLean;
    }

    public int getWeedPrice() {
        return weedPrice;
    }

    public void setWeedPrice(int weedPrice) {
        this.weedPrice = weedPrice;
    }
}
