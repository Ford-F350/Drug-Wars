import java.util.Scanner;

public class GameController {

    protected CityController Cities;
    protected TrenchCoat Coat;
    protected Events Events;
    protected LoanShark loanShark;
    //singleton class
    private static GameController single_instance = null;

    private GameController() {
        this.Cities = new CityController();
        this.Coat = new TrenchCoat();
        this.Events = new Events();
        this.loanShark = new LoanShark();
    }

    public static GameController getInstance() {
        if (single_instance == null) {
            single_instance = new GameController();
        }
        return single_instance;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("press enter to start");
        //cheat code
        if (scan.toString().equals("testCheatCode")) {
            customStart();
        } else {
            getInstance();
        }
    }

    private static void customStart() {
        //custom game start values
    }

    public CityController getCities() {
        return Cities;
    }

    public void setCities(CityController cities) {
        Cities = cities;
    }

    public TrenchCoat getCoat() {
        return Coat;
    }

    public void setCoat(TrenchCoat coat) {
        Coat = coat;
    }

    public Events getEvents() {
        return Events;
    }

    public void setEvents(Events events) {
        Events = events;
    }
}
