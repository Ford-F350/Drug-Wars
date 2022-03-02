
public class Events {

    private int eventsRolled;
    private static Events single_instance = null;

    //Picks Random things that will change the prices of drugs, money owned, and other random events

    private Events(){
        this.eventsRolled = 0;
    }

    public Events getEventsInstance() {
        if (single_instance == null) {
            single_instance = new Events();
        }
        return single_instance;
    }


    public void eventRoll(Drugs drugs) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            priceGain(drugs);
        } else if (i == 2){
            priceLoss(drugs);
        }
        this.eventsRolled++;
    }

    public void eventRoll(TrenchCoat inv) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            moneyGain(inv);
        } else if (i == 2){
            moneyLoss(inv);
        } else if (i == 3){
            //TODO: add more drug functions
        }
    }

    public int copRoll() {
        int i = (int)(Math.random() * 10)+ 1;
        if (i == 1) {
            copFight();
        }
        return -1;
    }

    private int copFight() {
        int i = (int) (Math.random() * 3) + 1;
        if (i == 1) {
            return 1;
        } else if (i == 2) {
            if (eventsRolled > 10) {
                return 2;
            }
        } else if (i == 3) {
            if (eventsRolled > 20) {
                return 3;
            }
        }
        return -1;
    }

    private void DrugGain(TrenchCoat inv) {
        int i = (int)(Math.random() * inv.DrugCount() + 1);
        inv.getDrugsAtIndex(i).setAmount(inv.getDrugsAtIndex(i).getAmount() + ((int)((Math.random() - .5) * 50) + 1));
    }

    private void moneyLoss(TrenchCoat inv) {
        inv.setMoney(inv.getMoney() - ((int)(Math.random() * 200) + 1));
    }

    public void moneyGain(TrenchCoat inv) {
        inv.setMoney(inv.getMoney() + ((int)(Math.random() * 200) + 1));
    }

    public void priceGain(Drugs drugs){
        drugs.setPrice(drugs.getPrice() + ((int)(Math.random() * 200) + 1));
    }

    public void priceLoss(Drugs drugs){
        drugs.setPrice(drugs.getPrice() - ((int)(Math.random() * 200) + 1));
        if (drugs.getPrice() < 1) {
            drugs.setPrice(1);
        }
    }

}
