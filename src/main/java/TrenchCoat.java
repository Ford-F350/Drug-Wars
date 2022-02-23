import java.util.ArrayList;

public class TrenchCoat {

    // keeps track of all item the player has
    // also tracks players health. default is 10

    protected ArrayList<Guns> Guns;
    protected ArrayList<Drugs> Drugs;
    protected int money;
    protected int health;

    public TrenchCoat() {
        this.money = 0;
        this.Guns = new ArrayList<>();
        this.Drugs = new ArrayList<>();
        this.health = 10;
    }

    public TrenchCoat(int money, int health) {
        this.money = money;
        this.health = Math.max(0,health);
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

    //Health functions

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
