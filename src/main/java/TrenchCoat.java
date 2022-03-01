import java.util.ArrayList;

public class TrenchCoat {

    // keeps track of all item the player has
    // also tracks players health. default is 10
    // default max invSpace is 100;

    protected ArrayList<Guns> Guns;
    protected ArrayList<Drugs> Drugs;
    protected int money;
    protected int health;
    protected int invSpace;
    private static TrenchCoat single_instance = null;

    private TrenchCoat() {
        this.money = 2000;
        this.Guns = new ArrayList<>();
        this.Drugs = new ArrayList<>();
        this.health = 10;
        this.invSpace = 100;
    }

    private TrenchCoat(int money, int health, int invSpace) {
        this.money = money;
        this.health = Math.max(0,health);
        this.invSpace = Math.max(0, invSpace);
    }

    public static TrenchCoat getInstance() {
        if (single_instance == null) {
            single_instance = new TrenchCoat();
        }
        return single_instance;
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
