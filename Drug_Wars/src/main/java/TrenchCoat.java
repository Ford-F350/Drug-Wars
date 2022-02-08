public class TrenchCoat {

    private int weedAmount;

    public TrenchCoat() {
        this.weedAmount = 0;
    }

    public TrenchCoat(int weedAmount) {
        if (weedAmount < 0) {
            this.weedAmount = 0;
        } else  {
            this.weedAmount = weedAmount;
        }
    }

    public int getWeedAmount() {
        return weedAmount;
    }

    public void setWeedAmount(int weedAmount) {
        this.weedAmount = weedAmount;
    }
}
