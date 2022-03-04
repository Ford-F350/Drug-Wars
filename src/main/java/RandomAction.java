
public class RandomAction {

    private int eventsRolled;
    private static RandomAction single_instance = null;

    //Picks Random things that will change the prices of drugs, money owned, and other random events

    private RandomAction(){
        this.eventsRolled = 0;
    }

    public RandomAction getRandomActionInstance() {
        if (single_instance == null) {
            single_instance = new RandomAction();
        }
        return single_instance;
    }

    public int ActionRoll(Drugs drugs) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            priceGain(drugs);
            this.eventsRolled++;
            return 1;
        } else if (i == 2){
            priceLoss(drugs);
            this.eventsRolled++;
            return 2;
        }
        this.eventsRolled++;
        return 2;
    }

    public int ActionRoll(TrenchCoat inv) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            moneyGain(inv);
            this.eventsRolled++;
            return 1;
        } else if (i == 2){
            moneyLoss(inv);
            this.eventsRolled++;
            return 2;
        } else if (i == 3){
            drugGain(inv);
            this.eventsRolled++;
            return 3;
        } else if (i == 4){
            drugLoss(inv);
            this.eventsRolled++;
            return 4;
        }
        this.eventsRolled++;
        return -1;
    }

    public int copRoll() {
        int i = (int)(Math.random() * 10)+ 1;
        if (i == 1) {
            copFight();
            this.eventsRolled++;
        }
        this.eventsRolled++;
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

    private void drugGain(TrenchCoat inv) {
        int i = (int)(Math.random() * inv.DrugCount() + 1);
        inv.getDrugsAtIndex(i).setAmount(inv.getDrugsAtIndex(i).getAmount() + ((int)(Math.random() * 10) + 1));
    }

    private void drugLoss(TrenchCoat inv) {
        int i = (int)(Math.random() * inv.DrugCount() + 1);
        inv.getDrugsAtIndex(i).setAmount(inv.getDrugsAtIndex(i).getAmount() - ((int)(Math.random() * 10) + 1));
        if (inv.getDrugsAtIndex(i).getAmount() < 0) {
            inv.getDrugsAtIndex(i).setAmount(0);
        }
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
