public class City {

    //city class for keeping local prices and market lean

    protected Weed Weed;
    protected Events Events;

    public City() {
        this.Weed = new Weed();
        this.Events = new Events();
    }

    public City(double localLean, int weedPrice) {
        this.Weed = new Weed();
        this.Events = new Events();
    }

    public double getLocalLean() {
        return Weed.getLean();
    }

    public void setLocalLean(double localLean) {
        this.Weed.setLean(localLean);
    }

    public int getPrice() {
        return Weed.getPrice();
    }

    public void setPrice(int price) {
        this.Weed.setPrice(price);
    }

    public void rollMarket(){
        this.Weed.updateDrug();
    }

    public void rollEvent(){
        this.Events.eventRoll(Weed);
    }
}
