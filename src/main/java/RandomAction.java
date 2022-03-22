
public class RandomAction {

    private int eventsRolled;
    private static RandomAction single_instance = null;

    //Picks Random things that will change the prices of drugs, money owned, and other random events

    private RandomAction(){
        this.eventsRolled = 0;
    }

    public static RandomAction getRandomActionInstance() {
        if (single_instance == null) {
            single_instance = new RandomAction();
        }
        return single_instance;
    }

    public int getRandomDrugIndex() {
        return (int)(Math.random() * TrenchCoat.getTrenchCoatInstance().DrugCount());
    }

    //TODO: Clean up Random Action class to be more easily usable and understandable

    //
    public void actionRoll(Drugs drugs, TrenchCoat coat) {

    }

    public void actionRoll(Drugs drugs) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            priceGain(drugs);
            this.eventsRolled++;
        } else if (i == 2){
            priceLoss(drugs);
            this.eventsRolled++;
        }
        this.eventsRolled++;
    }

    public void actionRoll(TrenchCoat inv) {
        int i = (int)(Math.random() * 10) + 1;
        if (i == 1) {
            moneyGain(inv);
            this.eventsRolled++;
        } else if (i == 2){
            moneyLoss(inv);
            this.eventsRolled++;
        } else if (i == 3){
            drugGain(inv);
            this.eventsRolled++;
        } else if (i == 4){
            drugLoss(inv);
            this.eventsRolled++;
        }
        this.eventsRolled++;
    }

    //TODO:build cop fighting method
    public void copRoll() {
        int i = (int)(Math.random() * 10)+ 1;
        if (i == 1) {
            copCount();
            this.eventsRolled++;
        }
        this.eventsRolled++;
    }

    private int copCount() {
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

    //TODO: rewrite random actions with text and to tell the user what they got

    // pass in all strings to chose from as one string separated by "~"
    private String pickRandomSentence(String sentences) {
        String[] splitSentences = sentences.split("/");
        int randomInt = (int) (Math.random() * splitSentences.length);
        return splitSentences[randomInt];
    }

    private void drugGain(TrenchCoat inv) {
        System.out.print(pickRandomSentence("While walking around you come across some drugs on the ground/" +
                "You find a dead man and search his pockets to find some drugs/" +
                "A dog approaches you with some drugs in its mouth"));
        int i = getRandomDrugIndex();
        inv.getDrugsAtIndex(i).setAmount(inv.getDrugsAtIndex(i).getAmount() + ((int)(Math.random() * 10) + 1));
    }

    private void drugLoss(TrenchCoat inv) {
        int i = getRandomDrugIndex();
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
