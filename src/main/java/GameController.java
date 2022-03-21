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
    //TODO: make builder class for decision trees
    public void dayStart() {
        if (this.daysPast > 0) {
            //random action at start of every day
        }
        //moves to main menu where player can choose what to do in day
        mainMenu();

    }

    private void mainMenu() {
    }

    private static void customStart() {
        getInstance();

        System.out.println("Enter Player Health");
        while (true) {
            try {
                single_instance.getCoat().setHealth(Math.max(0, scan.nextInt()));
            } catch (Exception e) {

            }
            break;
        }

        System.out.println("Enter Player Inventory Space");
        while (true) {
            try {
                single_instance.getCoat().setInvSpace(Math.max(0, scan.nextInt()));
            } catch (Exception e) {

            }
            break;
        }

        System.out.println("Enter Starting Money");
        while (true) {
            try {
                single_instance.getCoat().setMoney(scan.nextInt());
            } catch (Exception e) {

            }
            break;
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
