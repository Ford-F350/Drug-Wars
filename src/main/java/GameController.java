import java.util.Scanner;

public class GameController {

    protected CityController Cities;
    protected TrenchCoat Coat;
    protected Events Events;

    public GameController() {
        this.Cities = new CityController();
        this.Coat = new TrenchCoat();
        this.Events = new Events();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("press enter to start");
        //cheat code
        if (scan.equals("")) {
            GameController gameController = new GameController();
        } else {
            GameController gameController = new GameController();
        }
    }


}
