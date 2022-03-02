public class CityController {

    //manager for all the cities
    // currentLocation var
    // 0 = manhattan
    // 1 = theBronx
    // 2 = Brooklyn

   private int currentLocation;
   private City Manhattan;
   private City TheBronx;
   private City Brooklyn;
   private static CityController single_instance = null;

    private CityController() {
        this.currentLocation = 0;
        this.Manhattan = new City();
        this.Brooklyn = new City();
        this.TheBronx = new City();
    }


    public CityController getCityControllerInstance() {
        if (single_instance == null) {
            single_instance = new CityController();
        }
        return single_instance;
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

    public double getLocalLean(String name) {
        return getCurrentCity().getDrug(name).getLean();
    }

    public void setLocalLean(String name, double localLean) {
        getCurrentCity().getDrug(name).setLean(localLean);
    }

    public int getPrice(String name) {
        return getCurrentCity().getDrug(name).getPrice();
    }

    public void setPrice(String name, int price) {
        getCurrentCity().getDrug(name).setPrice(price);
    }

    public void rollMarket(String name) {
        getCurrentCity().getDrug(name).updateDrug();
    }

    public void rollEventDrug(String name) {
        getCurrentCity().rollEvent(getCurrentCity().getDrug(name));
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
