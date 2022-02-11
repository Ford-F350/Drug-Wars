public class Events {

    public Events(){

    }

    public void eventRoll(TrenchCoat inv, Drugs drugs) {
        int i = (int)(Math.random() * 9) + 1;
        if (i == 1) {
            moneyGain(inv);
        } else if (i == 2) {
            moneyLoss(inv);
        } else if (i == 3) {
            priceGain(drugs);
        } else if (i == 4){
            priceLoss(drugs);
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
