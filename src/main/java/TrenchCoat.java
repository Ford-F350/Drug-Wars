import java.util.ArrayList;
import java.util.Scanner;

public class TrenchCoat {

    // keeps track of all item the player has
    // also tracks players health. default is 10
    // default max invSpace is 100;

    private ArrayList<Guns> gunList;
    private ArrayList<Drugs> drugList;
    private int money;
    private int health;
    private int invSpace;
    private int maxInvSpace;
    private static TrenchCoat single_instance = null;
    private static Scanner scan = new Scanner(System.in);


    private TrenchCoat() {
        this.money = 2000;
        this.gunList = new ArrayList<>();
        this.drugList = new ArrayList<>();
        this.health = 10;
        this.invSpace = 0;
        this.maxInvSpace = 100;
    }

    private TrenchCoat(int money, int health, int MaxInvSpace) {
        this.money = money;
        this.health = Math.max(0,health);
        this.invSpace = Math.max(0, MaxInvSpace);
    }

    public static TrenchCoat getTrenchCoatInstance() {
        if (single_instance == null) {
            single_instance = new TrenchCoat();
        }
        return single_instance;
    }

    public int checkInvSpace(int i) {
        if ((this.invSpace + i) > this.maxInvSpace) {
            return -1;
        }
        return 1;
    }

    //TODO: finnish trench coat inventory overflow management
    private void invOverflow(int i) {
            System.out.println("TrenchCoat is full, either throw away" + ((this.invSpace + i) - this.maxInvSpace) + "items or only take what you can hold");
            System.out.println("1 to edit TrenchCoat | 2 to accept what you can hold");
            int input = scan.nextInt();
            if (input != 1 && input != 2){
                invalidInputException();
            }
            if (input == 1) {

            }
    }

    private void invalidInputException() {
        throw new IllegalArgumentException("Invalid Input, Please enter a valid input");
    }

    // Gun functions

    public void addGun(Guns gun) {
        this.gunList.add(gun);
    }

    public ArrayList<Guns> getGunList() {
        return gunList;
    }

    public Guns getGunsAtIndex(int index) {
        return gunList.get(index);
    }

    public int GunCount() {
        return this.gunList.size();
    }

    // Drug functions

    public void addDrug(Drugs drug) {
        this.drugList.add(drug);
    }

    public ArrayList<Drugs> getDrugList() {
        return drugList;
    }

    public Drugs getDrugsAtIndex(int index) {
        return drugList.get(index);
    }

    public int DrugCount() {
        return this.drugList.size();
    }

    //Money Functions

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //Health / invSpace functions

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getInvSpace() {
        return invSpace;
    }

    public void setInvSpace(int invSpace) {
        this.invSpace = invSpace;
    }
}
