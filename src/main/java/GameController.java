import java.util.Scanner;

public class GameController {

    private CityController Cities;
    private TrenchCoat Coat;
    private Events Events;
    private LoanShark loanShark;
    //singleton class
    private static GameController single_instance = null;
    private static Scanner scan = new Scanner(System.in);

    private GameController() {
        this.Cities = Cities.getCityControllerInstance();
        this.Coat = TrenchCoat.getTrenchCoatInstance();
        this.loanShark = new LoanShark();
    }

    public static GameController getInstance() {
        if (single_instance == null) {
            single_instance = new GameController();
        }
        return single_instance;
    }


    public static void main(String[] args) {
        System.out.println("press enter to start");
        //cheat code
        if (scan.nextLine().equals("testCheatCode")) {
            customStart();
        } else {
            getInstance();
        }
    }

    private static void customStart() {
        getInstance();
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
}
