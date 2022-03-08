import java.util.Scanner;

public class GameController {

    private int DaysPast;
    //singleton class
    private static GameController single_instance = null;
    private static Scanner scan = new Scanner(System.in);

    private GameController() {
        CityController.getCityControllerInstance();
        TrenchCoat.getTrenchCoatInstance();
        RandomAction.getRandomActionInstance();
        LoanShark loanShark = new LoanShark();
        this.DaysPast = 0;
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
        if (scan.nextLine().equals("a")) {
            customStart();
        } else {
            getInstance();
        }
    }

    /*
    Day Structure:
    - RandomAction may happen (not on first day)
    - Choice of buying, selling, borrowing cash, seeing prices
      When buying or selling there is a chane a cop will show up
    - end day by moving cites or waiting till next day
     */
    public void dayStart() {
        if (this.DaysPast > 0) {
            int i = RandomAction.getRandomActionInstance().getRandomDrugIndex();
            RandomAction.getRandomActionInstance().ActionRoll(TrenchCoat.getTrenchCoatInstance().getDrugsAtIndex(i));
        }
    }

    private static void customStart() {
        getInstance();
        System.out.println("Enter Player Health");
        single_instance.getCoat().setHealth(scan.nextInt());
        System.out.println("Enter Player Inventory Space");
        single_instance.getCoat().setInvSpace(scan.nextInt());
        System.out.println("Enter Starting Money");
        single_instance.getCoat().setMoney(scan.nextInt());
    }

    public CityController getCities() {
        return CityController.getCityControllerInstance();
    }

    public TrenchCoat getCoat() {
        return TrenchCoat.getTrenchCoatInstance();
    }
}
