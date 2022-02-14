public class CityController {

    //manager for all the cities
    // currentLocation var
    // 0 = manhattan
    // 1 = theBronx
    // 2 = Brooklyn

    protected int currentLocation;
    protected City Manhattan;
    protected City TheBronx;
    protected City Brooklyn;

    public CityController() {
        this.currentLocation = 0;
        this.Manhattan = new City();
        this.Brooklyn = new City();
        this.TheBronx = new City();
    }

    public CityController(int currentLocation) {
        if (currentLocation < 0 || currentLocation > 2){
            this.currentLocation = 0;
        } else
        this.currentLocation = currentLocation;
        this.Manhattan = new City();
        this.Brooklyn = new City();
        this.TheBronx = new City();
    }

    public void changeCity(int location) {
        if (currentLocation < 0 || currentLocation > 2){
            this.currentLocation = 0;
        } else
            this.currentLocation = location;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public double getLocalLean() {
        return getCurrentCity().getLocalLean();
    }

    public void setLocalLean(double localLean) {
        getCurrentCity().setLocalLean(localLean);
    }

    public int getPrice() {
        return getCurrentCity().getPrice();
    }

    public void setPrice(int price) {
        getCurrentCity().setPrice(price);
    }

    public void rollMarket() {
        getCurrentCity().rollMarket();
    }

    public void rollEventDrug() {
        getCurrentCity().rollEvent();
    }

    public City getCurrentCity() {
        if (this.currentLocation == 0) {
            return Manhattan;
        } else if (this.currentLocation == 1) {
            return TheBronx;
        }
        return Brooklyn;
    }


}
