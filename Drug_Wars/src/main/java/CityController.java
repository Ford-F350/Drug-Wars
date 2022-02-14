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
            this.currentLocation = currentLocation;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }


}
