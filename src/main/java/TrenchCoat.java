import java.util.ArrayList;

public class TrenchCoat {

    // keeps track of all item the player has
    // also tracks players health. default is 10
    // default max invSpace is 100;

    private ArrayList<Guns> Guns;
    private ArrayList<Drugs> Drugs;
    private int money;
    private int health;
    private int invSpace;
    private int MaxInvSpace;
    private static TrenchCoat single_instance = null;

    private TrenchCoat() {
        this.money = 2000;
        this.Guns = new ArrayList<>();
        this.Drugs = new ArrayList<>();
        this.health = 10;
        this.invSpace = 0;
        this.MaxInvSpace = 100;
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

    private int checkInvSpace(int i) {
        if ((invSpace + i) > MaxInvSpace) {
            return -1;
        }
        return 1;
    }

    // Gun functions

    public void addGun(Guns gun) {
        this.Guns.add(gun);
    }

    public ArrayList<Guns> getGuns() {
        return Guns;
    }

    public Guns getGunsAtIndex(int index) {
        return Guns.get(index);
    }

    public int GunCount() {
        return this.Guns.size();
    }

    // Drug functions

    public void addDrug(Drugs drug) {
        this.Drugs.add(drug);
    }

    public ArrayList<Drugs> getDrugs() {
        return Drugs;
    }

    public Drugs getDrugsAtIndex(int index) {
        return Drugs.get(index);
    }

    public int DrugCount() {
        return this.Drugs.size();
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
