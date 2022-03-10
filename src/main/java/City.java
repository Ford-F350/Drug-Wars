import java.util.ArrayList;

public class City {

    //city class for keeping local prices and market lean

    private Drugs weed;
    private Drugs cocaine;
    private Drugs heroin;
    private Drugs acid;
    private Drugs speed;
    private Drugs drugs;
    private ArrayList<Drugs> drugList = new ArrayList<>();

    public City() {
        this.weed = new Drugs();
        this.heroin = new Drugs();
        this.acid = new Drugs();
        this.speed = new Drugs();
        this.drugs = new Drugs();
        this.cocaine = new Drugs();
        defaultStart();
        drugList.add(this.weed);
        drugList.add(this.heroin);
        drugList.add(this.acid);
        drugList.add(this.speed);
        drugList.add(this.drugs);
        drugList.add(this.cocaine);

    }

    /*default starting drug stats

                Price  Lean
       1 Weed   | 80  |  .15
       2 Heroin | 100  | .1
       3 Acid   | 60  | .2
       4 Speed  | 40  | .3
       5 Ludes  | 50  | .25
       6 Cocaine| 120 | 0

     */
    private void defaultStart() {
        this.weed.setPrice(80);
        this.weed.setName("Weed");
        this.weed.setLean(.15);

        this.heroin.setPrice(100);
        this.heroin.setName("Heroin");
        this.heroin.setLean(.1);

        this.acid.setPrice(60);
        this.acid.setName("Acid");
        this.acid.setLean(.2);

        this.speed.setPrice(40);
        this.speed.setName("Speed");
        this.speed.setLean(.3);

        this.drugs.setPrice(50);
        this.drugs.setName("Ludes");
        this.drugs.setLean(.25);

        this.cocaine.setPrice(120);
        this.cocaine.setName("Cocaine");
        this.cocaine.setLean(0);

    }

    public Drugs getDrug(String name) {
        for (Drugs e: this.drugList) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Drugs> getDrugList() {
        return drugList;
    }
}
