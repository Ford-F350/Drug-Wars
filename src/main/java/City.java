public class City {

    //city class for keeping local prices and market lean

    protected Drugs Weed;
    protected Drugs Cocaine;
    protected Drugs Heroin;
    protected Drugs Acid;
    protected Drugs Speed;
    protected Drugs Ludes;
    protected Events Events;

    public City() {
        this.Weed = new Drugs();
        this.Heroin = new Drugs();
        this.Acid = new Drugs();
        this.Speed = new Drugs();
        this.Ludes = new Drugs();
        this.Cocaine = new Drugs();
        this.Events = new Events();
        defaultStart();
    }

    /*default starting drug stats

                Price  Lean
       1 Weed   | 80  |  .15
       2 Heroin | 90  | .1
       3 Acid   | 60  | .2
       4 Speed  | 40  | .3
       5 Ludes  | 50  | .25
       6 Cocaine| 100 | 0

     */
    private void defaultStart() {
        this.Weed.setPrice(100);
    }

    private Drugs getDrug(int i) {
        return this.Weed; // undone
    }

    public double getLocalLean(String DrugName) {
        return 0.0; //undone
    }

    public void setLocalLean(double localLean) {
        this.Weed.setLean(localLean);
    }

    public int getPrice() {
        return Weed.getPrice();
    }

    public void setPrice(int price) {
        this.Weed.setPrice(price);
    }

    public void rollMarket(){
        this.Weed.updateDrug();
    }

    public void rollEvent(){
        this.Events.eventRoll(Weed);
    }
}
