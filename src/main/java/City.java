import java.util.ArrayList;

public class City {

    //city class for keeping local prices and market lean

    private Drugs Weed;
    private Drugs Cocaine;
    private Drugs Heroin;
    private Drugs Acid;
    private Drugs Speed;
    private Drugs Ludes;
    private Events Events;
    private ArrayList<Drugs> DrugList;

    public City() {
        this.Weed = new Drugs();
        this.Heroin = new Drugs();
        this.Acid = new Drugs();
        this.Speed = new Drugs();
        this.Ludes = new Drugs();
        this.Cocaine = new Drugs();
        this.Events = Events.getEventsInstance();
        defaultStart();
        DrugList.add(this.Weed);
        DrugList.add(this.Heroin);
        DrugList.add(this.Acid);
        DrugList.add(this.Speed);
        DrugList.add(this.Ludes);
        DrugList.add(this.Cocaine);

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
        this.Weed.setPrice(80);
        this.Weed.setName("Weed");
        this.Weed.setLean(.15);

        this.Heroin.setPrice(100);
        this.Heroin.setName("Heroin");
        this.Heroin.setLean(.1);

        this.Acid.setPrice(60);
        this.Acid.setName("Acid");
        this.Acid.setLean(.2);

        this.Speed.setPrice(40);
        this.Speed.setName("Speed");
        this.Speed.setLean(.3);

        this.Ludes.setPrice(50);
        this.Ludes.setName("Ludes");
        this.Ludes.setLean(.25);

        this.Cocaine.setPrice(120);
        this.Cocaine.setName("Cocaine");
        this.Cocaine.setLean(0);

    }

    public Drugs getDrug(String name) {
        for (Drugs e: this.DrugList) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Drugs> getDrugList() {
        return DrugList;
    }

    public void rollEvent(Drugs drug){
        this.Events.eventRoll(drug);
    }
}
