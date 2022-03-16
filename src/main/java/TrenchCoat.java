import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Method;

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

    //returns how many items adding int i to inventory would overflow or 0 if it will fit
    public int checkInvSpace(int i) {
        if ((this.invSpace + i) > this.maxInvSpace) {
            return (this.invSpace + i) - this.maxInvSpace;
        }
        return 0;
    }

    //TODO: finnish trench coat inventory overflow management
    //always begin call with boolean being true
    private void invOverflow(int addedItems) {

        System.out.println("TrenchCoat is full, either throw away" + ((this.invSpace + addedItems) - this.maxInvSpace) + "items or only take what you can hold");
        System.out.println("1 to remove items from TrenchCoat | 2 to accept what you can hold");

        int input = testUserInput(2);

        trenchCoatItemRemove(addedItems, input);

    }

    private void trenchCoatItemRemove(int addedItems, int input) {
        if (input == 1) {
            System.out.println("1 to remove Drugs | 2 to remove Guns | 3 to go back");
            int CoatInput = testUserInput(3);

            if (CoatInput == 1) {
                System.out.println("Witch Drug would you like to remove");
                for (Drugs drugs: this.drugList){
                    System.out.print(drugs.getName() + ", ");
                }
                int drugIndex = getDrugPlayerIndex();

                System.out.println("");
                System.out.println("How much would you like to remove");
                System.out.println(((this.invSpace + addedItems) - maxInvSpace) + "items left to remove");

                getDrugsAtIndex(drugIndex).removeDrugAmount(testUserInput(getDrugsAtIndex(drugIndex).getAmount()));

                System.out.println("Remove more or accept what you can hold");
                System.out.println("1 to Remove more items | 2 to accept what you can hold");
                if (testUserInput(2) == 1) {
                    trenchCoatItemRemove(addedItems, 1);
                } else trenchCoatItemRemove(addedItems, 2);
            }

            if (CoatInput == 2) {
                //TODO: convert to work with guns instead of drugs
//                System.out.println("Witch Gun would you like to remove");
//                for (Guns guns: this.gunList){
//                    System.out.print(guns.getName() + ", ");
//                }
//                int GunIndex = getDrugPlayerIndex();
//
//                System.out.println("");
//                System.out.println("How much would you like to remove");
//                System.out.println(((this.invSpace + addedItems) - maxInvSpace) + "items left to remove");
//
//                getDrugsAtIndex(drugIndex).removeDrugAmount(testUserInput(getDrugsAtIndex(drugIndex).getAmount()));
//
//                System.out.println("Remove more or accept what you can hold");
//                System.out.println("1 to Remove more items | 2 to accept what you can hold");
//                if (testUserInput(2) == 1) {
//                    trenchCoatItemRemove(addedItems, 1);
//                } else trenchCoatItemRemove(addedItems, 2);
            }
        }
    }

    public int getDrugPlayerIndex() {
        while (true) {
            try {
                int index = 0;
                String inputName = scan.nextLine();
                for (Drugs e : this.drugList) {
                    if (e.getName().equals(inputName)) {
                        return index;
                    }
                    index++;
                }
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {

            }
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
