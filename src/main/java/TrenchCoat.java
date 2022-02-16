import java.util.ArrayList;

public class TrenchCoat {

    // keeps track of all item the player has

    protected ArrayList<Guns> Guns;
    protected ArrayList<Drugs> Drugs;
    protected int money;

    public TrenchCoat() {
        this.money = 0;
        this.Guns = new ArrayList<>();
        this.Drugs = new ArrayList<>();
    }

    public TrenchCoat(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
