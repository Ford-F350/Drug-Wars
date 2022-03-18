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

    //checks if a certiain amount of items will fit. if they dont it will prompt the user to make more space or accept what they can fit.
    //returns a int of how many items can be added into the Trenchcoat, -1 for all items
    public int checkInvSpace(int addedItems) {
        if ((getInvSpace() + addedItems) > this.maxInvSpace) {
            invOverflow(addedItems);
        }
        return -1;
    }

    //TODO: finnish trench coat inventory overflow management
    private int invOverflow(int addedItems) {

        System.out.println("TrenchCoat is full, either throw away" + ((getInvSpace() + addedItems) - this.maxInvSpace) + "items or only take what you can hold");
        System.out.println("1 to remove items from TrenchCoat | 2 to accept what you can hold");

        int input = testUserInput(2);

        return trenchCoatItemRemove(addedItems, input);
    }

    private int trenchCoatItemRemove(int addedItems, int input) {
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
                System.out.println(((getInvSpace() + addedItems) - maxInvSpace) + "items left to remove");

                getDrugsAtIndex(drugIndex).removeDrugAmount(testUserInput(getDrugsAtIndex(drugIndex).getAmount()));

                System.out.println("Remove more or accept what you can hold");
                System.out.println("1 to Remove more items | 2 to accept what you can hold");
                if (testUserInput(2) == 1) {
                    trenchCoatItemRemove(addedItems, 1);
                } else trenchCoatItemRemove(addedItems, 2);
            }

            if (CoatInput == 2) {
                System.out.println("Witch Gun would you like to remove");
                for (Guns guns: this.gunList){
                    System.out.print(guns.getName() + ", ");
                }
                int gunIndex = getGunPlayerIndex();
                this.gunList.remove(gunIndex);

                System.out.println(((getInvSpace() + addedItems) - maxInvSpace) + "items left to remove");

                System.out.println("Remove more or accept what you can hold");
                System.out.println("1 to Remove more items | 2 to accept what you can hold");
                if (testUserInput(2) == 1) {
                    trenchCoatItemRemove(addedItems, 1);
                } else trenchCoatItemRemove(addedItems, 2);
            }
        }
        else {
            if (getInvSpace() + addedItems <= this.maxInvSpace) {
                System.out.println("Adding items to TrenchCoat");
                return -1;
            } else {
                return this.maxInvSpace - getInvSpace();
            }
        }
        //something went wrong if it returns this
        return -2;
    }

    public int getGunPlayerIndex() {
        while (true) {
            try {
                int index = 0;
                String inputName = scan.nextLine();
                for (Guns e: this.gunList) {
                    if (e.getName().equals(inputName)){
                        return index;
                    }
                    index++;
                }
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {

            }
        }
    }

    public int getDrugPlayerIndex() {
        while (true) {
            try {
                int index = 0;
                String inputName = scan.nextLine();
                for (Drugs e: this.drugList) {
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
        int invSpace = 0;
        for (Drugs e: this.drugList) {
            invSpace += e.getAmount();
        }
        for (Guns e: this.gunList) {
            invSpace++;
        }
        this.invSpace = invSpace;
        return this.invSpace;
    }

    public void setInvSpace(int invSpace) {
        this.invSpace = invSpace;
    }
}
