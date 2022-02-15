public class City {

    protected int location;
    protected double localLean;
    protected int weedPrice;

    public City() {
        this.location = 0;
        this.localLean = 0;
        this.weedPrice = 0;
    }

    public City(int location, double localLean, int weedPrice) {
        this.location = location;
        this.localLean = localLean;
        this.weedPrice = weedPrice;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
