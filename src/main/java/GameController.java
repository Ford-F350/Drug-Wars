import java.util.Scanner;

public class GameController {

    private int daysPast;
    //singleton class
    private static GameController single_instance = null;
    private static Scanner scan = new Scanner(System.in);
    private LoanShark LoanShark;

    private GameController() {
        CityController.getCityControllerInstance();
        TrenchCoat.getTrenchCoatInstance();
        RandomAction.getRandomActionInstance();
        this.LoanShark = new LoanShark();
        this.daysPast = 0;
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
            customStart(0, 0);
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
    //TODO: make builder class for decision trees
    public void dayStart() {
        if (this.daysPast > 0) {
            int i = RandomAction.getRandomActionInstance().getRandomDrugIndex();
            RandomAction.getRandomActionInstance().actionRoll(TrenchCoat.getTrenchCoatInstance().getDrugsAtIndex(i));
        }

    }

    private static void customStart(int i, int i1) {
        try {
            getInstance();
            if (i == 0) {
                System.out.println("Enter Player Health");
            }
            i = 1;
            if (i1 == 0) {
                single_instance.getCoat().setHealth(scan.nextInt());
            }
            i1 = 1;
            if (i == 1) {
                System.out.println("Enter Player Inventory Space");
            }
            i = 2;
            if (i1 == 1) {
                single_instance.getCoat().setInvSpace(scan.nextInt());
            }
            i1 = 2;
            if (i == 2) {
                System.out.println("Enter Starting Money");
            }
            i = 3;
            if (i1 == 2) {
                single_instance.getCoat().setMoney(scan.nextInt());
            }
            i1 = 3;

        } catch (Exception e) {
            customStart(i, i1);
        }
    }

    public int testUserInput(int choicesAmount) {
        while (true) {
            try {
                int input = scan.nextInt();
                if (input >= 1 && input <= choicesAmount) {
                    return input;
                }
                throw new ArithmeticException();
            } catch (Exception e) {

            }
        }
    }

    public CityController getCities() {
        return CityController.getCityControllerInstance();
    }

    public TrenchCoat getCoat() {
        return TrenchCoat.getTrenchCoatInstance();
    }
}
